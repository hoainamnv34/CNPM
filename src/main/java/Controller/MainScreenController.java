package Controller;


import Controller.MainScreenController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class MainScreenController extends Application {

    @Override
    public void start(Stage stage)  {
        try{
            Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("login.css").toExternalForm());
            stage.setScene(scene);
            stage.show();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        
    }
    

    public void on(String[] args) {
        launch(args);
    }
}
