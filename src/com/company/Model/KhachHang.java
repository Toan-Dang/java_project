package com.company.Model;

import java.util.Date;
import java.util.List;

public class KhachHang {
    private int MaKH;
    private int MaLKH;
    private String UserName;
    private Date NgaySinh;
    private String GioiTinh;
    private String DiaChi;
    private String SDT;
    private String CMND;
    private String Email;
    private String DoanhSo;
    private String TenKH;

    KhachHang(){}
    KhachHang(  int MaKH,
             int MaLKH,
             String UserName,
             Date NgaySinh,
             String GioiTinh,
             String DiaChi,
             String SDT,
             String CMND,
             String Email,
             String DoanhSo,
             String TenKH)
    {
        this.MaKH= MaKH;
        this.MaLKH = MaLKH;
        this.UserName = UserName;
        this.NgaySinh = NgaySinh;
        this.GioiTinh = GioiTinh;
        this.DiaChi = DiaChi;
        this.SDT = SDT;
        this.CMND = CMND;
        this.Email = Email;
        this.DoanhSo = DoanhSo;
        this.TenKH = TenKH;
    }



    List<PhieuThuePhong> ptp;
}
