package Models;

public class ThanhVienCuaHo {
    private String idNhanKhau;
    private String idHoKhau;
    private String quanHeVoiChuHo;
    private String noithuongtrutruoc;

    public ThanhVienCuaHo() {
    }

    

    public ThanhVienCuaHo(String idNhanKhau, String idHoKhau, String quanHeVoiChuHo) {
        this.idNhanKhau = idNhanKhau;
        this.idHoKhau = idHoKhau;
        this.quanHeVoiChuHo = quanHeVoiChuHo;
    }



    public String getIdNhanKhau() {
        return idNhanKhau;
    }

    public void setIdNhanKhau(String idNhanKhau) {
        this.idNhanKhau = idNhanKhau;
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
    
}
