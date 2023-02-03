package Models;

import java.util.Date;

public class TamVang {
   private String matamvang;
   private NhanKhau nguoitamvang;
   private Date tungay;
   private Date denngay;
   private String lydo;
   public String getMatamvang() {
      return matamvang;
   }
   public void setMatamvang(String matamvang) {
      this.matamvang = matamvang;
   }
   public NhanKhau getNguoitamvang() {
      return nguoitamvang;
   }
   public void setNguoitamvang(NhanKhau nguoitamvang) {
      this.nguoitamvang = nguoitamvang;
   }
   public Date getTungay() {
      return tungay;
   }
   public void setTungay(Date tungay) {
      this.tungay = tungay;
   }
   public Date getDenngay() {
      return denngay;
   }
   public void setDenngay(Date denngay) {
      this.denngay = denngay;
   }
   public String getLydo() {
      return lydo;
   }
   public void setLydo(String lydo) {
      this.lydo = lydo;
   } 

   
}
