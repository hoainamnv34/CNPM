package Controller;

import Models.NhanKhau;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class NhanKhauController implements Initializable {
   /*private int id;
   private String noisinh;
   private String nguyenquan;
   private String dantoc;
   private String nghenghiep;
   private Date ngaysinh;
   private int cccd;
   private int idtronghokhau;
   private int idhokhau;
   private Boolean tamtru;
   private Boolean tamvang;*/

   @FXML
   private TableView<NhanKhau> table;

   @FXML
   private TableColumn<NhanKhau, Integer> sTT;

   @FXML 
   private TableColumn<NhanKhau, String> hoten;

   @FXML
   private TableColumn<NhanKhau, String> cccd;

   @FXML 
   private TableColumn<NhanKhau, String> noisinh;

   @FXML 
   private TableColumn<NhanKhau, String> nguyenquan;

   @FXML 
   private TableColumn<NhanKhau, String> dantoc;

   @FXML 
   private TableColumn<NhanKhau, String> nghenghiep;

   @FXML
   private TableColumn<NhanKhau, LocalDate> ngaysinh;

   @FXML 
   private Button editButton;

   @FXML 
   private Button delButton;

   @FXML 
   private Button addButton;

   private ObservableList<NhanKhau> nhankhauList;
   @Override
   public void initialize(URL arg0, ResourceBundle arg1) {
        nhankhauList = FXCollections.observableArrayList(
            new NhanKhau(0, "Son", "1111", "Vinh", "NamDan", "Kinh", "SV", LocalDate.of(2020, 10, 20), null, 1)
         //new NhanKhau(1)
        );

        // sTT.setCellValueFactory(new String());
        sTT.setCellValueFactory(new PropertyValueFactory<NhanKhau, Integer>("id"));
        hoten.setCellValueFactory(new PropertyValueFactory<NhanKhau, String>("hoten"));
        ngaysinh.setCellValueFactory(new PropertyValueFactory<NhanKhau, LocalDate>("ngaysinh"));
        /*ngaysinh.setCellFactory(column -> {
            TableCell<NhanKhau, Date> cell = new TableCell<NhanKhau, Date>() 
                private SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
                @Override
                protected void updateItem(Date item, boolean empty) {
                    super.updateItem(item, empty);
                    if(empty) {
                        setText(null);
                    }
                    else {
                        setText(format.format(item));
                    }
                }
            };
            return cell;
        });*/
        noisinh.setCellValueFactory(new PropertyValueFactory<NhanKhau, String>("noisinh"));
        nguyenquan.setCellValueFactory(new PropertyValueFactory<NhanKhau, String>("nguyenquan"));
        nghenghiep.setCellValueFactory(new PropertyValueFactory<NhanKhau, String>("nghenghiep"));
        dantoc.setCellValueFactory(new PropertyValueFactory<NhanKhau, String>("dantoc"));
        cccd.setCellValueFactory(new PropertyValueFactory<NhanKhau, String>("cccd"));
        table.setItems(nhankhauList);
   }

   @FXML
    protected void addEvent(ActionEvent e) throws IOException {
        Stage addStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ThemNhanKhau.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        addStage.setScene(scene);
        addStage.show();
   }
}