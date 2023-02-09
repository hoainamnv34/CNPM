package Models;

import java.time.LocalDate;

public class NhanKhau {
   private int id;
   private String hoTen;
   private String cccd;
   private LocalDate ngaySinh;
   private String gioiTinh;
   private String queQuan;
   private String thuongTru;
   private String danToc;
   private String ngheNghiep;
   private int idTrongHoKhau;

   

   public NhanKhau(String hoTen) {
      this.hoTen = hoTen;
   }
   public NhanKhau(int id, String hoTen, String cccd, LocalDate ngaySinh, String gioiTinh, String queQuan,
         String thuongTru, String danToc, String ngheNghiep, int idTrongHoKhau) {
      this.id = id;
      this.hoTen = hoTen;
      this.cccd = cccd;
      this.ngaySinh = ngaySinh;
      this.gioiTinh = gioiTinh;
      this.queQuan = queQuan;
      this.thuongTru = thuongTru;
      this.danToc = danToc;
      this.ngheNghiep = ngheNghiep;
      this.idTrongHoKhau = idTrongHoKhau;
   }
   public int getId() {
      return id;
   }
   public void setId(int id) {
      this.id = id;
   }
   public String getHoTen() {
      return hoTen;
   }
   public void setHoTen(String hoTen) {
      this.hoTen = hoTen;
   }
   public String getCccd() {
      return cccd;
   }
   public void setCccd(String cccd) {
      this.cccd = cccd;
   }
   public LocalDate getNgaySinh() {
      return ngaySinh;
   }
   public void setNgaySinh(LocalDate ngaySinh) {
      this.ngaySinh = ngaySinh;
   }
   public String getGioiTinh() {
      return gioiTinh;
   }
   public void setGioiTinh(String gioiTinh) {
      this.gioiTinh = gioiTinh;
   }
   public String getQueQuan() {
      return queQuan;
   }
   public void setQueQuan(String queQuan) {
      this.queQuan = queQuan;
   }
   public String getThuongTru() {
      return thuongTru;
   }
   public void setThuongTru(String thuongTru) {
      this.thuongTru = thuongTru;
   }
   public String getDanToc() {
      return danToc;
   }
   public void setDanToc(String danToc) {
      this.danToc = danToc;
   }
   public String getNgheNghiep() {
      return ngheNghiep;
   }
   public void setNgheNghiep(String ngheNghiep) {
      this.ngheNghiep = ngheNghiep;
   }
   public int getIdTrongHoKhau() {
      return idTrongHoKhau;
   }
   public void setIdTrongHoKhau(int idTrongHoKhau) {
      this.idTrongHoKhau = idTrongHoKhau;
   }

   

}
 