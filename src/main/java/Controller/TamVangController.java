package Controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;

import Models.NhanKhau;
import Models.TamVang;
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

public class TamVangController implements Initializable {
   @FXML
   private TableView<TamVang> table;

   @FXML
   private TableColumn<TamVang, String> sTT;

   @FXML
   private TableColumn<TamVang, String> idTamVang;

   @FXML
   private TableColumn<TamVang, String> hoTen;

   @FXML
   private TableColumn<TamVang, String> noiTamVang;

   @FXML
   private TableColumn<TamVang, LocalDate> tuNgay;

   @FXML
   private TableColumn<TamVang,LocalDate > denNgay;

   @FXML
   private TableColumn<TamVang,String > lyDo;


   @FXML 
   private Button editButton;

   @FXML 
   private Button delButton;

   @FXML 
   private Button addButton;

   private ObservableList<TamVang> tamVangList;
   @Override
   public void initialize(URL arg0, ResourceBundle arg1) {
        tamVangList = FXCollections.observableArrayList(
            new TamVang("TT.1", new NhanKhau("Nam"), "KA", LocalDate.of(2021,8,9),LocalDate.of(2020, 10, 20), "ly do"),
            new TamVang("TT.1", new NhanKhau("Nam"), "KA", LocalDate.of(2020, 10, 20), LocalDate.of(2021, 9, 8), "Tro")
        );

        idTamVang.setCellValueFactory(new PropertyValueFactory<TamVang, String>("idTamVang"));
        hoTen.setCellValueFactory(new PropertyValueFactory<TamVang, String>("hoTen"));
        noiTamVang.setCellValueFactory(new PropertyValueFactory<TamVang, String>("noiTamTru"));
        tuNgay.setCellValueFactory(new PropertyValueFactory<TamVang, LocalDate>("tuNgay"));
        denNgay.setCellValueFactory(new PropertyValueFactory<TamVang, LocalDate>("denNgay"));
        lyDo.setCellValueFactory(new PropertyValueFactory<TamVang, String>("lyDo"));
        table.setItems(tamVangList);

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
         TamVang selected = table.getSelectionModel().getSelectedItem();
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
         alert.setTitle("Cofirmation");
         alert.setHeaderText("Bạn muốn xóa tạm trú của " + selected.getHoTen());
         //   alert.setContentText("choose your option");

         ButtonType buttonTypeYes = new ButtonType("Yes", ButtonBar.ButtonData.YES);
         ButtonType buttonTypeNo = new ButtonType("No", ButtonBar.ButtonData.NO);
         // ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

         alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);

         Optional<ButtonType> result = alert.showAndWait();

         if (result.get()== buttonTypeYes){
            String message = "Xóa Hộ khẩu " + selected.getHoTen() + " thành công"; 
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setTitle("Information");
            alert1.setHeaderText("Notification");
            alert1.setContentText(message);
            alert1.show();
            tamVangList.remove(selected);
         }      
         else if (result.get().getButtonData() == ButtonBar.ButtonData.NO)
            System.out.println("Code for no");
   }

   @FXML
   protected void editEvent(ActionEvent e) throws IOException{
      // HoKhau selected = table.getSelectionModel().getSelectedItem();

   }
    
}
