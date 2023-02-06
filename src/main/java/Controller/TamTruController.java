package Controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import Models.NhanKhau;
import Models.TamTru;
import javafx.beans.binding.BooleanBinding;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class TamTruController implements Initializable {
   @FXML
   private TableView<TamTru> table;

   @FXML
   private TableColumn<TamTru, String> sTT;

   @FXML
   private TableColumn<TamTru, String> idTamTru;

   @FXML
   private TableColumn<TamTru, String> hoTen;

   @FXML
   private TableColumn<TamTru, String> noiTamTru;

   @FXML
   private TableColumn<TamTru, LocalDate> tuNgay;

   @FXML
   private TableColumn<TamTru,LocalDate > denNgay;

   @FXML
   private TableColumn<TamTru,String > lyDo;


   @FXML 
   private Button editButton;

   @FXML 
   private Button delButton;

   @FXML 
   private Button addButton;

   private ObservableList<TamTru> tamTruList;
   @Override
   public void initialize(URL arg0, ResourceBundle arg1) {
      tamTruList = FXCollections.observableArrayList(
         new TamTru("TT.1", new NhanKhau("Nam"), "KA", LocalDate.of(2020, 10, 20), LocalDate.of(2021, 9, 8), "Tro"),
         new TamTru("TT.1", new NhanKhau("Nam"), "KA", LocalDate.of(2020, 10, 20), LocalDate.of(2021, 9, 8), "Tro")
         
   
      );

      idTamTru.setCellValueFactory(new PropertyValueFactory<TamTru, String>("idTamTru"));
      hoTen.setCellValueFactory(new PropertyValueFactory<TamTru, String>("hoTenChuHo"));
      noiTamTru.setCellValueFactory(new PropertyValueFactory<TamTru, String>("noiTamTru"));
      tuNgay.setCellValueFactory(new PropertyValueFactory<TamTru, LocalDate>("tuNgay"));
      denNgay.setCellValueFactory(new PropertyValueFactory<TamTru, LocalDate>("denNgay"));
      lyDo.setCellValueFactory(new PropertyValueFactory<TamTru, String>("lyDo"));
      table.setItems(tamTruList);

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
        Scene scene = new Scene(root);
        addStage.setScene(scene);
        addStage.show();
   }

   @FXML
   protected void deleteEvent(ActionEvent e) throws IOException{
         // HoKhau selected = table.getSelectionModel().getSelectedItem();
         // Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
         // alert.setTitle("Cofirmation");
         // alert.setHeaderText("Bạn muốn xóa hộ khẩu có chủ hộ tên " + selected.getHoTenChuHo());
         // //   alert.setContentText("choose your option");

         // ButtonType buttonTypeYes = new ButtonType("Yes", ButtonBar.ButtonData.YES);
         // ButtonType buttonTypeNo = new ButtonType("No", ButtonBar.ButtonData.NO);
         // // ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

         // alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);

         // Optional<ButtonType> result = alert.showAndWait();

         // if (result.get()== buttonTypeYes){
         //    String message = "Xóa Hộ khẩu " + selected.getHoTenChuHo() + " thành công"; 
         //    Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
         //    alert1.setTitle("Information");
         //    alert1.setHeaderText("Notification");
         //    alert1.setContentText(message);
         //    alert1.show();
         //    hokhauList.remove(selected);
         // }      
         // else if (result.get().getButtonData() == ButtonBar.ButtonData.NO)
         //    System.out.println("Code for no");
   }

   @FXML
   protected void editEvent(ActionEvent e) throws IOException{
      // HoKhau selected = table.getSelectionModel().getSelectedItem();

   }
    
}
