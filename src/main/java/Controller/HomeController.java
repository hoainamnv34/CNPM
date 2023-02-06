package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class HomeController implements Initializable {
    
    @FXML
    Button qLNhanKhauBtn;

    @FXML
    Button qLHoKhauBtn;

    @FXML
    Button qLTamTruBtn;

    @FXML
    Button qLTamVangBtn;

    @FXML
    Button qLPAKNBtn;

    @FXML
    VBox vBox;
    
    private Parent currentRoot;
    

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("NhanKhau.fxml"));
            Parent root = loader.load();
            currentRoot = root;
            vBox.getChildren().add(root);
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @FXML
    protected void nhanKhauChangeScene(ActionEvent event) {
        vBox.getChildren().remove(currentRoot);
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("NhanKhau.fxml"));
            Parent root = loader.load();
            currentRoot = root;
            vBox.getChildren().add(root);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @FXML
    protected void hoKhauChangeScene(ActionEvent event) {
        vBox.getChildren().remove(currentRoot);
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("HoKhau.fxml"));
            Parent root = loader.load();
            currentRoot = root;
            vBox.getChildren().add(root);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @FXML
    protected void tamTruChangeScene(ActionEvent event) {
        vBox.getChildren().remove(currentRoot);
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("TamTru.fxml"));
            Parent root = loader.load();
            currentRoot = root;
            vBox.getChildren().add(root);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @FXML
    protected void tamVangChangeScene(ActionEvent event) {
        vBox.getChildren().remove(currentRoot);
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("TamVang.fxml"));
            Parent root = loader.load();
            currentRoot = root;
            vBox.getChildren().add(root);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @FXML
    protected void phanAnhKienNghiChangeScene(ActionEvent event) {
        vBox.getChildren().remove(currentRoot);
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("HoKhau.fxml"));
            Parent root = loader.load();
            currentRoot = root;
            vBox.getChildren().add(root);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
