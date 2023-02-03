package Models;


import java.util.Date;

public class TamVangModel {
    private String MTV;
    private String MNK;
    private String noiTamTru;
    private Date tuNgay;
    private Date denNgay;
    private String lyDo;
    
    public String getMTV() {
        return MTV;
    }
    public void setMTV(String mTV) {
        MTV = mTV;
    }
    public String getMNK() {
        return MNK;
    }
    public void setMNK(String mNK) {
        MNK = mNK;
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

