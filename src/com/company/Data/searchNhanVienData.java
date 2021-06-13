package com.company.Data;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class searchNhanVienData {
  public static int  searchNhanVien(int r){
      int getusernamenv =0;
        try {
            Connection con = ConnectionOracle.getConnection();
            String query = "SELECT MANV FROM NHANVIEN WHERE rownum <=" + r + " MINUS SELECT MANV FROM NHANVIEN WHERE rownum <"+ r ;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                getusernamenv = rs.getInt("MANV");
            }

            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();


        }
        return getusernamenv;
    }
}
