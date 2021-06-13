package com.company.View.NhanVien.DSPHONG;

import com.company.Data.ConnectionOracle;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.sql.*;
import java.util.Objects;

public class ThemPhong extends JFrame {
    JFrame frame = new JFrame();
   private final JComboBox<String> list;

    public ThemPhong(){
        frame.setVisible(true);
       // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 500, 500);

        frame.setLocationRelativeTo(null);
        frame.setTitle("Phong");

       JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setBackground(new Color(253, 252, 252));
        frame.add(contentPane);

        JPanel panel1 = new JPanel();
        panel1.setBounds(0,0,1010,100);
        panel1.setBackground(new Color(125, 120, 92));
        panel1.setLayout(null);
        contentPane.add(panel1);

        JLabel name = new JLabel("Them Phong");
        name.setBounds(200,0,100,100);
        name.setHorizontalAlignment(SwingConstants.CENTER);
        name.setVerticalAlignment(SwingConstants.CENTER);
        name.setBackground(new Color(189, 44, 44));
        panel1.add(name);

        JPanel panel2 = new JPanel();
        panel2.setBounds(0,100,1010,400);
        panel2.setBackground(new Color(255, 255, 255));
        panel2.setLayout(null);
        contentPane.add(panel2);

        JLabel label1 = new JLabel("Loai phong");
        label1.setBounds(0,0,100,100);
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setVerticalAlignment(SwingConstants.CENTER);
        label1.setBackground(new Color(220, 68, 68));
        panel2.add(label1);
       //
       // String[] petStrings = { "Bird", "Cat", "Dog", "Rabbit", "Pig" };

        list = new JComboBox<>();

        InsertLoaiPhong();
        list.setOpaque(false);
        list.setBounds(100, 40 ,200,30);
        panel2.add(list);

        JLabel label4 = new JLabel("Ghi Chu");
        label4.setBounds(0,80,100,100);
        label4.setHorizontalAlignment(SwingConstants.CENTER);
        label4.setVerticalAlignment(SwingConstants.CENTER);
        label4.setBackground(new Color(189, 44, 44));
        panel2.add(label4);

        JTextField ghichu = new JTextField("Ghi Chu");
        ghichu.setBounds(100,110,200,30);
        panel2.add(ghichu);

        JButton save = new JButton("save");
        save.setBounds(180,300,70,30);
        save.setBackground(new Color(0, 219, 255));
        save.setForeground(new Color(0,0,0));
        panel2.add(save);

        JButton cancel = new JButton("cancel");
        cancel.setBounds(250,300,70,30);
        cancel.setBackground(new Color(255, 0, 6));
        cancel.setForeground(new Color(0,0,0));
        panel2.add(cancel);

        cancel.addActionListener(e -> {
            frame.dispose();
             new QuanLyPhong();
        });
        save.addActionListener(e -> {
           try{
                String query = "INSERT INTO PHONG(MALOAIPHONG,GHICHU) VALUES(?,?)";

               Connection con = ConnectionOracle.getConnection();
               PreparedStatement pt = con.prepareStatement(query);
                int MaLoaiPhong  = 1;
               String loaiphong = Objects.requireNonNull(list.getSelectedItem()).toString();
                if(loaiphong.equals("Loại2")) MaLoaiPhong = 2;
                if(loaiphong.equals("Loại1")) MaLoaiPhong = 3;
               pt.setInt(1,MaLoaiPhong);
               pt.setString(2,ghichu.getText());

               pt.execute();

               con.close();
               JOptionPane.showMessageDialog(null,"Success Insert");
               frame.dispose();
               new QuanLyPhong();
           } catch (SQLException throwables) {
               throwables.printStackTrace();
           }

        });
    }

    private void InsertLoaiPhong (){
        String query = "SELECT TENLOAIPHONG FROM LOAIPHONG";
        try{

            Connection con = ConnectionOracle.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while(rs.next()){
                String name = rs.getString("TENLOAIPHONG");

                list.addItem(name);

            }
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
