package Controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

import Models.HoKhau;
import Models.NhanKhau;
import Models.ThanhVienCuaHo;
import View.nhap;
import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class SuaHoKhauController implements Initializable{
   @FXML
   TextField hoTenField;

   @FXML
   DatePicker ngaySinhDatePicker;

   @FXML
   TextField cMNField;

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
   Button saveButton;

    private NhanKhau newNhanKhau;
    private HoKhauController hoKhauController;
    private HoKhau hoKhauEdit;




    public HoKhau getHoKhauEdit() {
        return hoKhauEdit;
    }

    public void setHoKhauEdit(HoKhau hoKhauEdit) {
        this.hoKhauEdit = hoKhauEdit;
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        
       

        BooleanBinding ismaHoKhauFieldEmpty =thuongTruField.textProperty().isEmpty();
        BooleanBinding ishohoTenFieldEmpty =hoTenField.textProperty().isEmpty();
        BooleanBinding iscMNFieldEmpty = cMNField.textProperty().isEmpty();
        BooleanBinding areTextFieldsEmpty = ismaHoKhauFieldEmpty.or(ishohoTenFieldEmpty).or(iscMNFieldEmpty);

        saveButton.disableProperty().bind(areTextFieldsEmpty);
    }

    @FXML
    protected void Submit(ActionEvent e) throws SQLException {
        //System.out.println(danTocBox.getValue());
        String maNKChuHo = hoKhauController.getMaNKChuHo();

        
        Connection conn = SQLController.getConnection(SQLController.DB_URL, SQLController.USER_NAME, SQLController.PASSWORD);
        Statement stmt = conn.createStatement();
        String query = "UPDATE dbo.NhanKhau SET HoTen = N'" + hoTenField.getText() + "', CCCD = '" + cMNField.getText() + "', NgaySinh = '" + ngaySinhDatePicker.getValue().toString() 
        + "', GioiTinh = N'" +  gioiTinBox.getValue().toString() + "', QueQuan = N'" + queQuanField.getText()+"', ThuongTru = N'" + thuongTruField.getText() + "', Dantoc = N'" + danTocBox.getValue().toString()
        + "', NgheNghiep = '"  + ngheNghiepField.getText() +"' WHERE MaNhanKhau = '" + maNKChuHo + "'\n"
        + "UPDATE dbo.HoKhau SET	Diachi = N'" + thuongTruField.getText() 
        + "' WHERE MaNKChuHo = '" + maNKChuHo + "'";
        System.out.println(query);
        stmt.execute(query);
        conn.close();

        newNhanKhau = new NhanKhau(maNKChuHo, hoTenField.getText(), cMNField.getText(), ngaySinhDatePicker.getValue(), gioiTinBox.getValue().toString(), queQuanField.getText(),
        thuongTruField.getText(), danTocBox.getValue().toString(), ngheNghiepField.getText());
        HoKhau newHoKhau = new HoKhau(hoKhauEdit.getIdHoKhau(), hoTenField.getText(), maNKChuHo, cMNField.getText(), thuongTruField.getText());

        //System.out.println(selectNhanKhau.getHoTen());
        hoKhauController.editList(hoKhauEdit, newHoKhau);
        Alert infoAlert = new Alert(AlertType.INFORMATION);
        // NhanKhau nk = this.getNhanKhauEdit();

        infoAlert.setHeaderText("Sửa Hộ Khẩu Thành Công");
        
        infoAlert.showAndWait();
        Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        stage.close();
    }

    public HoKhauController getHoKhauController() {
        return hoKhauController;
    }

    public void setHoKhauController(HoKhauController hoKhauController) {
        this.hoKhauController = hoKhauController;
    }
    
}
