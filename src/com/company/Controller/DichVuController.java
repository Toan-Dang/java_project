package com.company.Controller;

import com.company.Data.ConnectionOracle;
import com.company.Model.DichVu;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class DichVuController {
    public static ArrayList<DichVu> listdv() {
        ArrayList<DichVu> listdv = new ArrayList<>();
        Connection connection = ConnectionOracle.getConnection();
        String query = "SELECT MADV,TENDICHVU, CHITIET ,GIA FROM DICHVU";
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                int madv = rs.getInt(1);
                String tendv = rs.getString(2);
                String chitiet = rs.getString(3);
                double gia = rs.getDouble(4);

                listdv.add(new DichVu(madv, tendv, chitiet, gia));
            }
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listdv;
    }
    public static void InsertDichVu(String tendv,String chitiet, String giaz){
        String query = "INSERT INTO DICHVU(TENDICHVU, CHITIET, GIA) VALUES ( ? , ? , ? )";
        try  {
            Connection con = ConnectionOracle.getConnection();
            PreparedStatement pt = con.prepareStatement(query);

            pt.setString(1,tendv);
            pt.setString(2,chitiet);
            int gia = Integer.parseInt(giaz);
            pt.setInt(3,gia);

            pt.execute();
            con.close();
            JOptionPane.showMessageDialog(null,"Success Insert");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void XoaDichVu(int r){
        try {
            Connection con = ConnectionOracle.getConnection();
            String query = "DELETE FROM DICHVU WHERE MADV = (SELECT MADV FROM DICHVU WHERE ROWNUM <=" + r + " MINUS SELECT MADV FROM DICHVU WHERE ROWNUM <" + r + " )";
            PreparedStatement pt = con.prepareStatement(query);
            pt.execute();
            con.close();
            JOptionPane.showMessageDialog(null, "Delete Success!!");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            JOptionPane.showMessageDialog(null, "Delete NOT Success!!");

        }
    }
    public static void UpdateDichVu(int ID,String tendv,String ghichu,String giaz){
        String query = "BEGIN UPDATE_SERVICES ( ? , ? , ? , ? );END;";
        try {
            Connection con = ConnectionOracle.getConnection();
            PreparedStatement pt = con.prepareStatement(query);
            pt.setInt(1,ID);
            pt.setString(2, tendv);
            pt.setString(3,ghichu );
            double gia = Double.parseDouble(giaz);
            pt.setDouble(4, gia);

            pt.execute();
            con.close();
            JOptionPane.showMessageDialog(null, "Success UPDATE");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static int searchDichVu(int r){
        int getdv = 0;
        try{
            Connection con = ConnectionOracle.getConnection();
            String query = "SELECT MADV FROM DICHVU WHERE rownum <=" + r + " MINUS SELECT MADV FROM DICHVU WHERE rownum <"+ r ;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                getdv = rs.getInt("MADV");
            }
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return getdv;
    }
    public static String getTenDichVuID(int ID){
        String madv = "";
        try{
            Connection con = ConnectionOracle.getConnection();
            String query = "SELECT TENDICHVU FROM DICHVU WHERE MADV = " + ID;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
               madv = rs.getString(1);
            }
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return madv;
    }
    public static double getGiaDichVuID(int ID){
        double madv =0;
        try{
            Connection con = ConnectionOracle.getConnection();
            String query = "SELECT GIA FROM DICHVU WHERE MADV = " + ID;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                madv = rs.getDouble(1);
            }
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return madv;
    }
    public static String getChiTietDichVuID(int ID){
        String madv = "";
        try{
            Connection con = ConnectionOracle.getConnection();
            String query = "SELECT CHITIET FROM DICHVU WHERE MADV = " + ID;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                madv = rs.getString(1);
            }
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return madv;
    }
}
