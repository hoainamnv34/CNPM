package Models;

import java.time.LocalDate;

public class TamVang {
   private String idTamVang;
   private String cCCD;
   private NhanKhau nguoiTamVang;
   private String noiTamTru;
   private LocalDate tuNgay; 
   private LocalDate denNgay;
   private String lyDo;
 
   public TamVang(String idTamVang, NhanKhau nguoiTamVang, String noiTamTru, LocalDate tuNgay, LocalDate denNgay, String lyDo) {
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
   public LocalDate getTuNgay() {
      return tuNgay;
   }
   public void setTuNgay(LocalDate tuNgay) {
      this.tuNgay = tuNgay;
   }
   public LocalDate getDenNgay() {
      return denNgay;
   }
   public void setDenNgay(LocalDate denNgay) {
      this.denNgay = denNgay;
   }
   public String getLyDo() {
      return lyDo;
   }
   public void setLyDo(String lyDo) {
      this.lyDo = lyDo;
   }

   public String getHoTen() {
      return nguoiTamVang.getHoTen();
   }

   public String getcCCD() {
      return cCCD;
   }

   public void setcCCD(String cCCD) {
      this.cCCD = cCCD;
   }

   
}
