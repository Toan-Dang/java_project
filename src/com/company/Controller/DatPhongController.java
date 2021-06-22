package com.company.Controller;

import com.company.Data.ConnectionOracle;
import com.company.View.NhanVien.TongQuan.Phong.TongQuan_ThongTinPhong_DatPhong;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import java.sql.*;
import java.util.Properties;

public class DatPhongController {
    public static int Check(String cmnd) {
        String query = "SELECT CHECK_CMND_EXIST( '" + cmnd + "' ) AS RES FROM DUAL";
        int makh = -1;
        try {
            Connection con = ConnectionOracle.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                makh = rs.getInt(1);
            }
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return makh;
    }

    public static String GetTenKH(int makh) {
        String tenkh = "";
        try {
            Connection con = ConnectionOracle.getConnection();
            String query = "SELECT TENKH FROM KHACHHANG WHERE MAKH = " + makh;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                tenkh = rs.getString(1);
            }
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return tenkh;
    }

    public static Date GetNgaySinh(int makh) {
        Date ngSinh = null;
        try {
            Connection con = ConnectionOracle.getConnection();
            String query = "SELECT NGAYSINH FROM KHACHHANG WHERE MAKH = " + makh;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                ngSinh = rs.getDate(1);
            }
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return ngSinh;
    }

    public static void SetNgaySinh(int makh, UtilDateModel model, Properties p) {
        var dt = GetNgaySinh(makh);
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        model.setValue(dt);
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        JDatePickerImpl pick = new JDatePickerImpl(datePanel, new TongQuan_ThongTinPhong_DatPhong.DateLabelFormatter());

    }

    public static String GetGioiTinh(int makh) {
        String gt = "";
        try {
            Connection con = ConnectionOracle.getConnection();
            String query = "SELECT GIOITINH FROM KHACHHANG WHERE MAKH = " + makh;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                gt = rs.getString(1);
            }
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return gt;
    }

    public static void SetGioiTinh(JRadioButton nam, JRadioButton nu, int makh) {
        String gender = GetGioiTinh(makh);
        if (gender.equals("NAM")) {
            nam.setSelected(true);
            nu.setSelected(false);
        } else {
            nu.setSelected(true);
            nam.setSelected(false);
        }
    }

    public static String GetSDT(int makh) {
        String sdt = "";
        try {
            Connection con = ConnectionOracle.getConnection();
            String query = "SELECT SDT FROM KHACHHANG WHERE MAKH = " + makh;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                sdt = rs.getString(1);
            }
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return sdt;
    }

    public static String GetDiaChi(int makh) {
        String diachi = "";
        try {
            Connection con = ConnectionOracle.getConnection();
            String query = "SELECT DIACHI FROM KHACHHANG WHERE MAKH = " + makh;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                diachi = rs.getString(1);
            }
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return diachi;
    }

    public static void GetInfoKH_Makh(int makh, JTextField ten, JTextField diachi, JTextField sdt, JRadioButton nam, JRadioButton nu,
                                      UtilDateModel model, Properties p) {
        ten.setText(DatPhongController.GetTenKH(makh));
        diachi.setText(DatPhongController.GetDiaChi(makh));
        sdt.setText(DatPhongController.GetSDT(makh));
        DatPhongController.SetGioiTinh(nam, nu, makh);
        DatPhongController.SetNgaySinh(makh, model, p);
    }

    public static void CreateWithAvailabeKH(int maphong, JDatePickerImpl ngaynhanphong, JDatePickerImpl ngaytraphong,
                                            int makh, int manv) {
        String query = "BEGIN INSERT_INTO_PTP_CTPTP( ? , ? , ? , ? , ? ) ; END;";

        java.util.Date datengaynp = (java.util.Date) ngaynhanphong.getModel().getValue();
        java.sql.Date sqldatengaynp = new java.sql.Date(datengaynp.getTime());

        java.util.Date datengaytp = (java.util.Date) ngaytraphong.getModel().getValue();
        java.sql.Date sqldatengaytp = new java.sql.Date(datengaytp.getTime());

        try {
            Connection con = ConnectionOracle.getConnection();
            PreparedStatement pt = con.prepareStatement(query);

            pt.setInt(1, maphong);
            pt.setDate(2, sqldatengaynp);
            pt.setDate(3, sqldatengaytp);
            pt.setInt(4, makh);
            pt.setInt(5, manv);

            pt.execute();
            con.close();
            JOptionPane.showMessageDialog(null, "Success UPDATE");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void CreateWithNewKH(int maphong, JDatePickerImpl ngaynhanphong, JDatePickerImpl ngaytraphong,
                                       int manv, JTextField tenkh, String gioitinh, JDatePickerImpl NGSinh,
                                       JTextField SDT, JTextField DiaChi, JTextField CMND) {

        java.util.Date datengaysinh = (java.util.Date) NGSinh.getModel().getValue();
        java.sql.Date sqldatengaysinh = new java.sql.Date(datengaysinh.getTime());

        java.util.Date datengaynp = (java.util.Date) ngaynhanphong.getModel().getValue();
        java.sql.Date sqldatengaynp = new java.sql.Date(datengaynp.getTime());

        java.util.Date datengaytp = (java.util.Date) ngaytraphong.getModel().getValue();
        java.sql.Date sqldatengaytp = new java.sql.Date(datengaytp.getTime());


        String query = "BEGIN INSERT_INTO_KH_PTP_CTPTP( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? ) ; END;";
        try {
            Connection con = ConnectionOracle.getConnection();
            PreparedStatement pt = con.prepareStatement(query);

            pt.setInt(1, maphong);
            pt.setDate(2, sqldatengaynp);
            pt.setDate(3, sqldatengaytp);
            pt.setInt(4, manv);
            pt.setString(5, tenkh.getText());
            pt.setString(6, gioitinh);
            pt.setDate(7, sqldatengaysinh);
            pt.setString(8, SDT.getText());
            pt.setString(9, DiaChi.getText());
            pt.setString(10, CMND.getText());

            pt.execute();
            con.close();
            JOptionPane.showMessageDialog(null, "Success UPDATE");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
