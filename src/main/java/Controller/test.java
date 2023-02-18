package Controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class test extends Application {

    public static void main(String[] args) {
        launch(args);
        
    }

    @Override
    public void start(Stage primaryStage) {
        try{
            Parent root = FXMLLoader.load(this.getClass().getResource("HoKhau.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
