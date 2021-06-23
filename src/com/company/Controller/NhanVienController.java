package com.company.Controller;

import com.company.Data.ConnectionOracle;
import com.company.Model.KhachHang;
import com.company.Model.NhanVien;
import com.company.View.NhanVien.TongQuan.Phong.TongQuan_ThongTinPhong_DatPhong;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Properties;

public class NhanVienController {

    public static ArrayList<NhanVien> listNhanVien() {
        ArrayList<NhanVien> listNhanVien = new ArrayList<>();
        Connection connection = ConnectionOracle.getConnection();
        String query = "SELECT  MANV,USERNAME, HOTENNV,ChucVu,SDT,CMND FROM NHANVIEN ORDER BY MANV";
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                int manv = rs.getInt(1);
                String username = rs.getString(2);
                String tenkh = rs.getString(3);
                String lkh = rs.getString(4);
                String sdt = rs.getString(5);
                String cmnd = rs.getString(6);
                username= (username.trim());
                listNhanVien.add(new NhanVien(manv,username,tenkh,lkh,sdt,cmnd));
            }
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listNhanVien;
    }

    public static int getMANVrow(int r){
        int maphong = 0;
        String query = "SELECT MANV FROM NHANVIEN WHERE ROWNUM <=" + r + " MINUS SELECT MANV FROM NHANVIEN WHERE ROWNUM <" + r ;
        try{
            Connection con = ConnectionOracle.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while(rs.next()){
                maphong = rs.getInt("MANV");
            }
            con.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return maphong;
    }

    public static void XoaNhanVien(int manv) {
        try {
            Connection con = ConnectionOracle.getConnection();
            String query = "DELETE FROM NHANVIEN WHERE MANV = "+manv;
            PreparedStatement pt = con.prepareStatement(query);
            pt.execute();
            con.close();
            JOptionPane.showMessageDialog(null, "Delete Success!!");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            JOptionPane.showMessageDialog(null, "Delete NOT Success!!");

        }
    }

    public static String GetTenNV(int manv) {
        String tenkh = "";
        try {
            Connection con = ConnectionOracle.getConnection();
            String query = "SELECT HOTENNV FROM NHANVIEN WHERE MANV = " + manv;
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

    public static String GetEmailNV(int manv) {
        String tenkh = "";
        try {
            Connection con = ConnectionOracle.getConnection();
            String query = "SELECT EMAIL FROM NHANVIEN WHERE MANV = " + manv;
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

    public static String GetCMNDNV(int manv) {
        String tenkh = "";
        try {
            Connection con = ConnectionOracle.getConnection();
            String query = "SELECT CMND FROM NHANVIEN WHERE MANV = " + manv;
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

    public static String GetNGQLYNV(int manv) {
        String tenkh = "";
        try {
            Connection con = ConnectionOracle.getConnection();
            String query = "SELECT NGUOIQUANLY FROM NHANVIEN WHERE MANV = " + manv;
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

    public static Date GetNGVLNV(int manv) {
        Date tenkh = null;
        try {
            Connection con = ConnectionOracle.getConnection();
            String query = "SELECT NGAYVAOLAM FROM NHANVIEN WHERE MANV = " + manv;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                tenkh = rs.getDate(1);
            }
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return tenkh;
    }

    public static Date GetNgaySinhNV(int manv) {
        Date ngSinh = null;
        try {
            Connection con = ConnectionOracle.getConnection();
            String query = "SELECT NGAYSINH FROM NHANVIEN WHERE MANV = " + manv;
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

    public static void SetNgaySinhNV(int manv, UtilDateModel model, Properties p) {
        var dt = GetNgaySinhNV(manv);
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        model.setValue(dt);
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        JDatePickerImpl pick = new JDatePickerImpl(datePanel, new TongQuan_ThongTinPhong_DatPhong.DateLabelFormatter());

    }
    public static void SetNgayVaoLamNV(int manv, UtilDateModel model, Properties p) {
        var dt = GetNGVLNV(manv);
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        model.setValue(dt);
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        JDatePickerImpl pick = new JDatePickerImpl(datePanel, new TongQuan_ThongTinPhong_DatPhong.DateLabelFormatter());

    }
    public static String GetGioiTinhNV(int manv) {
        String gt = "";
        try {
            Connection con = ConnectionOracle.getConnection();
            String query = "SELECT GIOITINH FROM NHANVIEN WHERE MANV = " + manv;
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

    public static void SetGioiTinhNV(JRadioButton nam, JRadioButton nu, int manv) {
        String gender = GetGioiTinhNV(manv);
        if (gender.equals("NAM")) {
            nam.setSelected(true);
            nu.setSelected(false);
        } else {
            nu.setSelected(true);
            nam.setSelected(false);
        }
    }

    public static String GetSDTNV(int manv) {
        String sdt = "";
        try {
            Connection con = ConnectionOracle.getConnection();
            String query = "SELECT SDT FROM NHANVIEN WHERE MANV = " + manv;
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

    public static String GetDiaChiNV(int manv) {
        String diachi = "";
        try {
            Connection con = ConnectionOracle.getConnection();
            String query = "SELECT DIACHI FROM NHANVIEN WHERE MANV = " + manv;
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
    public static String GetUsernameNV(int manv) {
        String diachi = "";
        try {
            Connection con = ConnectionOracle.getConnection();
            String query = "select b.username from nhanvien a, nguoidung b where a.username = b.username and a.manv = " + manv;
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
    public static String GetPassNV(int manv) {
        String diachi = "";
        try {
            Connection con = ConnectionOracle.getConnection();
            String query = "select password from nhanvien a, nguoidung b where a.username = b.username and a.manv = " + manv;
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

    public static void GetInfoNV(int manv, JTextField ten, JTextField diachi, JTextField sdt, JRadioButton nam, JRadioButton nu,
                                      UtilDateModel model, Properties p, JTextField ngql, JTextField cmnd,
                                JTextField email,  UtilDateModel modelvl, Properties pvl ) {
        ten.setText(NhanVienController.GetTenNV(manv));
        diachi.setText(NhanVienController.GetDiaChiNV(manv));
        sdt.setText(NhanVienController.GetSDTNV(manv));
        ngql.setText(NhanVienController.GetNGQLYNV(manv));
        cmnd.setText(NhanVienController.GetCMNDNV(manv));
        email.setText(NhanVienController.GetEmailNV(manv));
        NhanVienController.SetGioiTinhNV(nam, nu, manv);
        NhanVienController.SetNgaySinhNV(manv, model, p);
        NhanVienController.SetNgayVaoLamNV(manv,modelvl,pvl);
    }

    public static void UpdateNhanVien(int manv, JTextField ngql, JTextField email,
                                       JTextField tennv, String gioitinh, JDatePickerImpl NGSinh, JDatePickerImpl NgVL
                                       ,JTextField SDT, JTextField DiaChi, JTextField  CMND) {

        java.util.Date datengaysinh = (java.util.Date) NGSinh.getModel().getValue();
        java.sql.Date sqldatengaysinh = new java.sql.Date(datengaysinh.getTime());

        java.util.Date datengayvl = (java.util.Date) NgVL.getModel().getValue();
        java.sql.Date sqldatengayvl = new java.sql.Date(datengayvl.getTime());

        String query = "BEGIN UPDATE_EMPLOYEE_INFO( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? ) ; END;";
        try {
            Connection con = ConnectionOracle.getConnection();
            PreparedStatement pt = con.prepareStatement(query);
            pt.setInt(1,manv);
            pt.setString(2,tennv.getText());
            pt.setDate(3,sqldatengaysinh);
            pt.setString(4,gioitinh);
            pt.setString(5,DiaChi.getText());
            pt.setString(6,SDT.getText());
            pt.setString(7,CMND.getText());
            pt.setString(8,email.getText());
            pt.setString(9,ngql.getText());
            pt.setDate(10,sqldatengayvl);

            pt.execute();
            con.close();
            JOptionPane.showMessageDialog(null, "Success UPDATE");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
