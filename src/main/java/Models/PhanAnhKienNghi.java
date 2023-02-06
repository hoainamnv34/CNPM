package Models;

import java.time.LocalDate;

public class PhanAnhKienNghi {
    private int id;
    private String maPA;
    private NhanKhau nguoiPA;
    private String noiDung;
    private LocalDate ngayPA;
    private Boolean trangThai;
    private String capPhanAnh;
    private String phanHoi;
    private LocalDate ngayPhanHoi;
    public PhanAnhKienNghi(int id, String maPA, NhanKhau nguoiPA, String noiDung, LocalDate ngayPA, Boolean trangThai,
            String capPhanAnh, String phanHoi, LocalDate ngayPhanHoi) {
        this.id = id;
        this.maPA = maPA;
        this.nguoiPA = nguoiPA;
        this.noiDung = noiDung;
        this.ngayPA = ngayPA;
        this.trangThai = trangThai;
        this.capPhanAnh = capPhanAnh;
        this.phanHoi = phanHoi;
        this.ngayPhanHoi = ngayPhanHoi;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getMaPA() {
        return maPA;
    }
    public void setMaPA(String maPA) {
        this.maPA = maPA;
    }
    public NhanKhau getNguoiPA() {
        return nguoiPA;
    }
    public void setNguoiPA(NhanKhau nguoiPA) {
        this.nguoiPA = nguoiPA;
    }
    public String getNoiDung() {
        return noiDung;
    }
    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }
    public LocalDate getNgayPA() {
        return ngayPA;
    }
    public void setNgayPA(LocalDate ngayPA) {
        this.ngayPA = ngayPA;
    }
    public Boolean getTrangThai() {
        return trangThai;
    }
    public void setTrangThai(Boolean trangThai) {
        this.trangThai = trangThai;
    }
    public String getCapPhanAnh() {
        return capPhanAnh;
    }
    public void setCapPhanAnh(String capPhanAnh) {
        this.capPhanAnh = capPhanAnh;
    }
    public String getPhanHoi() {
        return phanHoi;
    }
    public void setPhanHoi(String phanHoi) {
        this.phanHoi = phanHoi;
    }
    public LocalDate getNgayPhanHoi() {
        return ngayPhanHoi;
    }
    public void setNgayPhanHoi(LocalDate ngayPhanHoi) {
        this.ngayPhanHoi = ngayPhanHoi;
    }
    public String getTen() {
        return nguoiPA.getHoTen();
    }
      
}
