package Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import Models.NhanKhau;
import Models.TamTru;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.ReadOnlyObjectWrapper;
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
import javafx.scene.control.Alert.AlertType;
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
   private List<TamTru> tTList = new ArrayList<TamTru>();
   @Override
   public void initialize(URL arg0, ResourceBundle arg1) {

      try {
         Connection conn = SQLController.getConnection(SQLController.DB_URL, SQLController.USER_NAME, SQLController.PASSWORD);
         Statement stmt = conn.createStatement();
         String query = "SELECT ID, HoTen, NoiTamTru, TuNgay, DenNgay, LyDo FROM dbo.TamTru INNER JOIN dbo.NhanKhau ON NhanKhau.MaNhanKhau = TamTru.MaNhanKhau";
         ResultSet rs = stmt.executeQuery(query);

         while(rs.next()) {
            tTList.add(new TamTru(rs.getString(1), new NhanKhau(rs.getNString(2)), rs.getNString(3), rs.getDate(4).toLocalDate(), rs.getDate(5).toLocalDate(), rs.getNString(6)));
         }

    } catch (Exception e) {
         e.printStackTrace();
    }


      tamTruList = FXCollections.observableArrayList(
         // new TamTru("TT.1", new NhanKhau("Nam"), "KA", LocalDate.of(2020, 10, 20), LocalDate.of(2021, 9, 8), "Tro"),
         // new TamTru("TT.1", new NhanKhau("Nam"), "KA", LocalDate.of(2020, 10, 20), LocalDate.of(2021, 9, 8), "Tro")
         tTList
         
   
      );
      sTT.setCellValueFactory(column-> new ReadOnlyObjectWrapper(table.getItems().indexOf(column.getValue()) + 1));
      idTamTru.setCellValueFactory(new PropertyValueFactory<TamTru, String>("idTamTru"));
      hoTen.setCellValueFactory(new PropertyValueFactory<TamTru, String>("hoTen"));
      noiTamTru.setCellValueFactory(new PropertyValueFactory<TamTru, String>("noiTamTru"));
      tuNgay.setCellValueFactory(new PropertyValueFactory<TamTru, LocalDate>("tuNgay"));
      denNgay.setCellValueFactory(new PropertyValueFactory<TamTru, LocalDate>("denNgay"));
      lyDo.setCellValueFactory(new PropertyValueFactory<TamTru, String>("lyDo"));
      table.setItems(tamTruList);

      BooleanBinding isSelected = table.getSelectionModel().selectedItemProperty().isNull();
      delButton.disableProperty().bind(isSelected);
      editButton.disableProperty().bind(isSelected);
   }

   public void addList(TamTru tamTru) {
      tamTruList.add(tamTru);
   }

   public void removeList(TamTru tamTruCu, TamTru tamTruMoi) {
      int index = tamTruList.indexOf(tamTruCu);
      tamTruList.set(index, tamTruMoi);
   }

   @FXML
   protected void addEvent(ActionEvent e) throws IOException {
      Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
      alert.setTitle("Cofirmation");
      alert.setHeaderText("Alert Information");
      alert.setContentText("choose your option");

      ButtonType buttonTypeYes = new ButtonType("Tạo Nhân khẩu mới", ButtonBar.ButtonData.YES);
      ButtonType buttonTypeNo = new ButtonType("Nhân Khẩu có sẵn", ButtonBar.ButtonData.NO);

      alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);

      Optional<ButtonType> result = alert.showAndWait();

      if (result.get()== buttonTypeYes){
         Stage addNKStage = new Stage();
         FXMLLoader loader = new FXMLLoader();
         loader.setLocation(getClass().getResource("ThemNhanKhau.fxml"));
         Parent root = loader.load();
         ThemNhanKhauController controller = loader.getController();
         controller.setTamTruController(this);

         // controller.setNhanKhauController(this);
         Scene scene = new Scene(root);
         scene.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
         addNKStage.setScene(scene);
         addNKStage.show();

      }else if (result.get().getButtonData() == ButtonBar.ButtonData.NO){
         Stage addStage = new Stage();
         FXMLLoader loader = new FXMLLoader();
         loader.setLocation(getClass().getResource("ThemTamTru.fxml"));
         Parent root = loader.load();
         ThemTamTruController controller = loader.getController();
         controller.setTamTruController(this);
         Scene scene = new Scene(root);
         scene.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
         addStage.setScene(scene);
         addStage.show();
      }
      
  
      
      
      
   }


   @FXML
   protected void deleteEvent(ActionEvent e) throws IOException, SQLException{
         TamTru selected = table.getSelectionModel().getSelectedItem();
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

            Connection conn = SQLController.getConnection(SQLController.DB_URL, SQLController.USER_NAME, SQLController.PASSWORD);
            Statement stmt;
            stmt = conn.createStatement();
            String query = "DELETE FROM dbo.TamTru WHERE ID = '" + selected.getIdTamTru() + "'";
            System.out.println(query);
            stmt.execute(query);

            String message = "Xóa Tạm trú " + selected.getHoTen() + " thành công"; 
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setTitle("Information");
            alert1.setHeaderText("Notification");
            alert1.setContentText(message);
            alert1.show();
            tamTruList.remove(selected);
         }      
         else if (result.get().getButtonData() == ButtonBar.ButtonData.NO)
            System.out.println("Code for no");
   }


   @FXML
   protected void editEvent(ActionEvent e) throws IOException{
      TamTru selected = table.getSelectionModel().getSelectedItem();
      Stage addStage = new Stage();
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("SuaTamTru.fxml"));
      Parent root = loader.load();
      SuaTamTruController controller = loader.getController();
      controller.setTamTruController(this);
      controller.maNKField.setText(selected.getIdTamTru());
      controller.hoTenLabel.setText(selected.getHoTen());
      controller.noiTamTruField.setText(selected.getNoiTamTru());
      controller.tuNgayDatePicker.setValue(selected.getTuNgay());
      controller.denNgayDatePicker.setValue(selected.getDenNgay());
      controller.lydoField.setText(selected.getLyDo());
      controller.setTamTruEdit(selected);
      Scene scene = new Scene(root);
      scene.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
      addStage.setScene(scene);
      addStage.show();
   }
    
}
