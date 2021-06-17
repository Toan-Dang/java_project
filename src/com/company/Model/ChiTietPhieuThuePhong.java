package com.company.Model;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class ChiTietPhieuThuePhong {
    private int MaPTP;
    private int Maphong;
    private Date NgayNhanPhong;
    private Date NgayTraPhong;

    List<Phong> p;
    List<PhieuThuePhong> ptp;
  ChiTietPhieuThuePhong(){
  }
  ChiTietPhieuThuePhong(int maptp,int mapphong, Date nnp, Date ntp){
      MaPTP = maptp;
      Maphong = mapphong;
      NgayNhanPhong = nnp;
      NgayTraPhong = ntp;
  }

    public Date getNgayTraPhong() {
        return NgayTraPhong;
    }

    public void setNgayTraPhong(Date ngayTraPhong) {
        NgayTraPhong = ngayTraPhong;
    }

    public Date getNgayNhanPhong() {
        return NgayNhanPhong;
    }

    public void setNgayNhanPhong(Date ngayNhanPhong) {
        NgayNhanPhong = ngayNhanPhong;
    }

    public int getMaPTP() {
        return MaPTP;
    }

    public void setMaPTP(int maPTP) {
        MaPTP = maPTP;
    }

    public int getMaphong() {
        return Maphong;
    }

    public void setMaphong(int maphong) {
        Maphong = maphong;
    }

}
