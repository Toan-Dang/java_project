package com.company.Model;

import java.util.Date;

public class DanhSachDatTruoc {
    private int MaPhong;
    private int MaKH;
    private Date NgayDangKy;
    private Date NgayNhanPhong;
    private Date NgayTraPhong;

    public DanhSachDatTruoc(int maphong, int makh, Date ndk, Date nnp, Date ntp) {
        MaKH = makh;
        MaPhong = makh;
        NgayDangKy = ndk;
        NgayNhanPhong = nnp;
        NgayTraPhong = ntp;
    }
    public DanhSachDatTruoc( int makh, Date ndk, Date nnp, Date ntp) {
        MaKH = makh;
        NgayDangKy = ndk;
        NgayNhanPhong = nnp;
        NgayTraPhong = ntp;
    }
    public int getMaKH() {
        return MaKH;
    }

    public void setMaKH(int maKH) {
        MaKH = maKH;
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

    public int getMaPhong() {
        return MaPhong;
    }

    public void setMaPhong(int maPhong) {
        MaPhong = maPhong;
    }

    public Date getNgayDangKy() {
        return NgayDangKy;
    }

    public void setNgayDangKy(Date ngayDangKy) {
        NgayDangKy = ngayDangKy;
    }
}
