package com.company.Data;

import com.company.Model.NhanVien;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class getListNhanVien {
    public static ArrayList<NhanVien> listnhanvien() {
        ArrayList<NhanVien> listnhanvien = new ArrayList<>();
        Connection connection = ConnectionOracle.getConnection();
        String query = "SELECT MANV,HOTENNV,USERNAME,CHUCVU FROM NHANVIEN";
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                int manv = rs.getInt(1);
                String hotennv = rs.getString(2);
                String username = rs.getString(3);
                String chucvu = rs.getString(4);

                listnhanvien.add(new NhanVien(manv, hotennv, username, chucvu));
            }
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listnhanvien;
    }
}
