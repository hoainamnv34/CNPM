package Models;

public class HoKhau {
   private String idHoKhau;
   private String hoTenChuHo;
   private String cccdChHo;
   private String diaChiHo;



   public HoKhau(String idHoKhau, String hoTenChuHo, String cCCDChuHo, String diaChiHo) {
      this.idHoKhau = idHoKhau;
      this.hoTenChuHo = hoTenChuHo;
      this.cccdChHo = cCCDChuHo;
      this.diaChiHo = diaChiHo;
   }
   public String getIdHoKhau() {
      return idHoKhau;
   }
   public void setIdHoKhau(String idHoKhau) {
      this.idHoKhau = idHoKhau;
   }
   public String getHoTenChuHo() {
      return hoTenChuHo;
   }
   public void setHoTenChuHo(String hoTenChuHo) {
      this.hoTenChuHo = hoTenChuHo;
   }
   public String getDiaChiHo() {
      return diaChiHo;
   }
   public void setDiaChiHo(String diaChiHo) {
      this.diaChiHo = diaChiHo;
   }
   public String getCccdChHo() {
      return cccdChHo;
   }
   public void setCccdChHo(String cccdChHo) {
      this.cccdChHo = cccdChHo;
   }

   
   
}
