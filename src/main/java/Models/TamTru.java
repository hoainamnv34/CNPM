package Models;

import java.util.Date;

public class TamTru {
   private String matamtru;
   private NhanKhau nguoitamtru;
   private String noitamtru;
   private Date tungay;
   private Date denngay;
   private String lydo;


   

   public String getMatamtru() {
      return matamtru;
   }
   public void setMatamtru(String matamtru) {
      this.matamtru = matamtru;
   }
   public NhanKhau getNguoitamtru() {
      return nguoitamtru;
   }
   public void setNguoitamtru(NhanKhau nguoitamtru) {
      this.nguoitamtru = nguoitamtru;
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
   public String getNoitamtru() {
      return noitamtru;
   }
   public void setNoitamtru(String noitamtru) {
      this.noitamtru = noitamtru;
   }
   
}
