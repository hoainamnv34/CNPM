package Controller;

import Models.HoKhau;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.beans.binding.BooleanBinding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class HoKhauController implements Initializable{

   @FXML
   private TableView<HoKhau> table;

   @FXML
   private TableColumn<HoKhau, String> idHoKhau;

   @FXML
   private TableColumn<HoKhau, String> hoTenChuHo;

   @FXML
   private TableColumn<HoKhau, String> cCCDChuHo;

   @FXML
   private TableColumn<HoKhau, String> diaChiHo;


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
         new HoKhau("HK.1","Son", "568", "Hoang Mai"),
         new HoKhau("HK.2","Nam", "346", "Hoang Mai")
   
      );

      idHoKhau.setCellValueFactory(new PropertyValueFactory<HoKhau, String>("idHoKhau"));
      hoTenChuHo.setCellValueFactory(new PropertyValueFactory<HoKhau, String>("hoTen"));
      cCCDChuHo.setCellValueFactory(new PropertyValueFactory<HoKhau, String>("cccdChHo"));
      diaChiHo.setCellValueFactory(new PropertyValueFactory<HoKhau, String>("diaChiHo"));
      table.setItems(hokhauList);

      BooleanBinding isSelected = table.getSelectionModel().selectedItemProperty().isNull();
      delButton.disableProperty().bind(isSelected);
      editButton.disableProperty().bind(isSelected);
   }

   @FXML
   protected void addEvent(ActionEvent e) throws IOException {
        Stage addStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ThemHoKhau.fxml"));
        Parent root = loader.load();
        ThemHoKhauController controller = loader.getController();
        controller.setHoKhauController(this);
        Scene scene = new Scene(root);
        addStage.setScene(scene);
        addStage.show();
   }

   @FXML
   protected void deleteEvent(ActionEvent e) throws IOException{
         HoKhau selected = table.getSelectionModel().getSelectedItem();
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
         alert.setTitle("Cofirmation");
         alert.setHeaderText("Bạn muốn xóa hộ khẩu có chủ hộ tên " + selected.getHoTenChuHo());
         //   alert.setContentText("choose your option");

         ButtonType buttonTypeYes = new ButtonType("Yes", ButtonBar.ButtonData.YES);
         ButtonType buttonTypeNo = new ButtonType("No", ButtonBar.ButtonData.NO);
         // ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

         alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);

         Optional<ButtonType> result = alert.showAndWait();

         if (result.get()== buttonTypeYes){
            String message = "Xóa Hộ khẩu " + selected.getHoTenChuHo() + " thành công"; 
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setTitle("Information");
            alert1.setHeaderText("Notification");
            alert1.setContentText(message);
            alert1.show();
            hokhauList.remove(selected);
         }      
         else if (result.get().getButtonData() == ButtonBar.ButtonData.NO)
            System.out.println("Code for no");
   }

   @FXML
   protected void editEvent(ActionEvent e) throws IOException{
      HoKhau selected = table.getSelectionModel().getSelectedItem();

   }


   public void addList(HoKhau hoKhau) {
      hokhauList.add(hoKhau);
   }
}