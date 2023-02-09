package Controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

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

public class SuaNhanKhauController implements Initializable{
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
    private ThanhVienCuaHo newtThanhVienCuaHo;
    private NhanKhauController nhanKhauController;
    private NhanKhau nhanKhauEdit;



    public NhanKhau getNhanKhauEdit() {
      return nhanKhauEdit;
   }

   public void setNhanKhauEdit(NhanKhau nhanKhauEdit) {
      this.nhanKhauEdit = nhanKhauEdit;
   }

   public SuaNhanKhauController() {

   }


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        ngaySinhDatePicker.setValue(LocalDate.now());

        maHoKhauField.textProperty().addListener((observable, oldValue, newValue)-> {
            if(newValue.equals("1")){
                //System.out.println("hello");
            }
            
        });

        BooleanBinding ismaHoKhauFieldEmpty =maHoKhauField.textProperty().isEmpty();
        BooleanBinding ishohoTenFieldEmpty =hoTenField.textProperty().isEmpty();
        BooleanBinding iscccdFieldEmpty = cccdField.textProperty().isEmpty();
        BooleanBinding areTextFieldsEmpty = ismaHoKhauFieldEmpty.or(ishohoTenFieldEmpty).or(iscccdFieldEmpty);
        saveButton.disableProperty().bind(areTextFieldsEmpty);
        //maHoKhauField.setText(nhanKhauEdit.get);
        //hoTenField.setText(nhanKhauEdit.getHoTen());
        //NhanKhau nk = nhanKhauController.getSelectNhanKhau();
        //hoTenField.setText(nhanKhauEdit.getHoTen());
        //NhanKhauController controller = this.getNhanKhauController();
    }

    @FXML
    protected void Submit(ActionEvent e) {
        //System.out.println(danTocBox.getValue());
        newNhanKhau = new NhanKhau(1, hoTenField.getText(), cccdField.getText(), ngaySinhDatePicker.getValue(), gioiTinBox.getValue().toString(), queQuanField.getText(),
        thuongTruField.getText(), danTocBox.getValue().toString(), ngheNghiepField.getText()
        , 0);
        String maNhanKhau = "xl";
        newtThanhVienCuaHo = new ThanhVienCuaHo(maNhanKhau, maHoKhauField.getText(), quanHeVoiChuHoBox.getValue().toString());
        NhanKhau selectNhanKhau = nhanKhauController.getSelectNhanKhau();
        //System.out.println(selectNhanKhau.getHoTen());
        nhanKhauController.editList(selectNhanKhau, newNhanKhau);
        Alert infoAlert = new Alert(AlertType.INFORMATION);
        NhanKhau nk = this.getNhanKhauEdit();
        System.out.println(nk.getHoTen());
        infoAlert.setHeaderText("Sửa Nhân Khẩu Thành Công");
        // infoAlert.setContentText("Tạo Nhân Khẩu Thành Công");
        
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
