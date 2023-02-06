package Models;

public class HoKhau {
   private String mahokhau;
   private String hotenchuho;
   private String cccdchuho;
   private String diachiho;
   

   public HoKhau(String mahokhau, String hotenchuho, String cccdchuho, String diachiho) {
      this.mahokhau = mahokhau;
      this.hotenchuho = hotenchuho;
      this.cccdchuho = cccdchuho;
      this.diachiho = diachiho;
   }


   public HoKhau(String mahokhau, String cccdchuho, String diachiho) {
      this.mahokhau = mahokhau;
      this.cccdchuho = cccdchuho;
      this.diachiho = diachiho;


   }




   public String getCccdchuho() {
      return cccdchuho;
   }

   public void setCccdchuho(String cccdchuho) {
      this.cccdchuho = cccdchuho;
   }

   public String getMahokhau() {
      return mahokhau;
   }
   public void setMahokhau(String mahokhau) {
      this.mahokhau = mahokhau;
   }
   
   public String getDiachiho() {
      return diachiho;
   }
   public void setDiachiho(String diachiho) {
      this.diachiho = diachiho;
   }
   public String getcccdchuho() {
      return cccdchuho;
   }
   public void setcccdchuho(String cccdchuho) {
      this.cccdchuho = cccdchuho;
   }


   public String getHotenchuho() {
      return hotenchuho;
   }


   public void setHotenchuho(String hotenchuho) {
      this.hotenchuho = hotenchuho;
   }
   
   
}
