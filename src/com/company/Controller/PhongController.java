package com.company.Controller;

import com.company.Data.ConnectionOracle;
import com.company.Model.DanhSachDatTruoc;
import com.company.Model.LoaiPhong;
import com.company.Model.Phong;
import com.company.View.NhanVien.DSPHONG.QuanLyPhong;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class PhongController {
    public static ArrayList<Phong> listphong() {
        ArrayList<Phong> listphong = new ArrayList<>();
        Connection connection = ConnectionOracle.getConnection();
        String query = "SELECT MAPHONG,TENLOAIPHONG,SOLUONGNGUOI_HIENTAI,TINHTRANG FROM PHONG P inner join LOAIPHONG L on P.MALOAIPHONG = L.MALOAIPHONG ORDER BY MAPHONG";
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                int maphong = rs.getInt(1);
                String maloaiphong = rs.getString(2);
                int soluong = rs.getInt(3);
                String tinh_trang = rs.getString(4);

                if (tinh_trang != null) {
                    if (tinh_trang.equals("0")) tinh_trang = "trống";
                    if (tinh_trang.equals("1")) tinh_trang = "đã có người";
                    if (tinh_trang.equals("2")) tinh_trang = "đã được đặt";
                } else tinh_trang = "trống";
                listphong.add(new Phong(maphong, maloaiphong, soluong, tinh_trang));
            }
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listphong;
    }

    public static ArrayList<Phong> listphongfull() {
        ArrayList<Phong> listphongfull = new ArrayList<>();
        Connection connection = ConnectionOracle.getConnection();
        String query = "SELECT MAPHONG,TENLOAIPHONG,SOLUONGNGUOI_HIENTAI,TINHTRANG, GIA FROM PHONG P inner join LOAIPHONG L on P.MALOAIPHONG = L.MALOAIPHONG ORDER BY MAPHONG";
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                int maphong = rs.getInt(1);
                String maloaiphong = rs.getString(2);
                int soluong = rs.getInt(3);
                String tinh_trang = rs.getString(4);
                double gia = rs.getDouble(5);
                if (tinh_trang != null) {
                    if (tinh_trang.equals("0")) tinh_trang = "trống";
                    if (tinh_trang.equals("1")) tinh_trang = "đã có người";
                    if (tinh_trang.equals("2")) tinh_trang = "đã được đặt";
                } else tinh_trang = "trống";
                listphongfull.add(new Phong(maphong, maloaiphong, soluong, tinh_trang,gia));
            }
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listphongfull;
    }

    public static ArrayList<LoaiPhong> listloaiphong() {
        ArrayList<LoaiPhong> listloaiphong = new ArrayList<>();
        Connection connection = ConnectionOracle.getConnection();
        String query = "SELECT MALOAIPHONG,TENLOAIPHONG,GIA, SOLUONGTOIDA FROM LOAIPHONG";
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                int malp = rs.getInt(1);
                String tenlp = rs.getString(2);
                double gia = rs.getDouble(3);
                int sl = rs.getInt(4);

                listloaiphong.add(new LoaiPhong(malp,tenlp,gia,sl));

            }
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listloaiphong;
    }

    public static ArrayList<DanhSachDatTruoc> listdattruoc(int ID){
        ArrayList<DanhSachDatTruoc>list = new ArrayList<>();
        String querry = "SELECT MAPHONG, MAKH, NGAYDK, NGAYNHANPHONG, NGAYTRAPHONG from DANGKITRUOC WHERE MAPHONG = "+ ID;
        Connection con = ConnectionOracle.getConnection();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(querry);
            while (rs.next()){
                int maphong = rs.getInt(1);
                int makh = rs.getInt(2);
                java.util.Date ngdk = rs.getDate(3);
                java.util.Date nnp = rs.getDate(4);
                Date ntp = rs.getDate(5);

                list.add(new DanhSachDatTruoc(maphong,makh,ngdk,nnp,ntp));
            }
            con.close();
        } catch (SQLException throwables) {

            throwables.printStackTrace();
        }


        return  list;
    }

    public static boolean isDatPhong(int ID) {
        Connection connection = ConnectionOracle.getConnection();
        String query = "SELECT TINHTRANG FROM PHONG WHERE MAPHONG = " + ID;
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                int tinhtrang = rs.getInt(1);
                if(tinhtrang != 0){
                    connection.close();
                    return true;
                }
            }
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public static void XoaPhong(int maphong) {
        try {
            Connection con = ConnectionOracle.getConnection();
            String query = "DELETE FROM PHONG WHERE MAPHONG = "+maphong;
            PreparedStatement pt = con.prepareStatement(query);
            pt.execute();
            con.close();
            JOptionPane.showMessageDialog(null, "Delete Success!!");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            JOptionPane.showMessageDialog(null, "Delete NOT Success!!");

        }
    }

    public static void getLoaiPhonglist(JComboBox<String> list){
        String query = "SELECT TENLOAIPHONG FROM LOAIPHONG";
        try{

            Connection con = ConnectionOracle.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while(rs.next()){
                String name = rs.getString("TENLOAIPHONG");

                list.addItem(name);

            }
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static int getMaPhongID(int id){
        int maphong = 0;
        String query = "SELECT MAPHONG FROM PHONG WHERE MAPHONG = " + id;
        try{

            Connection con = ConnectionOracle.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while(rs.next()){
                maphong = rs.getInt("MAPHONG");
            }
            con.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return maphong;
    }

    public static int getMaPhongrow(int r){
        int maphong = 0;
        String query = "SELECT MAPHONG FROM PHONG WHERE ROWNUM <=" + r + " MINUS SELECT MAPHONG FROM PHONG WHERE ROWNUM <" + r ;
        try{

            Connection con = ConnectionOracle.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while(rs.next()){
                maphong = rs.getInt("MAPHONG");
            }
            con.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return maphong;
    }

    public  static  void InsertPhong( String ghichu, JComboBox<String> list){
        try{
            String query = "INSERT INTO PHONG(MALOAIPHONG,GHICHU) VALUES(?,?)";

            Connection con = ConnectionOracle.getConnection();
            PreparedStatement pt = con.prepareStatement(query);
            int MaLoaiPhong  = 0;
            String loaiphong = Objects.requireNonNull(list.getSelectedItem()).toString();
            if(loaiphong.equals("PHONG TONG THONG ")) MaLoaiPhong = 1;
            if(loaiphong.equals("PHONG DAC BIET")) MaLoaiPhong = 2;
            if(loaiphong.equals("PHONG LOAI 1")) MaLoaiPhong = 3;
            if(loaiphong.equals("PHONG LOAI 2")) MaLoaiPhong = 4;
            if(loaiphong.equals("PHONG LOAI 3")) MaLoaiPhong = 5;
            if(loaiphong.equals("PHONG CACH LI")) MaLoaiPhong = 6;

            pt.setInt(1,MaLoaiPhong);
            pt.setString(2,ghichu);
            pt.execute();

            con.close();
            JOptionPane.showMessageDialog(null,"Success Insert");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void UpdatePhong(int maphong, String ghichu,JComboBox<String> list){
        String query = "BEGIN UPDATE_ROOM ( ? , ? , ? );END;";
        try {
            Connection con = ConnectionOracle.getConnection();
            PreparedStatement pt = con.prepareStatement(query);
            int MaLoaiPhong = 0;
            String loaiphong = Objects.requireNonNull(list.getSelectedItem()).toString();
            if(loaiphong.equals("PHONG TONG THONG ")) MaLoaiPhong = 1;
            if(loaiphong.equals("PHONG DAC BIET")) MaLoaiPhong = 2;
            if(loaiphong.equals("PHONG LOAI 1")) MaLoaiPhong = 3;
            if(loaiphong.equals("PHONG LOAI 2")) MaLoaiPhong = 4;
            if(loaiphong.equals("PHONG LOAI 3")) MaLoaiPhong = 5;
            if(loaiphong.equals("PHONG CACH LI")) MaLoaiPhong = 6;

            pt.setInt(1,maphong);
            pt.setInt(2,MaLoaiPhong);
            pt.setString(3,ghichu);

            pt.execute();
            con.close();
            JOptionPane.showMessageDialog(null, "Success UPDATE");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
