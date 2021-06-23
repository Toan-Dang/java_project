package com.company.Controller;

import com.company.Data.ConnectionOracle;
import com.company.Model.ChiTietDichVu;
import com.company.Model.ChiTietPhieuThuePhong;
import com.company.Model.ChiTietThietHai;
import com.company.Model.ThanhToan;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class ThanhToanController {
    public static ArrayList<ThanhToan> listphieu() {
        ArrayList<ThanhToan> listphieu = new ArrayList<>();
        Connection connection = ConnectionOracle.getConnection();
        String query = "SELECT MAPTP, TENKH, CMND, SDT,EMAIL ,tinhtrangthanhtoan  FROM KHACHHANG A JOIN PHIEU_THUE_PHONG B ON A.MAKH = B.MAKH WHERE B.TINHTRANGTHANHTOAN = 0";
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            String tinhtrang = "";
            String LoaiPhieu = "Phiếu thuê phòng";
            while (rs.next()) {
                int maphieu = rs.getInt(1);
                String tenkh = rs.getString(2);
                String cmnd = rs.getString(3);
                String sdt = rs.getString(4);
                String email = rs.getString(5);
                int tt = rs.getInt(6);
                if (tt == 0) tinhtrang = "Chưa thanh toán";
                listphieu.add(new ThanhToan(maphieu, tenkh, cmnd, sdt, email, LoaiPhieu, tinhtrang));
            }
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listphieu;
    }

    public static Date getNgayLapPhieu(int mahd) {
        Date nlp = null;
        try {
            Connection con = ConnectionOracle.getConnection();
            String query = "select ngaylapptp  from phieu_thue_phong where maptp = " + mahd;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                nlp = rs.getDate(1);
            }
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return nlp;
    }

    public static String getTienPhong(int mahd) {
        String tien = "";
        try {
            Connection con = ConnectionOracle.getConnection();
            String query = "select sum(tongtienthanhtoan)  from phieu_thue_phong where maptp = " + mahd;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                tien = rs.getString(1);
            }
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return tien;
    }

    public static String getTienDichVu(int mahd) {
        String tien = "";
        try {
            Connection con = ConnectionOracle.getConnection();
            String query = "select sum(TONGTIENDV)  from PHIEUDICHVU where maptp = " + mahd;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                tien = rs.getString(1);
            }
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return tien;
    }

    public static String getTienPhieuThu(int mahd) {
        String tien = "";
        try {
            Connection con = ConnectionOracle.getConnection();
            String query = "select sum(TONGTIENPT)  from PhieuThu where maptp = " + mahd;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                tien = rs.getString(1);
            }
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return tien;
    }

    public static int getTongTien(int mahd) {
        int tien = 0;

        if (getTienPhong(mahd) != null) tien += Integer.parseInt(getTienPhong(mahd));
        if (getTienDichVu(mahd) != null) tien += Integer.parseInt(getTienDichVu(mahd));
        if (getTienPhieuThu(mahd) != null) tien += Integer.parseInt(getTienPhieuThu(mahd));
        return tien;
    }

    public  static  int getMaKM(String tenkm){
        int makm = 0;
        try {
            Connection con = ConnectionOracle.getConnection();
            String query = "select makm from khuyenmai \n" +
                    "where tenkm = '"+ tenkm +"'" ;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                makm = rs.getInt(1);
            }
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return makm;
    }

    public static int getTongTien_KM(int tienz, String makm) {
        int tienkm = 0;
        try {
            Connection con = ConnectionOracle.getConnection();
            String query = "select tienduocgiam from khuyenmai \n" +
                    "where tenkm = '"+ makm +"'" ;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                tienkm = rs.getInt(1);
            }
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return tienz-tienkm;
    }

    public static ArrayList<ChiTietPhieuThuePhong> listctptp(int mahd) {
        ArrayList<ChiTietPhieuThuePhong> listctptp = new ArrayList<>();
        Connection connection = ConnectionOracle.getConnection();
        String query = " select c.maphong, d.tenloaiphong , b.ngaynhanphong,b.ngaytraphong,  a.tongtienthanhtoan,d.gia from phieu_thue_phong a, CHITIET_PHIEUTHUEPHONG b, Phong c, LoaiPhong d \n" +
                " where a.maptp = " + mahd + " and b.maptp =a.maptp and c.maphong = b.maphong and c.maloaiphong = d.maloaiphong";
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                int maphong = rs.getInt(1);
                String tenlp = rs.getString(2);
                Date nnp = rs.getDate(3);
                Date ntp = rs.getDate(4);
                double tien = rs.getDouble(5);
                double gia = rs.getDouble(6);
                listctptp.add(new ChiTietPhieuThuePhong(maphong, tenlp, nnp, ntp, tien, gia));
            }
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listctptp;
    }

    public static ArrayList<ChiTietDichVu> listctdv(int mahd) {
        ArrayList<ChiTietDichVu> listctdv = new ArrayList<>();
        Connection connection = ConnectionOracle.getConnection();
        String query = "select tendichvu, gia, soluong, gia*soluong from PHIEUDICHVU a, DICHVU b, CHITIETDV c where a.maptp = " + mahd + " and c.MAPDV = a.MAPDV and c.MADV = b.MADV";
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                String tendv = rs.getString(1);
                double gia = rs.getDouble(2);
                int sl = rs.getInt(3);
                double tien = rs.getDouble(4);
                listctdv.add(new ChiTietDichVu(tendv, gia, sl, tien));
            }
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listctdv;
    }

    public static ArrayList<ChiTietThietHai> listctth(int mahd) {
        ArrayList<ChiTietThietHai> listctth = new ArrayList<>();
        Connection connection = ConnectionOracle.getConnection();
        String query = "select TENTHIETBI, gia, soluong, gia*soluong from PHIEUTHU a, THIETHAI b, CHITIET_THIETHAI c where a.maptp = "+mahd+" and c.MAPT = a.MAPT and c.MATHIETHAI = b.MATHIETHAI";
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                String tendv = rs.getString(1);
                double gia = rs.getDouble(2);
                int sl = rs.getInt(3);
                double tien = rs.getDouble(4);
                listctth.add(new ChiTietThietHai(tendv, gia, sl, tien));
            }
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listctth;
    }

    public static void getKhuyenMailist(JComboBox<String> list, int makh){
        String query = "select TENKM from khachhang a, LOAIKH b, CHI_TIET_KHUYENMAI c, KHUYENMAI d \n" +
                "where A.MALKH = B.MALKH \n" +
                "and B.MALKH = C.MALKH\n" +
                "and C.MAKM = D.MAKM\n" +
                "and a.makh = "+ makh;
        try{

            Connection con = ConnectionOracle.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            list.addItem("");
            while(rs.next()){
                String name = rs.getString("TENKM");
                list.addItem(name);
            }
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void ThanhToan(int tien , int makh, int manv, int mahd, int makm){
        String query = "begin ThanhToan_update( ? , ? , ? , ? , ? );end;";
        try {
            Connection con = ConnectionOracle.getConnection();
            PreparedStatement pt = con.prepareStatement(query);

           pt.setInt(1,mahd);
           pt.setInt(2,makh);
           pt.setInt(3,manv);
           pt.setInt(4,tien);
           pt.setInt(5,makm);

            pt.execute();
            con.close();
            JOptionPane.showMessageDialog(null, "Success ThanhToan");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }



}
