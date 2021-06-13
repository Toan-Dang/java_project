package com.company.Data;

import com.company.Model.DichVu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class getListDichVuData {
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
}
