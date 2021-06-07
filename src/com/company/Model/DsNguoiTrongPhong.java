package com.company.Model;

import java.util.Date;

public class DsNguoiTrongPhong {
    private String TenKH;
    private String CMND;
    private String GioiTinh;
    private Date NgaySinh;
    private String LoaiKH;
    private String DiaChi;
    private int MaPhong;

    DsNguoiTrongPhong() {
    }

    DsNguoiTrongPhong(String _TenKH, String _CMND,String _GioiTinh,
                      Date _NgaySinh, String _LoaiKH, String _DiaChi, int _MaPhong) {
        TenKH = _TenKH;
        CMND = _CMND;
        GioiTinh = _GioiTinh;
        NgaySinh = _NgaySinh;
        LoaiKH = _LoaiKH;
        DiaChi = _DiaChi;
        MaPhong = _MaPhong;
    }

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String tenKH) {
        TenKH = tenKH;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        GioiTinh = gioiTinh;
    }

    public int getMaPhong() {
        return MaPhong;
    }

    public void setMaPhong(int maPhong) {
        MaPhong = maPhong;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        NgaySinh = ngaySinh;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setLoaiKH(String loaiKH) {
        LoaiKH = loaiKH;
    }

    public String getLoaiKH() {
        return LoaiKH;
    }
}
