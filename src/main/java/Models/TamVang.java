package Models;

import java.util.Date;

public class TamVang {
   private String idTamVang;
   private NhanKhau nguoiTamVang;
   private String noiTamTru;
   private Date tuNgay; 
   private Date denNgay;
   private String lyDo;


   
   public TamVang(String idTamVang, NhanKhau nguoiTamVang, String noiTamTru, Date tuNgay, Date denNgay, String lyDo) {
      this.idTamVang = idTamVang;
      this.nguoiTamVang = nguoiTamVang;
      this.noiTamTru = noiTamTru;
      this.tuNgay = tuNgay;
      this.denNgay = denNgay;
      this.lyDo = lyDo;
   }
   public String getIdTamVang() {
      return idTamVang;
   }
   public void setIdTamVang(String idTamVang) {
      this.idTamVang = idTamVang;
   }
   public NhanKhau getNguoiTamVang() {
      return nguoiTamVang;
   }
   public void setNguoiTamVang(NhanKhau nguoiTamVang) {
      this.nguoiTamVang = nguoiTamVang;
   }
   public String getNoiTamTru() {
      return noiTamTru;
   }
   public void setNoiTamTru(String noiTamTru) {
      this.noiTamTru = noiTamTru;
   }
   public Date getTuNgay() {
      return tuNgay;
   }
   public void setTuNgay(Date tuNgay) {
      this.tuNgay = tuNgay;
   }
   public Date getDenNgay() {
      return denNgay;
   }
   public void setDenNgay(Date denNgay) {
      this.denNgay = denNgay;
   }
   public String getLyDo() {
      return lyDo;
   }
   public void setLyDo(String lyDo) {
      this.lyDo = lyDo;
   }

   
}
