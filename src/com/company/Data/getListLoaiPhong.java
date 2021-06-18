package com.company.Data;

import com.company.Model.LoaiPhong;
import com.company.Model.Phong;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class getListLoaiPhong {
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
}
