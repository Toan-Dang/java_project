package com.company.View.NhanVien.QuanLyNhanVien;

import com.company.Data.InsertNhanVien;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

public class ThemNhanVien extends JFrame {

    JFrame frame = new JFrame();

    public ThemNhanVien() {
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
        name.setBounds(0, 0, 1000, 100);
        name.setHorizontalAlignment(SwingConstants.CENTER);
        name.setVerticalAlignment(SwingConstants.CENTER);
        name.setFont(new Font("Tahoma", Font.BOLD, 30));
        name.setBackground(new Color(189, 44, 44));
        panel1.add(name);

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

        JLabel username = new JLabel("Username");
        username.setBounds(0, 305, 150, 100);
        username.setHorizontalAlignment(SwingConstants.CENTER);
        username.setVerticalAlignment(SwingConstants.CENTER);
        username.setFont(new Font("Tahoma", Font.PLAIN, 20));
        username.setBackground(new Color(220, 68, 68));
        panel2.add(username);

        JLabel Password = new JLabel("Password");
        Password.setBounds(0, 405, 150, 100);
        Password.setHorizontalAlignment(SwingConstants.CENTER);
        Password.setVerticalAlignment(SwingConstants.CENTER);
        Password.setFont(new Font("Tahoma", Font.PLAIN, 20));
        Password.setBackground(new Color(220, 68, 68));
        panel2.add(Password);

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

        JLabel passwordz = new JLabel("Rewite password");
        passwordz.setBounds(500, 405, 200, 100);
        passwordz.setHorizontalAlignment(SwingConstants.CENTER);
        passwordz.setVerticalAlignment(SwingConstants.CENTER);
        passwordz.setFont(new Font("Tahoma", Font.PLAIN, 20));
        passwordz.setBackground(new Color(220, 68, 68));
        panel2.add(passwordz);

//left text
        JTextField txttennv = new JTextField();
        txttennv.setBounds(170, 40, 300, 30);
        panel2.add(txttennv);

        JTextField txtcmnd = new JTextField();
        txtcmnd.setBounds(170,140,300,30);
        panel2.add(txtcmnd);

        JTextField txtsdt = new JTextField();
        txtsdt.setBounds(170, 240, 300, 30);
        panel2.add(txtsdt);

        JTextField txtusername = new JTextField();
        txtusername.setBounds(170, 340, 300, 30);
        panel2.add(txtusername);

        JPasswordField txtpass1 = new JPasswordField();
        txtpass1.setBounds(170, 440, 300, 30);
        panel2.add(txtpass1);
//right text

        UtilDateModel modelngaysinh = new UtilDateModel();
        Properties pz = new Properties();
        pz.put("text.today", "Today");
        pz.put("text.month", "Month");
        pz.put("text.year", "Year");
        modelngaysinh.setSelected(true);
        JDatePanelImpl datePanelz = new JDatePanelImpl(modelngaysinh, pz);
        JDatePickerImpl pickngaysinh = new JDatePickerImpl(datePanelz, new DateLabelFormatter());
        pickngaysinh.setBounds(705, 40, 300, 30);
        panel2.add(pickngaysinh);

        JRadioButton rb1 = new JRadioButton("Male");
        rb1.setBounds(705, 140, 100, 30);

        JRadioButton  rb2 = new JRadioButton("Female");
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
        JDatePickerImpl pickngayvaolam = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        pickngayvaolam.setBounds(705, 340, 300, 30);
        panel2.add(pickngayvaolam);

        JPasswordField txtpass2 = new JPasswordField();
        txtpass2.setBounds(705, 440, 300, 30);
        panel2.add(txtpass2);
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
        final String[] gt = new String[1];
        rb1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                gt[0] = "NAM";
            }
        });
        rb2.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                gt[0] = "NU";
            }
        });


        cancel.addActionListener(e -> {
            frame.dispose();
           new QuanLyNhanVien();
        });

        save.addActionListener(e -> {
            String passText = new String(txtpass1.getPassword());
            String passText2 = new String(txtpass2.getPassword());
            if(passText.equals(passText2)) {
                java.util.Date datengaysinh= (java.util.Date) pickngaysinh.getModel().getValue();
                Date sqldatengaysinh = new Date(datengaysinh.getTime());
                java.util.Date datengayvaolam = (java.util.Date) pickngayvaolam.getModel().getValue();
                Date sqldatengayvaolam = new Date(datengayvaolam.getTime());

                new InsertNhanVien(txtusername.getText(),passText,txttennv.getText(), gt[0],
                        sqldatengaysinh,txtsdt.getText(),txtcmnd.getText(),txtemail.getText(),sqldatengayvaolam);
                frame.dispose();
               new QuanLyNhanVien();
            }
           else {
                JOptionPane.showMessageDialog(null, "Password Incorrect");
                txtpass2.setText("");
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
}
