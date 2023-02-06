package Controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

import Models.NhanKhau;
import Models.ThanhVienCuaHo;
import View.nhap;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class ThemNhanKhauController implements Initializable{
    @FXML
    TextField maHoKhauField;

    @FXML
    TextField hoTenField;

    @FXML
    DatePicker ngaySinhDatePicker;

    @FXML
    TextField cMNField;

    @FXML
    TextField queQuanField;

    @FXML
    TextField noiSinhField;

    @FXML
    ChoiceBox gioiTinBox;

    @FXML
    ChoiceBox danTocBox; 

    @FXML
    ChoiceBox tonGiaoBox;

    @FXML
    TextField ngheNghiepField;

    @FXML
    ChoiceBox quanHeVoiChuHoBox;

    @FXML
    Button saveButton;

    private NhanKhau newNhanKhau;
    private ThanhVienCuaHo newtThanhVienCuaHo;



    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        ngaySinhDatePicker.setValue(LocalDate.now());

        maHoKhauField.textProperty().addListener((observable, oldValue, newValue)-> {
            if(newValue.equals("1")){
                System.out.println("hello");
            }
            
        });

        BooleanBinding ismaHoKhauFieldEmpty =maHoKhauField.textProperty().isEmpty();
        BooleanBinding ishohoTenFieldEmpty =hoTenField.textProperty().isEmpty();
        BooleanBinding iscMNFieldEmpty = cMNField.textProperty().isEmpty();
        BooleanBinding areTextFieldsEmpty = ismaHoKhauFieldEmpty.or(ishohoTenFieldEmpty).or(iscMNFieldEmpty);
        saveButton.disableProperty().bind(areTextFieldsEmpty);
    }

    @FXML
    protected void Submit(ActionEvent e) {
        System.out.println(danTocBox.getValue());
        newNhanKhau = new NhanKhau(1, hoTenField.getText(), cMNField.getText(), noiSinhField.getText(), queQuanField.getText(), danTocBox.getValue().toString(), ngheNghiepField.getText()
        , ngaySinhDatePicker.getValue(), gioiTinBox.getValue().toString(), 0);
        String maNhanKhau = "xl";
        newtThanhVienCuaHo = new ThanhVienCuaHo(maNhanKhau, maHoKhauField.getText(), quanHeVoiChuHoBox.getValue().toString());
        Alert infoAlert = new Alert(AlertType.INFORMATION);
        infoAlert.setHeaderText("Tạo Nhân Khẩu Thành Công");
        // infoAlert.setContentText("Tạo Nhân Khẩu Thành Công");
        infoAlert.show();
    }
    
    
}
