package Controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import Models.HoKhau;
import Models.NhanKhau;
import Models.ThanhVienCuaHo;
import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;


public class ThemHoKhauController implements Initializable  {

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
    private HoKhau newHoKhau;
    private HoKhauController hoKhauController;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ngaySinhDatePicker.setValue(LocalDate.now());

        BooleanBinding ismaHoKhauFieldEmpty =thuongTruField.textProperty().isEmpty();
        BooleanBinding ishohoTenFieldEmpty =hoTenField.textProperty().isEmpty();
        BooleanBinding iscMNFieldEmpty = cMNField.textProperty().isEmpty();
        BooleanBinding areTextFieldsEmpty = ismaHoKhauFieldEmpty.or(ishohoTenFieldEmpty).or(iscMNFieldEmpty);

        saveButton.disableProperty().bind(areTextFieldsEmpty);
    }


    @FXML
    protected void Submit(ActionEvent e) {

        String maHoKhau = createMaHoKhau();
        newNhanKhau = new NhanKhau(0, hoTenField.getText(), cMNField.getText(), ngaySinhDatePicker.getValue(), gioiTinBox.getValue().toString(), queQuanField.getText(), thuongTruField.getText(), danTocBox.getValue().toString(), ngheNghiepField.getText(), 1);
        String maNhanKhau = "xl";
        newtThanhVienCuaHo = new ThanhVienCuaHo(maNhanKhau, maHoKhau, "Chủ Hộ");
        newHoKhau = new HoKhau(maHoKhau, newNhanKhau.getHoTen(), newNhanKhau.getCccd(), newNhanKhau.getThuongTru());
        hoKhauController.addList(newHoKhau);
        Alert infoAlert = new Alert(AlertType.INFORMATION);
        infoAlert.setHeaderText("Tạo Nhân Khẩu Thành Công");
        infoAlert.setContentText("Bạn đã tạo thành công một Hộ Khẩu có mã " + maHoKhau);
        
        infoAlert.showAndWait();
        Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        stage.close();
    }

    private String createMaHoKhau() {
        return "55.767";
    }


    public HoKhauController getHoKhauController() {
        return hoKhauController;
    }


    public void setHoKhauController(HoKhauController hoKhauController) {
        this.hoKhauController = hoKhauController;
    }

    
    
}
