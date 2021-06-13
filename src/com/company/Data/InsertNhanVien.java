package com.company.Data;

import javax.swing.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertNhanVien {
    public InsertNhanVien(String username, String pass, String ten, String bg, Date ns,
                          String sdt, String cmnd, String email,Date nvl){
        String query = "INSERT INTO NGUOIDUNG (USERNAME, PASSWORD) VALUES( ? , ? )";
        String query2 = "INSERT INTO NHANVIEN (USERNAME,HOTENNV, GIOITINH, NGAYSINH, SDT, CMND, EMAIL, NGAYVAOLAM) VALUES( ? , ? , ? , ? , ? , ? , ? , ? )";
        try {
            Connection con = ConnectionOracle.getConnection();
            PreparedStatement pt = con.prepareStatement(query);

            pt.setString(1,username);
            pt.setString(2,pass);

            pt.execute();

            PreparedStatement pt2 = con.prepareStatement(query2);
            pt2.setString(1,username);
            pt2.setString(2,ten);
            pt2.setString(3,bg);
            pt2.setDate(4,ns);
            pt2.setString(5,sdt);
            pt2.setString(6,cmnd);
            pt2.setString(7,email);
            pt2.setDate(8,nvl);

            pt2.execute();
            con.close();
            JOptionPane.showMessageDialog(null, "Success Insert");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            JOptionPane.showMessageDialog(null, "not Insert");
        }
    }
}
