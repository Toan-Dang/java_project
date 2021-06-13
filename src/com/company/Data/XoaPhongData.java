package com.company.Data;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class XoaPhongData {
    public XoaPhongData(int r){
        try {
            Connection con = ConnectionOracle.getConnection();
            String query = "DELETE FROM PHONG WHERE MAPHONG = (SELECT MAPHONG FROM PHONG WHERE ROWNUM <=" + r + " MINUS SELECT MAPHONG FROM PHONG WHERE ROWNUM <" + r + " )";
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
