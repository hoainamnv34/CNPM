package Models;

import java.util.Date;

public class HoKhauModel {
    private String MHK;
    private String tenChuHo;
    private String cMNDChuHoString;
    private String diaChiHK;
    private Date ngayLap;

    
    public String getMHK() {
        return MHK;
    }
    public void setMHK(String mHK) {
        MHK = mHK;
    }
    public String getTenChuHo() {
        return tenChuHo;
    }
    public void setTenChuHo(String tenChuHo) {
        this.tenChuHo = tenChuHo;
    }
    public String getcMNDChuHoString() {
        return cMNDChuHoString;
    }
    public void setcMNDChuHoString(String cMNDChuHoString) {
        this.cMNDChuHoString = cMNDChuHoString;
    }
    public String getDiaChiHK() {
        return diaChiHK;
    }
    public void setDiaChiHK(String diaChiHK) {
        this.diaChiHK = diaChiHK;
    }
    public Date getNgayLap() {
        return ngayLap;
    }
    public void setNgayLap(Date ngayLap) {
        this.ngayLap = ngayLap;
    }
    
}
