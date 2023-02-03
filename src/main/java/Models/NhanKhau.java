package Models;

import java.util.Date;

public class NhanKhau {
   private int id;
   private String noisinh;
   private String nguyenquan;
   private String dantoc;
   private String nghenghiep;
   private Date ngaysinh;
   private CCCD cccd;
   private int idtronghokhau;
   private int idhokhau;
   private Boolean tamtru;
   private Boolean tamvang;

   public int getId() {
      return id;
   }
   public void setId(int id) {
      this.id = id;
   }
   public String getNoisinh() {
      return noisinh;
   }
   public void setNoisinh(String noisinh) {
      this.noisinh = noisinh;
   }
   public String getNguyenquan() {
      return nguyenquan;
   }
   public void setNguyenquan(String nguyenquan) {
      this.nguyenquan = nguyenquan;
   }
   public String getDantoc() {
      return dantoc;
   }
   public void setDantoc(String dantoc) {
      this.dantoc = dantoc;
   }
   public String getNghenghiep() {
      return nghenghiep;
   }
   public void setNghenghiep(String nghenghiep) {
      this.nghenghiep = nghenghiep;
   }
   public Date getNgaysinh() {
      return ngaysinh;
   }
   public void setNgaysinh(Date ngaysinh) {
      this.ngaysinh = ngaysinh;
   }
   public CCCD getCccd() {
      return cccd;
   }
   public void setCccd(CCCD cccd) {
      this.cccd = cccd;
   }
   public int getIdtronghokhau() {
      return idtronghokhau;
   }   
   public void setIdtronghokhau(int idtronghokhau) {
      this.idtronghokhau = idtronghokhau;
   }
   public int getIdhokhau() {
      return idhokhau;
   }
   public void setIdhokhau(int idhokhau) {
      this.idhokhau = idhokhau;
   }
   public Boolean getTamtru() {
      return tamtru;
   }
   public void setTamtru(Boolean tamtru) {
      this.tamtru = tamtru;
   }
   public Boolean getTamvang() {
      return tamvang;
   }
   public void setTamvang(Boolean tamvang) {
      this.tamvang = tamvang;
   }
   
}
 