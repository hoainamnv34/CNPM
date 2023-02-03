package Models;

import java.util.Date;

public class TamTru {
    private String MTT;
    private String MNK;
    private String MHK;
    private Date tuNgay;
    private Date denNgay;
    private String lyDo;
    private Date ngayLap;

    public String getMTT() {
        return MTT;
    }
    public void setMTT(String mTT) {
        MTT = mTT;
    }
    public String getMNK() {
        return MNK;
    }
    public void setMNK(String mNK) {
        MNK = mNK;
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
    public Date getNgayLap() {
        return ngayLap;
    }
    public void setNgayLap(Date ngayLap) {
        this.ngayLap = ngayLap;
    }
    public String getMHK() {
        return MHK;
    }
    public void setMHK(String mHK) {
        MHK = mHK;
    }
}
