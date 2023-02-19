package Controller;

import Models.NhanKhau;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/*
 * @author Vo Hoai Nam 4592
 * @version 1.0 11/2/2023
 * Class 136813, Teacher's name Trung.TT
 */
public class XemThanhVienController implements Initializable {

   @FXML
   private TableView<NhanKhau> table;

   @FXML
   private TableColumn<NhanKhau, Integer> sTT;

   @FXML
   private TableColumn<NhanKhau, String> maNhanKhau;

   @FXML
   private TableColumn<NhanKhau, String> hoten;

   @FXML
   private TableColumn<NhanKhau, String> bidanh;

   @FXML
   private TableColumn<NhanKhau, String> cccd;

   @FXML
   private TableColumn<NhanKhau, LocalDate> ngaysinh;

   @FXML
   private TableColumn<NhanKhau, String> gioitinh;

   @FXML
   private TableColumn<NhanKhau, String> quequan;

   @FXML
   private TableColumn<NhanKhau, String> thuongtru;

   @FXML
   private TableColumn<NhanKhau, String> dantoc;

   @FXML
   private TableColumn<NhanKhau, String> nghenghiep;

   @FXML
   private TableColumn<NhanKhau, String> noilamviec;

   private ObservableList<NhanKhau> nhankhauList;


   private String maHoKhau;

   public String getMaHoKhau() {
      return maHoKhau;
   }

   public void setMaHoKhau(String maHoKhau) {
      this.maHoKhau = maHoKhau;
   }

   @FXML
   private TextField searchField;

   @Override
   public void initialize(URL arg0, ResourceBundle arg1) {

   }

   public void show() {
      List<NhanKhau> ThanhVien = new ArrayList<NhanKhau>();
      try {
         Connection conn = SQLController.getConnection(SQLController.DB_URL, SQLController.USER_NAME,
               SQLController.PASSWORD);
         Statement stmt = conn.createStatement();
         String query = "SELECT MaNhanKhau FROM dbo.ThanhVienCuaHo WHERE MaHoKhau = '" +
               this.getMaHoKhau() + "'";
         // System.out.println(query);
         ResultSet rs = stmt.executeQuery(query);
         List<String> idNK = new ArrayList<String>();
         while (rs.next()) {
            idNK.add(rs.getString(1));
         }
         for (int i = 0; i < idNK.size(); i++) {
            // System.out.println(idNK.get(i));
            query = "SELECT MaNhanKhau, HoTen, BiDanh, CCCD, NgaySinh, GioiTinh, QueQuan, ThuongTru, Dantoc, NgheNghiep, NoiLamViec FROM dbo.NhanKhau WHERE MaNhanKhau = '"
                  + idNK.get(i) + "'";
            ResultSet rs1 = stmt.executeQuery(query);
            while (rs1.next()) {
               ThanhVien.add(new NhanKhau(rs1.getString(1), rs1.getNString(2), rs1.getNString(3), rs1.getString(4),
                     rs1.getDate(5).toLocalDate(),
                     rs1.getNString(6), rs1.getNString(7), rs1.getNString(8), rs1.getNString(9), rs1.getNString(10),
                     rs1.getNString(11)));
            }
            // System.out.println(query);
         }
         conn.close();

      } catch (Exception e) {
         e.printStackTrace();
      }

      // System.out.println(this.getMaHoKhau());

      nhankhauList = FXCollections.observableArrayList(ThanhVien);

      sTT.setCellValueFactory(column -> new ReadOnlyObjectWrapper(table.getItems().indexOf(column.getValue()) + 1));
      maNhanKhau.setCellValueFactory(new PropertyValueFactory<NhanKhau, String>("maNhanKhau"));
      hoten.setCellValueFactory(new PropertyValueFactory<NhanKhau, String>("hoTen"));
      bidanh.setCellValueFactory(new PropertyValueFactory<NhanKhau, String>("biDanh"));
      cccd.setCellValueFactory(new PropertyValueFactory<NhanKhau, String>("cccd"));
      ngaysinh.setCellValueFactory(new PropertyValueFactory<NhanKhau, LocalDate>("ngaySinh"));
      gioitinh.setCellValueFactory(new PropertyValueFactory<NhanKhau, String>("gioiTinh"));
      quequan.setCellValueFactory(new PropertyValueFactory<NhanKhau, String>("queQuan"));
      thuongtru.setCellValueFactory(new PropertyValueFactory<NhanKhau, String>("thuongTru"));
      dantoc.setCellValueFactory(new PropertyValueFactory<NhanKhau, String>("danToc"));
      nghenghiep.setCellValueFactory(new PropertyValueFactory<NhanKhau, String>("ngheNghiep"));
      noilamviec.setCellValueFactory(new PropertyValueFactory<NhanKhau, String>("noiLamViec"));
      table.setItems(nhankhauList);

      /*
       * searchField.textProperty().addListener((observable, oldValue, newValue)-> {
       * if(searchField.getText().isEmpty()) {
       * table.setItems(nhankhauList);
       * }else {
       * String searchInfo = searchField.getText();
       * List<NhanKhau> searchResult = new ArrayList<NhanKhau>();
       * try {
       * Connection conn = SQLController.getConnection(SQLController.DB_URL,
       * SQLController.USER_NAME, SQLController.PASSWORD);
       * Statement stmt = conn.createStatement();
       * String query =
       * "SELECT MaNhanKhau, HoTen, CCCD, NgaySinh, GioiTinh, QueQuan, ThuongTru, Dantoc, NgheNghiep FROM dbo.NhanKhau WHERE HoTen LIKE N'%"
       * + searchInfo + "%' OR MaNhanKhau LIKE '%" + searchInfo + "%' OR CCCD LIKE'%"
       * + searchInfo + "%'";
       * System.out.println(query);
       * ResultSet rs = stmt.executeQuery(query);
       * while(rs.next()) {
       * searchResult.add(new
       * NhanKhau(rs.getString(1),rs.getNString(2),rs.getString(3),
       * rs.getDate(4).toLocalDate(),
       * rs.getNString(5), rs.getNString(6), rs.getNString(7), rs.getNString(8),
       * rs.getNString(9)));
       * }
       * System.out.println("wtf");
       * conn.close();
       * 
       * } catch (Exception esss) {
       * esss.printStackTrace();
       * }
       * 
       * ObservableList<NhanKhau> searchedNhanKhauList;
       * searchedNhanKhauList = FXCollections.observableArrayList(searchResult);
       * table.setItems(searchedNhanKhauList);
       * }
       * });
       */
   }
}