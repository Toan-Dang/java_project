package com.company.View.NhanVien.DSPHONG;

import com.company.Data.ConnectionOracle;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Objects;
import java.util.Properties;

public class ThemPTP extends JFrame {

    JFrame frame = new JFrame();
    private JComboBox<String> list;

    public ThemPTP() {
        frame.setVisible(true);
        frame.setBounds(100, 100, 1050, 730);

        frame.setLocationRelativeTo(null);
        frame.setTitle("Thêm Phiếu Thuê Phòng");

        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setBackground(new Color(253, 252, 252));
        frame.add(contentPane);

        JPanel panel1 = new JPanel();
        panel1.setBounds(0, 0, 1010, 100);
        panel1.setBackground(new Color(125, 120, 92));
        panel1.setLayout(null);
        contentPane.add(panel1);

        JLabel name = new JLabel("Thêm Phiếu Thuê Phòng");
        name.setBounds(0, 0, 1000, 100);
        name.setHorizontalAlignment(SwingConstants.CENTER);
        name.setVerticalAlignment(SwingConstants.CENTER);
        name.setFont(new Font("Tahoma", Font.BOLD, 30));
        name.setBackground(new Color(189, 44, 44));
        panel1.add(name);

        JPanel panel2 = new JPanel();
        panel2.setBounds(0, 100, 1010, 630);
        panel2.setBackground(new Color(255, 255, 255));
        panel2.setLayout(null);
        contentPane.add(panel2);

        JLabel lbmaphong = new JLabel("Mã Phòng");
        lbmaphong.setBounds(0, 0, 100, 100);
        lbmaphong.setHorizontalAlignment(SwingConstants.CENTER);
        lbmaphong.setVerticalAlignment(SwingConstants.CENTER);
        lbmaphong.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbmaphong.setBackground(new Color(220, 68, 68));
        panel2.add(lbmaphong);

        JLabel lbtenkh = new JLabel("Tên Khách Hàng");
        lbtenkh.setBounds(0, 105, 160, 100);
        lbtenkh.setHorizontalAlignment(SwingConstants.CENTER);
        lbtenkh.setVerticalAlignment(SwingConstants.CENTER);
        lbtenkh.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbtenkh.setBackground(new Color(220, 68, 68));
        panel2.add(lbtenkh);

        JLabel lbcmnd = new JLabel("CMND/CCCD");
        lbcmnd.setBounds(0, 205, 150, 100);
        lbcmnd.setHorizontalAlignment(SwingConstants.CENTER);
        lbcmnd.setVerticalAlignment(SwingConstants.CENTER);
        lbcmnd.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbcmnd.setBackground(new Color(220, 68, 68));
        panel2.add(lbcmnd);

        JLabel lbNgaylapptp = new JLabel("Ngày lập phiếu");
        lbNgaylapptp.setBounds(500, 0, 200, 100);
        lbNgaylapptp.setHorizontalAlignment(SwingConstants.CENTER);
        lbNgaylapptp.setVerticalAlignment(SwingConstants.CENTER);
        lbNgaylapptp.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbNgaylapptp.setBackground(new Color(220, 68, 68));
        panel2.add(lbNgaylapptp);

        JLabel lbNgaynhanphong = new JLabel("Ngày nhận phòng");
        lbNgaynhanphong.setBounds(500, 105, 200, 100);
        lbNgaynhanphong.setHorizontalAlignment(SwingConstants.CENTER);
        lbNgaynhanphong.setVerticalAlignment(SwingConstants.CENTER);
        lbNgaynhanphong.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbNgaynhanphong.setBackground(new Color(220, 68, 68));
        panel2.add(lbNgaynhanphong);

        JLabel lbNgaytraphong = new JLabel("Ngày trả phòng");
        lbNgaytraphong.setBounds(500, 205, 200, 100);
        lbNgaytraphong.setHorizontalAlignment(SwingConstants.CENTER);
        lbNgaytraphong.setVerticalAlignment(SwingConstants.CENTER);
        lbNgaytraphong.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbNgaytraphong.setBackground(new Color(220, 68, 68));
        panel2.add(lbNgaytraphong);


        list = new JComboBox<>();
        InsertMAPhong();
        list.setOpaque(false);
        list.setBounds(170, 40, 300, 30);
        panel2.add(list);

         JTextField txttenkh = new JTextField();
        txttenkh.setBounds(170,140,300,30);
        panel2.add(txttenkh);

        JTextField txtcmnd = new JTextField();
        txtcmnd.setBounds(170, 240, 300, 30);
        panel2.add(txtcmnd);

      //  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy ");
      // LocalDateTime now = LocalDateTime.now();

      // JTextField txtnlp = new JTextField(dtf.format(now));
        //txtnlp.setBounds(705, 35, 300, 30);
       // txtnlp.setEditable(false);
      //  panel2.add(txtnlp);
        UtilDateModel modelz = new UtilDateModel();
        Properties pz = new Properties();
        pz.put("text.today", "Today");
        pz.put("text.month", "Month");
        pz.put("text.year", "Year");
        modelz.setSelected(true);
        JDatePanelImpl datePanelz = new JDatePanelImpl(modelz, pz);

        JDatePickerImpl datePickerz = new JDatePickerImpl(datePanelz, new DateLabelFormatter());
        datePickerz.setBounds(705, 35, 300, 30);
        panel2.add(datePickerz);

//        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());

      //  JTextField txtnnp = new JTextField();
      //  txtnnp.setBounds(705, 140, 300, 30);
        //panel2.add(txtnnp);
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        model.setSelected(true);
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);


        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        datePicker.setBounds(705, 140, 300, 30);
        panel2.add(datePicker);


