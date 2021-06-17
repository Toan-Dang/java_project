package com.company.Data;

import com.company.View.NhanVien.QuanLyDichVu.Quanlydichvu;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertDichVu {
   public InsertDichVu(String tendv,String chitiet, String giaz){
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
}
