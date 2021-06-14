package com.company.View.NhanVien.QuanLyNhanVien;

import com.company.Data.ConnectionOracle;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

public class ThongTinNhanVien extends JFrame {

    JFrame frame = new JFrame();
    public ThongTinNhanVien(int manv ) {
        frame.setVisible(true);
        frame.setBounds(100, 100, 1050, 730);

        frame.setLocationRelativeTo(null);
        frame.setTitle("Thêm Nhan Vien");

        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setBackground(new Color(253, 252, 252));
        frame.add(contentPane);

        JPanel panel1 = new JPanel();
        panel1.setBorder(new EmptyBorder(5, 5, 5, 5));
        panel1.setBounds(15, 0, 1010, 100);
        panel1.setBackground(new Color(125, 120, 92));
        panel1.setLayout(null);
        contentPane.add(panel1);

        JLabel name = new JLabel("Thêm Nhan Vien");
        name.setBounds(0, 0, 1000, 50);
        name.setHorizontalAlignment(SwingConstants.CENTER);
        name.setVerticalAlignment(SwingConstants.CENTER);
        name.setFont(new Font("Tahoma", Font.BOLD, 30));
        name.setBackground(new Color(189, 44, 44));
        panel1.add(name);

        name.setBounds(0, 55, 100, 50);
        name.setHorizontalAlignment(SwingConstants.CENTER);
        name.setVerticalAlignment(SwingConstants.CENTER);
        name.setFont(new Font("Tahoma", Font.BOLD, 30));
        name.setBackground(new Color(189, 44, 44));
        panel1.add(name);

        JTextField txtusername = new JTextField();
        txtusername.setEditable(false);
        txtusername.setBounds(100, 55, 200, 30);
        panel1.add(txtusername);

        JPanel panel2 = new JPanel();
        panel2.setBounds(0, 100, 1010, 630);
        panel2.setBackground(new Color(245, 240, 240, 255));
        panel2.setLayout(null);
        contentPane.add(panel2);
////left label
        JLabel lbmaphong = new JLabel("Tên");
        lbmaphong.setBounds(0, 0, 100, 100);
        lbmaphong.setHorizontalAlignment(SwingConstants.CENTER);
        lbmaphong.setVerticalAlignment(SwingConstants.CENTER);
        lbmaphong.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbmaphong.setBackground(new Color(220, 68, 68));
        panel2.add(lbmaphong);

        JLabel lbtenkh = new JLabel("CMND/CCCD");
        lbtenkh.setBounds(0, 105, 160, 100);
        lbtenkh.setHorizontalAlignment(SwingConstants.CENTER);
        lbtenkh.setVerticalAlignment(SwingConstants.CENTER);
        lbtenkh.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbtenkh.setBackground(new Color(220, 68, 68));
        panel2.add(lbtenkh);

        JLabel lbcmnd = new JLabel("SDT");
        lbcmnd.setBounds(0, 205, 100, 100);
        lbcmnd.setHorizontalAlignment(SwingConstants.CENTER);
        lbcmnd.setVerticalAlignment(SwingConstants.CENTER);
        lbcmnd.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbcmnd.setBackground(new Color(220, 68, 68));
        panel2.add(lbcmnd);

        JLabel diachi = new JLabel("Dia chi");
        diachi.setBounds(0, 305, 150, 100);
        diachi.setHorizontalAlignment(SwingConstants.CENTER);
        diachi.setVerticalAlignment(SwingConstants.CENTER);
        diachi.setFont(new Font("Tahoma", Font.PLAIN, 20));
        diachi.setBackground(new Color(220, 68, 68));
        panel2.add(diachi);

        JLabel chucvu = new JLabel("Chucvu");
        chucvu.setBounds(0, 405, 150, 100);
        chucvu.setHorizontalAlignment(SwingConstants.CENTER);
        chucvu.setVerticalAlignment(SwingConstants.CENTER);
        chucvu.setFont(new Font("Tahoma", Font.PLAIN, 20));
        chucvu.setBackground(new Color(220, 68, 68));
        panel2.add(chucvu);


        ///right label
        JLabel NgaySinh = new JLabel("Ngày Sinh");
        NgaySinh.setBounds(500, 0, 200, 100);
        NgaySinh.setHorizontalAlignment(SwingConstants.CENTER);
        NgaySinh.setVerticalAlignment(SwingConstants.CENTER);
        NgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 20));
        NgaySinh.setBackground(new Color(220, 68, 68));
        panel2.add(NgaySinh);

        JLabel gioitinh = new JLabel("Gioi Tinh");
        gioitinh.setBounds(500, 105, 200, 100);
        gioitinh.setHorizontalAlignment(SwingConstants.CENTER);
        gioitinh.setVerticalAlignment(SwingConstants.CENTER);
        gioitinh.setFont(new Font("Tahoma", Font.PLAIN, 20));
        gioitinh.setBackground(new Color(220, 68, 68));
        panel2.add(gioitinh);

        JLabel email = new JLabel("Email");
        email.setBounds(500, 205, 200, 100);
        email.setHorizontalAlignment(SwingConstants.CENTER);
        email.setVerticalAlignment(SwingConstants.CENTER);
        email.setFont(new Font("Tahoma", Font.PLAIN, 20));
        email.setBackground(new Color(220, 68, 68));
        panel2.add(email);

        JLabel ngayvaolam = new JLabel("Ngay vao lam");
        ngayvaolam.setBounds(500, 305, 200, 100);
        ngayvaolam.setHorizontalAlignment(SwingConstants.CENTER);
        ngayvaolam.setVerticalAlignment(SwingConstants.CENTER);
        ngayvaolam.setFont(new Font("Tahoma", Font.PLAIN, 20));
        ngayvaolam.setBackground(new Color(220, 68, 68));
        panel2.add(ngayvaolam);


        JLabel nql = new JLabel("ngqly");
        nql.setBounds(500, 405, 150, 100);
        nql.setHorizontalAlignment(SwingConstants.CENTER);
        nql.setVerticalAlignment(SwingConstants.CENTER);
        nql.setFont(new Font("Tahoma", Font.PLAIN, 20));
        nql.setBackground(new Color(220, 68, 68));
        panel2.add(nql);


