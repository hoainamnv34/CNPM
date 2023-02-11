package Models;

public class ThanhVienCuaHo {
    private String idNhanKhau;
    private String hoTen;
    private String idHoKhau;
    private String quanHeVoiChuHo;
    private String noithuongtrutruoc;
    private int idTrongHoKhau;
    

  

    public ThanhVienCuaHo(String idNhanKhau, String hoTen, String idHoKhau, String quanHeVoiChuHo, int idTrongHoKhau) {
        this.idNhanKhau = idNhanKhau;
        this.hoTen = hoTen;
        this.idHoKhau = idHoKhau;
        this.quanHeVoiChuHo = quanHeVoiChuHo;
        this.idTrongHoKhau = idTrongHoKhau;
    }

    public ThanhVienCuaHo(String idNhanKhau, String hoTen, String idHoKhau, String quanHeVoiChuHo,
            String noithuongtrutruoc, int idTrongHoKhau) {
        this.idNhanKhau = idNhanKhau;
        this.hoTen = hoTen;
        this.idHoKhau = idHoKhau;
        this.quanHeVoiChuHo = quanHeVoiChuHo;
        this.noithuongtrutruoc = noithuongtrutruoc;
        this.idTrongHoKhau = idTrongHoKhau;
    }

    public ThanhVienCuaHo(String hoTen, String quanHeVoiChuHo) {
        this.hoTen = hoTen;
        this.quanHeVoiChuHo = quanHeVoiChuHo;
    }

    public ThanhVienCuaHo() {
    }

    public String getNoithuongtrutruoc() {
        return noithuongtrutruoc;
    }


    public void setNoithuongtrutruoc(String noithuongtrutruoc) {
        this.noithuongtrutruoc = noithuongtrutruoc;
    }


    public String getIdHoKhau() {
        return idHoKhau;
    }

    public void setIdHoKhau(String idHoKhau) {
        this.idHoKhau = idHoKhau;
    }

    public String getQuanHeVoiChuHo() {
        return quanHeVoiChuHo;
    }

    public void setQuanHeVoiChuHo(String quanHeVoiChuHo) {
        this.quanHeVoiChuHo = quanHeVoiChuHo;
    }

    public String getIdNhanKhau() {
        return idNhanKhau;
    }

    public void setIdNhanKhau(String idNhanKhau) {
        this.idNhanKhau = idNhanKhau;
    }

    public int getIdTrongHoKhau() {
        return idTrongHoKhau;
    }

    public void setIdTrongHoKhau(int idTrongHoKhau) {
        this.idTrongHoKhau = idTrongHoKhau;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

}
