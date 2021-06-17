package com.company.Data;

import com.company.Model.DanhSachDatTruoc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class getDSDatTruoc {
    public static ArrayList<DanhSachDatTruoc> listdattruoc(int ID){
        ArrayList<DanhSachDatTruoc>list = new ArrayList<>();
        String querry = "SELECT MAPHONG, MAKH, NGAYDK, NGAYNHANPHONG, NGAYTRAPHONG from DANGKITRUOC WHERE MAPHONG = "+ ID;
        Connection con = ConnectionOracle.getConnection();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(querry);
            while (rs.next()){
                int maphong = rs.getInt(1);
                int makh = rs.getInt(2);
                Date ngdk = rs.getDate(3);
                Date nnp = rs.getDate(4);
                Date ntp = rs.getDate(5);

                list.add(new DanhSachDatTruoc(maphong,makh,ngdk,nnp,ntp));
            }
            con.close();
        } catch (SQLException throwables) {

            throwables.printStackTrace();
        }


        return  list;
    }

}
