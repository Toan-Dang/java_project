package com.company.Model;

import java.util.Date;
import java.util.List;

public class PhieuThuePhong {
    private  int MaPTP;
    private  int MaKH;
    private  int MaNV;
    private Date NgaylapPTP;
    private  double TongTienThanhToan;
    private  String TinhTrangThanhToan;
    private  Date NgayThanhToan;


    PhieuThuePhong(){};
    PhieuThuePhong(int maptp, int makh , int manv, Date ngaylap, double tien, String tinhtrang, Date ngaythanhtoan){
        MaPTP = maptp;
        MaKH = makh;
        MaNV = manv;
        NgaylapPTP = ngaylap;
        TongTienThanhToan = tien;
        TinhTrangThanhToan = tinhtrang;
        NgayThanhToan = ngaythanhtoan;
    }
    PhieuThuePhong( int makh , int manv, Date ngaylap, double tien, String tinhtrang, Date ngaythanhtoan){
        MaKH = makh;
        MaNV = manv;
        NgaylapPTP = ngaylap;
        TongTienThanhToan = tien;
        TinhTrangThanhToan = tinhtrang;
        NgayThanhToan = ngaythanhtoan;
    }

    public void setMaPTP(int maPTP) {
        MaPTP = maPTP;
    }

    public int getMaPTP() {
        return MaPTP;
    }

    public void setMaNV(int maNV) {
        MaNV = maNV;
    }

    public int getMaNV() {
        return MaNV;
    }

    public void setTinhTrangThanhToan(String tinhTrangThanhToan) {
        TinhTrangThanhToan = tinhTrangThanhToan;
    }

    public String getTinhTrangThanhToan() {
        return TinhTrangThanhToan;
    }

    public void setTongTienThanhToan(double tongTienThanhToan) {
        TongTienThanhToan = tongTienThanhToan;
    }

    public Date getNgayThanhToan() {
        return NgayThanhToan;
    }

    public void setNgayThanhToan(Date ngayThanhToan) {
        NgayThanhToan = ngayThanhToan;
    }

    public Date getNgaylapPTP() {
        return NgaylapPTP;
    }

    public void setMaKH(int maKH) {
        MaKH = maKH;
    }

    public double getTongTienThanhToan() {
        return TongTienThanhToan;
    }

    public void setNgaylapPTP(Date ngaylapPTP) {
        NgaylapPTP = ngaylapPTP;
    }

    public int getMaKH() {
        return MaKH;
    }
}
