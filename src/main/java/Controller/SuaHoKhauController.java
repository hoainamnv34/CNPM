package Controller;

import java.net.URL;
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
    private ThanhVienCuaHo newtThanhVienCuaHo;
    private HoKhauController hoKhauController;
    private NhanKhau nhanKhauEdit;



    public NhanKhau getNhanKhauEdit() {
      return nhanKhauEdit;
   }

   public void setNhanKhauEdit(NhanKhau nhanKhauEdit) {
      this.nhanKhauEdit = nhanKhauEdit;
   }


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
      ngaySinhDatePicker.setValue(LocalDate.now());

      BooleanBinding ismaHoKhauFieldEmpty =thuongTruField.textProperty().isEmpty();
      BooleanBinding ishohoTenFieldEmpty =hoTenField.textProperty().isEmpty();
      BooleanBinding iscMNFieldEmpty = cMNField.textProperty().isEmpty();
      BooleanBinding areTextFieldsEmpty = ismaHoKhauFieldEmpty.or(ishohoTenFieldEmpty).or(iscMNFieldEmpty);

      saveButton.disableProperty().bind(areTextFieldsEmpty);
    }

    @FXML
    protected void Submit(ActionEvent e) {
        //System.out.println(danTocBox.getValue());
        String maHoKhau = "testID1503";
        newNhanKhau = new NhanKhau(0, hoTenField.getText(), cMNField.getText(), ngaySinhDatePicker.getValue(), gioiTinBox.getValue().toString(), queQuanField.getText(), thuongTruField.getText(), danTocBox.getValue().toString(), ngheNghiepField.getText(), 1);
        String maNhanKhau = "xl";
        newtThanhVienCuaHo = new ThanhVienCuaHo(maNhanKhau, maHoKhau, "Chủ Hộ");
        HoKhau newHoKhau = new HoKhau(maHoKhau, newNhanKhau.getHoTen(), newNhanKhau.getCccd(), newNhanKhau.getThuongTru());
        //System.out.println(selectNhanKhau.getHoTen());
        HoKhau selectHoKhau = hoKhauController.getSelectHoKhau();
        hoKhauController.editList(selectHoKhau, newHoKhau);
        Alert infoAlert = new Alert(AlertType.INFORMATION);
        //NhanKhau nk = this.getNhanKhauEdit();
        //System.out.println(nk.getHoTen());



        infoAlert.setHeaderText("Sửa Hộ Khẩu Thành Công");
        // infoAlert.setContentText("Tạo Nhân Khẩu Thành Công");
        
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
