package com.company.Data;

import com.company.Model.PhieuThuePhong;
import com.company.Model.Phong;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class getListPTPData {
    public ArrayList<PhieuThuePhong> listphieuthuephong() {
        ArrayList<PhieuThuePhong> listptp = new ArrayList<>();
        Connection connection = ConnectionOracle.getConnection();
        String query = "SELECT A.MAPTP, B.CMND, A.NGAYLAPPTP, B.NGAYNHANPHONG, B.NGAYTRAPHONG, A.TINHTRANGTHANHTOAN, A.TONGTIENTHANHTOAN FROM PHIEU_THUE_PHONG A INNER JOIN CHITIET_PHIEUTHUEPHONG B ON A.MAPTP = B.MAPTP";
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                int MaPTP = rs.getInt(1);
                String TenKh = rs.getString(2);
                String TenNV = rs.getString(3);
                Date NgayPapPTP = rs.getDate(4);
                int TinhTrangThanhToan = rs.getInt(5);
                double TongTienThanhToan = rs.getDouble(6);
                Date NgayThanhToan = rs.getDate(7);

               // listptp.add(new PhieuThuePhong(MaPTP, TenKh, TenNV, NgayPapPTP, TinhTrangThanhToan, TongTienThanhToan, NgayThanhToan));
            }
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listptp;

    }
}
