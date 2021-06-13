package com.company.Data;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class XoaNhanVienData {
    public XoaNhanVienData(int r){
        try {
            Connection con = ConnectionOracle.getConnection();
            String query = "DELETE FROM NHANVIEN WHERE MANV = (SELECT MANV FROM NHANVIEN WHERE ROWNUM <=" + r + " MINUS SELECT MANV FROM NHANVIEN WHERE ROWNUM <" + r + " )";
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
