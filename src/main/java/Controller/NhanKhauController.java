package Controller;

import Models.NhanKhau;



import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;
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
public class NhanKhauController implements Initializable {

     @FXML
     private TableView<NhanKhau> table;

     @FXML
     private TableColumn<NhanKhau, Integer> sTT;

     @FXML 
     private TableColumn<NhanKhau, String> hoten;

     @FXML
     private TableColumn<NhanKhau, String> cccd;

     @FXML
     private TableColumn<NhanKhau, LocalDate> ngaysinh;

     @FXML
     private TableColumn<NhanKhau, String> gioitinh;

     @FXML 
     private TableColumn<NhanKhau, String> quequan;

     @FXML 
     private TableColumn<NhanKhau, String> dantoc;

     @FXML 
     private TableColumn<NhanKhau, String> nghenghiep;

     

     @FXML 
     private Button editButton;

     @FXML 
     private Button delButton;

     @FXML 
     private Button addButton;

     private ObservableList<NhanKhau> nhankhauList;

     private List<NhanKhau> NkList;

     @Override
     public void initialize(URL arg0, ResourceBundle arg1) {

          try {
               Connection conn = SQLController.getConnection(SQLController.DB_URL, SQLController.USER_NAME, SQLController.PASSWORD);
               Statement stmt = conn.createStatement();
               String query = "SELECT HoTen, CCCD, NgaySinh, GioiTinh, QueQuan, ThuongTru, Dantoc, NgheNghiep FROM dbo.NhanKhau";
               ResultSet rs = stmt.executeQuery(query);
               int i = 1;
               while(rs.next()) {
                    NkList.add(new NhanKhau(i, rs.getNString(1),rs.getString(2), rs.getDate(3).toLocalDate(), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), 2));
               }

          } catch (Exception e) {
               e.printStackTrace();
          }

          

          nhankhauList = FXCollections.observableArrayList(
               new NhanKhau(0, "Son", "1111", LocalDate.of(2020, 10, 20), "Nam", "NamDan", "Vinh", "Kinh", "SV", 1),
               new NhanKhau(0, "Son", "1111", LocalDate.of(2020, 10, 20), "Nam", "NamDan", "Vinh", "Kinh", "SV", 1)
          //new NhanKhau(1)
          );

          // sTT.setCellValueFactory(new String());
          sTT.setCellValueFactory(new PropertyValueFactory<NhanKhau, Integer>("id"));
          hoten.setCellValueFactory(new PropertyValueFactory<NhanKhau, String>("hoTen"));
          cccd.setCellValueFactory(new PropertyValueFactory<NhanKhau, String>("cccd"));
          ngaysinh.setCellValueFactory(new PropertyValueFactory<NhanKhau, LocalDate>("ngaySinh"));
          gioitinh.setCellValueFactory(new PropertyValueFactory<NhanKhau, String>("gioiTinh"));
          quequan.setCellValueFactory(new PropertyValueFactory<NhanKhau, String>("queQuan"));
          dantoc.setCellValueFactory(new PropertyValueFactory<NhanKhau, String>("danToc"));
          nghenghiep.setCellValueFactory(new PropertyValueFactory<NhanKhau, String>("ngheNghiep"));
          table.setItems(nhankhauList);

          BooleanBinding isSelected = table.getSelectionModel().selectedItemProperty().isNull();
          delButton.disableProperty().bind(isSelected);
          editButton.disableProperty().bind(isSelected);

     }

     @FXML
     protected void addEvent(ActionEvent e) throws IOException {
          Stage addStage = new Stage();
          FXMLLoader loader = new FXMLLoader();
          loader.setLocation(getClass().getResource("ThemNhanKhau.fxml"));
          Parent root = loader.load();
     
          Scene scene = new Scene(root);
          ThemNhanKhauController controller = loader.getController();
          controller.setNhanKhauController(this);
          
          addStage.setScene(scene);
          addStage.show();
     }

     @FXML
     protected void deleteEvent(ActionEvent e) throws IOException{
          NhanKhau selected = table.getSelectionModel().getSelectedItem();
          Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
          alert.setTitle("Cofirmation");
          alert.setHeaderText("Bạn muốn xóa Nhân Khẩu " + selected.getHoTen());
          //   alert.setContentText("choose your option");

          ButtonType buttonTypeYes = new ButtonType("Yes", ButtonBar.ButtonData.YES);
          ButtonType buttonTypeNo = new ButtonType("No", ButtonBar.ButtonData.NO);
          // ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

          alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);

          Optional<ButtonType> result = alert.showAndWait();

          if (result.get()== buttonTypeYes){
               String message = "Xóa Nhân Khẩu " + selected.getHoTen() + " thành công"; 
               Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
               alert1.setTitle("Information");
               alert1.setHeaderText("Notification");
               alert1.setContentText(message);
               alert1.show();
               nhankhauList.remove(selected);
          }      
          else if (result.get().getButtonData() == ButtonBar.ButtonData.NO)
               System.out.println("Code for no");

          
     }

     @FXML
     protected void editEvent(ActionEvent e) throws IOException{
          NhanKhau selected = table.getSelectionModel().getSelectedItem();
          Stage addStage = new Stage();
          FXMLLoader loader = new FXMLLoader();
          loader.setLocation(getClass().getResource("SuaNhanKhau.fxml"));
          Parent root = loader.load();
     
          Scene scene = new Scene(root);
          SuaNhanKhauController controller = loader.getController();
          controller.setNhanKhauController(this);
          
          addStage.setScene(scene);
          addStage.show();         

          

     }

     public void addList(NhanKhau nhanKhau) {
          nhankhauList.add(nhanKhau);
     }


}