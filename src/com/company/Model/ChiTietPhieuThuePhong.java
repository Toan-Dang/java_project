package com.company.Model;

import java.util.Date;
import java.util.Map;

public class ChiTietPhieuThuePhong {
   private int MaPTP;
    private String CMND;
    private int MaPhong;
    private Date NgayNhanPhong;
    private Date NgayTraPhong;

    ChiTietPhieuThuePhong(){}

    ChiTietPhieuThuePhong(String _CMND, int _Maphong, Date _ngaynhanphong, Date _ngaytraphong){
        CMND = _CMND;
        MaPhong = _Maphong;
        NgayNhanPhong = _ngaynhanphong;
        NgayTraPhong = _ngaytraphong;
    }

    public int getMaPTP() {
        return MaPTP;
    }

    public void setMaPTP(int maPTP) {
        MaPTP = maPTP;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public int getMaPhong() {
        return MaPhong;
    }

    public void setMaPhong(int maPhong) {
        MaPhong = maPhong;
    }

    public Date getNgayNhanPhong() {
        return NgayNhanPhong;
    }

    public void setNgayNhanPhong(Date ngayNhanPhong) {
        NgayNhanPhong = ngayNhanPhong;
    }

    public Date getNgayTraPhong() {
        return NgayTraPhong;
    }

    public void setNgayTraPhong(Date ngayTraPhong) {
        NgayTraPhong = ngayTraPhong;
    }
}