       // JTextField txtntp = new JTextField();
        //txtntp.setBounds(705, 240, 300, 30);
       // panel2.add(txtntp);

        UtilDateModel model2 = new UtilDateModel();
        Properties p2 = new Properties();
        p2.put("text.today", "Today");
        p2.put("text.month", "Month");
        p2.put("text.year", "Year");

        model2.setSelected(true);
        JDatePanelImpl datePanel2 = new JDatePanelImpl(model2, p2);

        JDatePickerImpl datePicker2 = new JDatePickerImpl(datePanel2, new DateLabelFormatter());
        datePicker2.setBounds(705, 240, 300, 30);
        panel2.add(datePicker2);

        JButton save = new JButton("save");
        save.setBounds(400, 530, 100, 60);
        save.setBackground(new Color(0, 219, 255));
        save.setForeground(new Color(0, 0, 0));
        panel2.add(save);

        JButton cancel = new JButton("cancel");
        cancel.setBounds(500, 530, 100, 60);
        cancel.setBackground(new Color(255, 0, 6));
        cancel.setForeground(new Color(0, 0, 0));
        panel2.add(cancel);

        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                QuanLyPhong q = new QuanLyPhong();
            }
        });

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String queryz = "SELECT COUNT(*) MAPTP FROM PHIEU_THUE_PHONG";
                    String query = "INSERT INTO PHIEU_THUE_PHONG (MAPTP,NGAYLAPPTP) VALUES( ? , ? )";

                    java.util.Date dateez = (java.util.Date) datePickerz.getModel().getValue();
                    java.sql.Date sqlDatez = new java.sql.Date(dateez.getTime());
                    java.util.Date datee = (java.util.Date) datePicker.getModel().getValue();
                    java.sql.Date sqlDate = new java.sql.Date(datee.getTime());

                    Connection con = ConnectionOracle.getConnection();
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery(queryz);
                    PreparedStatement pt = con.prepareStatement(query);
                    String getc = "99999999";
                    while (rs.next()) {
                         getc = rs.getString("MAPTP");
                    }
                    int count = Integer.parseInt(getc);
                    ++count;
                    String maphongs = Objects.requireNonNull(list.getSelectedItem()).toString();
                    int maphong =  Integer.parseInt(maphongs);
                    pt.setInt(1, count);
                    pt.setDate(2, sqlDatez);
                    pt.execute();
                    con.close();

                    con = ConnectionOracle.getConnection();
                    String query2 = "INSERT INTO CHITIET_PHIEUTHUEPHONG(MAPTP,MAPHONG,CMND,NGAYNHANPHONG,NGAYTRAPHONG) VALUES ( ? , ? , ? , ? , ? )";
                    java.util.Date datee2 = (java.util.Date) datePicker2.getModel().getValue();
                    java.sql.Date sqlDate2 = new java.sql.Date(datee2.getTime());
                    PreparedStatement pt2 = con.prepareStatement(query2);

                    pt2.setInt(1,count);
                    pt2.setInt(2,maphong);
                    pt2.setString(3,txtcmnd.getText());
                    pt2.setDate(4, sqlDate);
                    pt2.setDate(5, sqlDate2);

                    pt2.execute();
                    con.close();
                    JOptionPane.showMessageDialog(null, "Success Insert");
                    frame.dispose();
                    QuanLyPhong q = new QuanLyPhong();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

            }
        });
    }

    private void InsertMAPhong() {
        String query = "SELECT MAPHONG FROM PHONG";
        try {

            Connection con = ConnectionOracle.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                String name = rs.getString("MAPHONG");
                list.addItem(name);

            }
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public class DateLabelFormatter extends JFormattedTextField.AbstractFormatter {

        private String datePattern = "dd--MM--yyyy";
        private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

        @Override
        public Object stringToValue(String text) throws ParseException {
            return dateFormatter.parseObject(text);
        }

        @Override
        public String valueToString(Object value) throws ParseException {
            if (value != null) {
                Calendar cal = (Calendar) value;
                return dateFormatter.format(cal.getTime());
            }

            return "";
        }

    }
}
