package com.company.View.NhanVien.QuanLyDichVu;

import com.company.Data.InsertDichVu;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultCaret;
import java.awt.*;

public class ThemDichVu extends JFrame {
    JFrame frame = new JFrame();

    public ThemDichVu() {
        frame.setVisible(true);
        frame.setBounds(100, 100, 500, 550);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Them Dich Vu");

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

        JLabel name = new JLabel("Them Dich vu");
        name.setBounds(200, 0, 100, 100);
        name.setHorizontalAlignment(SwingConstants.CENTER);
        name.setVerticalAlignment(SwingConstants.CENTER);
        name.setBackground(new Color(189, 44, 44));
        panel1.add(name);

        JPanel panel2 = new JPanel();
        panel2.setBounds(0, 100, 1010, 630);
        panel2.setBackground(new Color(255, 255, 255));
        panel2.setLayout(null);
        contentPane.add(panel2);

        JLabel tendv = new JLabel("Tên dịch vụ");
        tendv.setBounds(0, 0, 100, 100);
        tendv.setHorizontalAlignment(SwingConstants.CENTER);
        tendv.setVerticalAlignment(SwingConstants.CENTER);
        tendv.setFont(new Font("Serif", Font.ITALIC, 16));
        tendv.setBackground(new Color(220, 68, 68));
        panel2.add(tendv);

        JLabel giadv = new JLabel("Gia");
        giadv.setBounds(0, 100, 100, 100);
        giadv.setHorizontalAlignment(SwingConstants.CENTER);
        giadv.setFont(new Font("Serif", Font.ITALIC, 16));
        giadv.setVerticalAlignment(SwingConstants.CENTER);
        giadv.setBackground(new Color(189, 44, 44));
        panel2.add(giadv);


        JLabel chitietdv = new JLabel("Chi tiết");
        chitietdv.setBounds(0, 200, 100, 100);
        chitietdv.setHorizontalAlignment(SwingConstants.CENTER);
        chitietdv.setFont(new Font("Serif", Font.ITALIC, 16));
        chitietdv.setVerticalAlignment(SwingConstants.CENTER);
        chitietdv.setBackground(new Color(189, 44, 44));
        panel2.add(chitietdv);


        JTextField txttendv = new JTextField();
        txttendv.setBounds(100, 30, 200, 30);
        panel2.add(txttendv);

        JTextField txtgia = new JTextField();
        txtgia.setBounds(100, 130, 200, 30);
        panel2.add(txtgia);

        JTextArea ghichu = new JTextArea();
        ghichu.setFont(new Font("Serif", Font.ITALIC, 16));
        ghichu.setBackground(new Color(227, 227, 227));
        ghichu.setLineWrap(true);
        ghichu.setWrapStyleWord(true);

        DefaultCaret caret = (DefaultCaret) ghichu.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.add(ghichu);
        scrollPane.setViewportView(ghichu);
        scrollPane.setBounds(100, 210, 300, 100);
        panel2.add(scrollPane);

        JButton save = new JButton("save");
        save.setBounds(180, 350, 70, 30);
        save.setBackground(new Color(0, 219, 255));
        save.setForeground(new Color(0, 0, 0));
        panel2.add(save);

        JButton cancel = new JButton("cancel");
        cancel.setBounds(250, 350, 70, 30);
        cancel.setBackground(new Color(255, 0, 6));
        cancel.setForeground(new Color(0, 0, 0));
        panel2.add(cancel);

        cancel.addActionListener(e -> {
            frame.dispose();
            new Quanlydichvu();
        });
        save.addActionListener(e -> {
           new InsertDichVu(txttendv.getText(),ghichu.getText(),txtgia.getText());
            new Quanlydichvu();
            frame.dispose();

        });
    }
}
