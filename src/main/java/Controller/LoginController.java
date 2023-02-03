package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import Models.UserMoldel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController implements Initializable {
    @FXML
    TextField userField;

    @FXML
    PasswordField passwordField;


    @FXML
    private Button loginButton ;

    boolean ck = true;

    UserMoldel userMoldel1 = new UserMoldel(1, "1", "1");



    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        loginButton.setDisable(true);

        userField.textProperty().addListener((observable, oldValue, newValue)-> {
            loginButton.setDisable(newValue.trim().isEmpty());

        });
    }

    @FXML
    protected void Submit (ActionEvent event) {
        if (userField.getText().equals(userMoldel1.getUserName()) && passwordField.getText().equals(userMoldel1.getPassword())) {
            System.out.println("true");
            try {
                changeSceneHome(event);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }else {
            String message = "Tên Đăng Nhập hoặc Mật Khẩu của bạn không chính xác";
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(message);
            alert.setContentText("Vui lòng kiểm tra và thử lại");
            alert.show();
        }

        System.out.println("xxxx");
        
    }


    private void changeSceneHome(ActionEvent e) throws Exception{
        Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("HomeScene.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("login.css").toExternalForm());
        // StudentDetailController controller = loader.getController();
        // Student selected = table.getSelectionModel().getSelectedItem();
        // controller.setStudent(selected);
        stage.setScene(scene);

    }

    
}
