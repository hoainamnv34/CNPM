package Controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javafx.scene.control.Label;

import Models.NhanKhau;
import Models.ThanhVienCuaHo;
import View.nhap;
import javafx.beans.binding.BooleanBinding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ThemNhanKhauController implements Initializable{

    @FXML
    Label alertLabel;

    @FXML
    private TableView<ThanhVienCuaHo> tableView;

    @FXML
    private TableColumn<ThanhVienCuaHo, String> hoTen;

    @FXML
    private TableColumn<ThanhVienCuaHo, String> qHeChuHo;

    @FXML
    TextField maHoKhauField;

    @FXML
    TextField hoTenField;

    @FXML
    DatePicker ngaySinhDatePicker;

    @FXML
    TextField cccdField;

    @FXML
    TextField queQuanField;

    @FXML
    TextField thuongTruField;

    @FXML
    ChoiceBox gioiTinBox;

    @FXML
    ChoiceBox danTocBox; 

    @FXML
    TextField ngheNghiepField;

    @FXML
    ChoiceBox quanHeVoiChuHoBox;

    @FXML
    Button saveButton;

    

    private NhanKhau newNhanKhau;
    private NhanKhauController nhanKhauController;

   @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        ngaySinhDatePicker.setValue(LocalDate.now());

        BooleanBinding ismaHoKhauFieldEmpty =maHoKhauField.textProperty().isEmpty();
        BooleanBinding ishohoTenFieldEmpty =hoTenField.textProperty().isEmpty();
        BooleanBinding iscccdFieldEmpty = cccdField.textProperty().isEmpty();
        BooleanBinding areTextFieldsEmpty = ismaHoKhauFieldEmpty.or(ishohoTenFieldEmpty).or(iscccdFieldEmpty);
        saveButton.disableProperty().bind(areTextFieldsEmpty);
        
        
        maHoKhauField.textProperty().addListener((observable, oldValue, newValue)-> {
            List<ThanhVienCuaHo> tV = new ArrayList<ThanhVienCuaHo>();
            ObservableList<ThanhVienCuaHo> tVList;
           
            if(newValue.length() == 8){
                try {
                    Connection conn = SQLController.getConnection(SQLController.DB_URL, SQLController.USER_NAME, SQLController.PASSWORD);
                    Statement stmt = conn.createStatement();
                    String query = "SELECT NK.HoTen, TV.QuanHeVoiCH FROM dbo.NhanKhau AS  NK INNER JOIN dbo.ThanhVienCuaHo AS TV ON TV.MaNhanKhau = NK.MaNhanKhau WHERE TV.MaHoKhau = '"
                    + newValue + "'";
                    // System.out.println(query);
                    ResultSet rs = stmt.executeQuery(query);
                    if(!rs.next()) {
                        alertLabel.setText("Mã Hộ khẩu sai");

                    }else{
                        alertLabel.setText("Mã Hộ khẩu đúng");
                        do {
                            tV.add(new ThanhVienCuaHo(rs.getNString(1), rs.getNString(2)));
                        }while(rs.next());
                    }
                    tVList = FXCollections.observableArrayList(tV);
                    hoTen.setCellValueFactory(new PropertyValueFactory<ThanhVienCuaHo, String>("hoTen"));
                    qHeChuHo.setCellValueFactory(new PropertyValueFactory<ThanhVienCuaHo, String>("quanHeVoiChuHo"));
                    tableView.setItems(tVList);
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }else {
                alertLabel.setText("Mã Hộ khẩu có dạng: HK.xxxxx");
            }
        });
    }

    @FXML
    protected void Submit(ActionEvent e) {       
        try {
            Connection conn = SQLController.getConnection(SQLController.DB_URL, SQLController.USER_NAME, SQLController.PASSWORD);
            Statement stmt = conn.createStatement();
            String query = "SELECT COUNT(*) FROM dbo.ThanhVienCuaHo WHERE MaHoKhau = '" + maHoKhauField.getText() + "'";
            ResultSet rs = stmt.executeQuery(query);
            rs.next();
            int iDTrongHoKhau = rs.getInt(1) + 1;

            System.out.println("id trong ho Khau: " + iDTrongHoKhau);
            
            stmt = conn.createStatement();
            query = "SELECT TOP 1 MaNhanKhau FROM dbo.NhanKhau ORDER BY MaNhanKhau DESC";
            rs = stmt.executeQuery(query);
            rs.next();
            String input = rs.getString(1);
            System.out.println(input);
            int dotIndex = input.indexOf(".");
            String prefix = input.substring(0, dotIndex + 1);
            int number = Integer.parseInt(input.substring(dotIndex + 1).trim()) + 1;
            String maNhanKhau = (prefix + String.format("%05d", number)).trim();
            System.out.println("ma nhan khau" + maNhanKhau);


            query = "INSERT INTO dbo.NhanKhau (MaNhanKhau, HoTen, CCCD, NgaySinh, GioiTinh, QueQuan, ThuongTru, Dantoc, NgheNghiep) VALUES ( '"
            + maNhanKhau + " ', N'" + hoTenField.getText() +"', '" + cccdField.getText()  + "', '" + ngaySinhDatePicker.getValue().toString() + "', N'"
            + gioiTinBox.getValue().toString() +  "', N'" + queQuanField.getText() + "', N'" +  thuongTruField.getText() + "',N'"
            +  danTocBox.getValue().toString() + "', N'" + ngheNghiepField.getText() +   "')";
            stmt.execute(query);
        
            newNhanKhau = new NhanKhau(maNhanKhau, hoTenField.getText(), cccdField.getText(), ngaySinhDatePicker.getValue(), gioiTinBox.getValue().toString(),
            queQuanField.getText(), thuongTruField.getText(), danTocBox.getValue().toString(), ngheNghiepField.getText());
            nhanKhauController.addList(newNhanKhau);
            query = "INSERT INTO dbo.ThanhVienCuaHo(MaNhanKhau,MaHoKhau,QuanHeVoiCH,NoiThuongTruTruoc, MaTrongHoKhau)VALUES ('"
            +  maNhanKhau + "', '" + maHoKhauField.getText() + "',  N'" + quanHeVoiChuHoBox.getValue().toString() + "',N'" + "" + "'," + String.valueOf(iDTrongHoKhau) +")";
            stmt.execute(query);

            conn.close();
          
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        Alert infoAlert = new Alert(AlertType.INFORMATION);
        infoAlert.setHeaderText("Tạo Nhân Khẩu Thành Công");
        // infoAlert.setContentText("Tạo Nhân Khẩu Thành Công")
        infoAlert.showAndWait();
        Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        stage.close();
    }

    public NhanKhauController getNhanKhauController() {
        return nhanKhauController;
    }

    public void setNhanKhauController(NhanKhauController nhanKhauController) {
        this.nhanKhauController = nhanKhauController;
    }
}