//left text

        JTextField txttennv = new JTextField();
        txttennv.setBounds(170, 40, 300, 30);
        panel2.add(txttennv);

        JTextField txtcmnd = new JTextField();
        txtcmnd.setBounds(170, 140, 300, 30);
        panel2.add(txtcmnd);

        JTextField txtsdt = new JTextField();
        txtsdt.setBounds(170, 240, 300, 30);
        panel2.add(txtsdt);

        JTextField txtdiachi = new JTextField();
        txtdiachi.setBounds(170, 340, 300, 30);
        panel2.add(txtdiachi);

        JTextField txtchucvu = new JTextField();
        txtchucvu.setBounds(170, 440, 300, 30);
        txtchucvu.setEditable(false);
        panel2.add(txtchucvu);

//right text

        UtilDateModel modelngaysinh = new UtilDateModel();
        Properties pz = new Properties();
        pz.put("text.today", "Today");
        pz.put("text.month", "Month");
        pz.put("text.year", "Year");
        modelngaysinh.setSelected(true);
       JDatePanelImpl datePanelz = new JDatePanelImpl(modelngaysinh, pz);
        JDatePickerImpl pickngaysinh = new JDatePickerImpl(datePanelz, new ThemNhanVien.DateLabelFormatter());
        pickngaysinh.setBounds(705, 40, 300, 30);
        panel2.add(pickngaysinh);

        JRadioButton rb1 = new JRadioButton("Male");
        rb1.setBounds(705, 140, 100, 30);
        JRadioButton rb2 = new JRadioButton("Female");
        rb2.setBounds(805, 140, 100, 30);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rb1);
        bg.add(rb2);
        panel2.add(rb1);
        panel2.add(rb2);

        JTextField txtemail = new JTextField();
        txtemail.setBounds(705, 240, 300, 30);
        panel2.add(txtemail);

        UtilDateModel modelngayvaolam = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        modelngayvaolam.setSelected(true);
        JDatePanelImpl datePanel = new JDatePanelImpl(modelngayvaolam, p);
        JDatePickerImpl pickngayvaolam = new JDatePickerImpl(datePanel, new ThemNhanVien.DateLabelFormatter());
        pickngayvaolam.setBounds(705, 340, 300, 30);
        panel2.add(pickngayvaolam);

        JTextField txtngql = new JTextField();
        txtngql.setBounds(705, 440, 300, 30);
        txtngql.setEditable(false);
        panel2.add(txtngql);

        try{
            Connection con = ConnectionOracle.getConnection();
            String query = "SELECT USERNAME,HOTENNV,SDT,CMND,EMAIL,GIOITINH ,NGAYSINH,CHUCVU,NGUOIQUANLY,NGAYVAOLAM FROM NHANVIEN WHERE MANV = " + "'"+manv+"'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()){
                txtusername.setText(rs.getString(1));
                txttennv.setText(rs.getString(2));
                txtsdt.setText(rs.getString(3));
                txtcmnd.setText(rs.getString(4));
                txtemail.setText(rs.getString(5));
                String gender = rs.getString(6);

                var dt = rs.getDate(7);
                modelngaysinh.setValue(dt);
                 datePanelz = new JDatePanelImpl(modelngaysinh, pz);
                 pickngaysinh = new JDatePickerImpl(datePanelz, new ThemNhanVien.DateLabelFormatter());

                txtchucvu.setText(rs.getString(8));
                txtngql.setText(rs.getString(9));

                var dt2 = rs.getDate(10);
                modelngayvaolam.setValue(dt2);
                 datePanel = new JDatePanelImpl(modelngayvaolam, p);
                 pickngayvaolam = new JDatePickerImpl(datePanel, new ThemNhanVien.DateLabelFormatter());
                if(gender.equals("NAM")){
                    rb1.setSelected(true);
                    rb2.setSelected(false);
                }
                else{
                    rb2.setSelected(true);
                    rb1.setSelected(false);
                }
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
///

        JButton save = new JButton("save");
        save.setBounds(400, 530, 100, 60);
        save.setBackground(new Color(0, 219, 255));
        save.setForeground(new Color(0, 0, 0));
        save.setOpaque(true);

        panel2.add(save);

        JButton cancel = new JButton("cancel");
        cancel.setBounds(500, 530, 100, 60);
        cancel.setBackground(new Color(255, 0, 6));
        cancel.setForeground(new Color(0, 0, 0));
        cancel.setOpaque(false);
        panel2.add(cancel);

        cancel.addActionListener(e -> {
            frame.dispose();
             new QuanLyNhanVien();
        });

        JDatePickerImpl finalPickngaysinh = pickngaysinh;
        JDatePickerImpl finalPickngayvaolam = pickngayvaolam;
        save.addActionListener(e -> {

            java.util.Date datengaysinh = (java.util.Date) finalPickngaysinh.getModel().getValue();
            Date sqldatengaysinh = new Date(datengaysinh.getTime());
            java.util.Date datengayvaolam = (java.util.Date) finalPickngayvaolam.getModel().getValue();
            Date sqldatengayvaolam = new Date(datengayvaolam.getTime());

            try {
                String query2 = "BEGIN UPDATE_EMPLOYEE_INFO( ? , ? , ? , ? , ? , ? , ? , ? ); END;";
                Connection con = ConnectionOracle.getConnection();

                PreparedStatement pt2 = con.prepareStatement(query2);
                pt2.setInt(1, manv);
                pt2.setString(2, txttennv.getText());
                pt2.setString(4, bg.getSelection().getActionCommand());
                pt2.setDate(3, sqldatengaysinh);
                pt2.setString(5, txtdiachi.getText());
                pt2.setString(6, txtsdt.getText());
                pt2.setString(7, txtcmnd.getText());
                pt2.setDate(8, sqldatengayvaolam);

                pt2.execute();

                con.close();
                JOptionPane.showMessageDialog(null, "Success update");
                frame.dispose();
              new QuanLyNhanVien();

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        });
    }


    public static class DateLabelFormatter extends JFormattedTextField.AbstractFormatter {

        private final String datePattern = "dd--MM--yyyy";
        private final SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

        @Override
        public Object stringToValue(String text) throws ParseException {
            return dateFormatter.parseObject(text);
        }

        @Override
        public String valueToString(Object value) {
            if (value != null) {
                Calendar cal = (Calendar) value;
                return dateFormatter.format(cal.getTime());
            }

            return "";
        }

    }


    public static class DrawCircle extends JFrame {

        public DrawCircle() {
            setTitle("Drawing a Circle");
            setSize(250, 250);
            setVisible(true);
            setDefaultCloseOperation(EXIT_ON_CLOSE);

        }

        @Override
        public void paint(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            Shape circleShape = new Ellipse2D.Double(100, 100, 100, 100);

            g2d.draw(circleShape);
        }


    }
}
