package com.company.Data;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class XoaDichVuData {
   public XoaDichVuData(int r){
        try {
            Connection con = ConnectionOracle.getConnection();
            String query = "DELETE FROM DICHVU WHERE MADV = (SELECT MADV FROM DICHVU WHERE ROWNUM <=" + r + " MINUS SELECT MADV FROM DICHVU WHERE ROWNUM <" + r + " )";
            PreparedStatement pt = con.prepareStatement(query);
            pt.execute();
            con.close();
            JOptionPane.showMessageDialog(null, "Delete Success!!");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            JOptionPane.showMessageDialog(null, "Delete NOT Success!!");

        }
    }
}
