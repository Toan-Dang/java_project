package com.company.Model;

import java.util.Date;

public class PhieuThuePhong {
    private int MaPTP;
    private int Makh;
    private int MaNV;
    private Date NgayPapPTP;
    private Double TongTienThanhToan;
    private int TinhTrangThanhToan;
    private Date NgayThanhToan;
    private String TenKh;
    private String TenNV;

    public PhieuThuePhong() {
    }

    public PhieuThuePhong(int _MaPTP, String _TenKh, String _TenNV, Date _NgayPapPTP, int _TinhTrangThanhToan, double _TongTienThanhToan, Date _NgayThanhToan) {
        MaPTP = _MaPTP;
        TenKh = _TenKh;
        TenNV = _TenNV;
        NgayPapPTP = _NgayPapPTP;
        TongTienThanhToan = _TongTienThanhToan;
        TinhTrangThanhToan = _TinhTrangThanhToan;
        NgayThanhToan = _NgayThanhToan;

    }

    public int getMaPTP() {
        return MaPTP;
    }

    public void setMaPTP(int maPTP) {
        MaPTP = maPTP;
    }

    public int getMakh() {
        return Makh;
    }

    public void setMakh(int makh) {
        Makh = makh;
    }

    public int getMaNV() {
        return MaNV;
    }

    public void setMaNV(int maNV) {
        MaNV = maNV;
    }

    public Date getNgayPapPTP() {
        return NgayPapPTP;
    }

    public void setNgayPapPTP(Date ngayPapPTP) {
        NgayPapPTP = ngayPapPTP;
    }

    public Date getNgayThanhToan() {
        return NgayThanhToan;
    }

    public void setNgayThanhToan(Date ngayThanhToan) {
        NgayThanhToan = ngayThanhToan;
    }

    public Double getTongTienThanhToan() {
        return TongTienThanhToan;
    }

    public void setTongTienThanhToan(Double tongTienThanhToan) {
        TongTienThanhToan = tongTienThanhToan;
    }

    public int getTinhTrangThanhToan() {
        return TinhTrangThanhToan;
    }

    public void setTinhTrangThanhToan(int tinhTrangThanhToan) {
        TinhTrangThanhToan = tinhTrangThanhToan;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String tenNV) {
        TenNV = tenNV;
    }

    public String getTenKh() {
        return TenKh;
    }

    public void setTenKh(String tenKh) {
        TenKh = tenKh;
    }
}
