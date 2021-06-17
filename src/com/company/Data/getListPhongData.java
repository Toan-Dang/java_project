package com.company.Data;

import com.company.Model.Phong;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class getListPhongData {
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
}
