package Controller;

import Models.HoKhau;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class HoKhauController implements Initializable{

   @FXML
   private TableView<HoKhau> table;

   @FXML
   private TableColumn<HoKhau, String> mahokhau;

   @FXML
   private TableColumn<HoKhau, String> tenchuho;

   @FXML
   private TableColumn<HoKhau, String> cccdChuHo;

   @FXML
   private TableColumn<HoKhau, String> diachi;


   @FXML 
   private Button editButton;

   @FXML 
   private Button delButton;

   @FXML 
   private Button addButton;

   private ObservableList<HoKhau> hokhauList;
   @Override
   public void initialize(URL arg0, ResourceBundle arg1) {
      hokhauList = FXCollections.observableArrayList(
         new HoKhau("HK.1","Son", "123", "Hoang Mai")
         //new NhanKhau(1)
      );

      mahokhau.setCellValueFactory(new PropertyValueFactory<HoKhau, String>("mahokhau"));
      tenchuho.setCellValueFactory(new PropertyValueFactory<HoKhau, String>("hotenchuho"));
      cccdChuHo.setCellValueFactory(new PropertyValueFactory<HoKhau, String>("cccdchuho"));
      diachi.setCellValueFactory(new PropertyValueFactory<HoKhau, String>("diachiho"));
      table.setItems(hokhauList);

      // setCellValueFactory
   }

   @FXML
   protected void addEvent(ActionEvent e) throws IOException {
        Stage addStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ThemHoKhau.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        addStage.setScene(scene);
        addStage.show();
   }
}