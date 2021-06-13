package com.company.Data;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateDichVuData {
    public UpdateDichVuData(int ID,String tendv,String ghichu,String giaz){
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
}
