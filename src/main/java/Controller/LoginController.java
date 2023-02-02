package Controller;

import java.net.URL;
import java.util.ResourceBundle;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController implements Initializable {
    @FXML
    TextField userField;

    @FXML
    PasswordField passwordField;


    @FXML
    private Button loginButton ;


    boolean ck = true;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        loginButton.setDisable(true);

        userField.textProperty().addListener((observable, oldValue, newValue)-> {
            loginButton.setDisable(newValue.trim().isEmpty());

        });
    }

    @FXML
    protected void Submit (ActionEvent event) {
        // welcomeText.setText("Welcome to JavaFX Application!");
        System.out.println("xxxx");
    }
}
