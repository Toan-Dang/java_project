package com.company.Controller;

import com.company.Data.ConnectionOracle;
import com.company.Model.KhachHang;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class KhachHangController {
    public static ArrayList<KhachHang> listKhachHang() {
        ArrayList<KhachHang> listkh = new ArrayList<>();
        Connection connection = ConnectionOracle.getConnection();
        String query = "SELECT  MAKH,USERNAME, TENKH,TENLKH,SDT,CMND FROM KHACHHANG A JOIN LOAIKH B ON A.MALKH = B.MALKH ORDER BY MAKH";
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                int makh = rs.getInt(1);
                String username = rs.getString(2);
                String tenkh = rs.getString(3);
                String lkh = rs.getString(4);
                String sdt = rs.getString(5);
                String cmnd = rs.getString(6);
                username= (username.trim());
                listkh.add(new KhachHang(makh,username,tenkh,lkh,sdt,cmnd));
            }
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listkh;
    }

    public static int getMaKHrow(int r){
        int maphong = 0;
        String query = "SELECT MAKH FROM KHACHHANG WHERE ROWNUM <=" + r + " MINUS SELECT MAKH FROM KHACHHANG WHERE ROWNUM <" + r ;
        try{
            Connection con = ConnectionOracle.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while(rs.next()){
                maphong = rs.getInt("MAKH");
            }
            con.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return maphong;
    }
}
