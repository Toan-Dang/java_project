package com.company.Data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class searchDichVuData {
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
}
