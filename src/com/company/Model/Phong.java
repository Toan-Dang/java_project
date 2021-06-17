package com.company.Model;

import java.util.List;

public class Phong {
    private int MaPhong;
    private String MaLoaiPhong;
    private String TinhTrang;
    private String GhiChu;
    private int SoLuongNguoiHienTai;

    List<LoaiPhong> loaiPhongs;
    public Phong(){

    }
    public Phong(int maphong, String maloaiphong, int soluong, String tinhtrang){
        this.MaPhong = maphong;
        this.MaLoaiPhong = maloaiphong;
        this.TinhTrang = tinhtrang;
        this.SoLuongNguoiHienTai = soluong;

    }

    public Phong(String MaLoaiPhong, String TinhTrang, String GhiChu){
        this.MaLoaiPhong = MaLoaiPhong;
        this.TinhTrang = TinhTrang;
        this.GhiChu = GhiChu;
    }

    public Phong(String MaLoaiPhong, String GhiChu){
        this.MaLoaiPhong = MaLoaiPhong;
        this.GhiChu = GhiChu;
    }

    public String getMaLoaiPhong() {
        return MaLoaiPhong;
    }

    public void setMaLoaiPhong(String maLoaiPhong) {
        MaLoaiPhong = maLoaiPhong;
    }

    public String getTinhTrang() {
        return TinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        TinhTrang = tinhTrang;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String ghiChu) {
        GhiChu = ghiChu;
    }

    public int getMaPhong() {
        return MaPhong;
    }

    public void setMaPhong(int maPhong) {
        MaPhong = maPhong;
    }

    public int getSoLuongNguoiHienTai() {
        return SoLuongNguoiHienTai;
    }

    public void setSoLuongNguoiHienTai(int soLuongNguoiHienTai) {
        SoLuongNguoiHienTai = soLuongNguoiHienTai;
    }
}
