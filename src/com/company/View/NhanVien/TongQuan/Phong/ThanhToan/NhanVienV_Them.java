package com.company.View.NhanVien.TongQuan.Phong.ThanhToan;



import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class NhanVienV_Them extends JFrame {

    private JPanel contentPane;
    private JTextField textHoTen;
    private JTextField textNgaySinh;
    private JTextField textDiaChi;
    private JTextField textEmail;
    private JTextField textSDT;
    private JTextField textCMND;
    private JTextField textNgayVaoLam;
    private JTextField textNguoiQuanLy;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    NhanVienV_Them frame = new NhanVienV_Them();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public NhanVienV_Them() {
        this.setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 864, 533);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(10, 10, 830, 68);
        panel.setBackground(new Color(178, 34, 34));
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblTenNhanVien = new JLabel("Th\u00F4ng tin nh\u00E2n vi\u00EAn");
        lblTenNhanVien.setForeground(new Color(255, 255, 255));
        lblTenNhanVien.setHorizontalAlignment(SwingConstants.CENTER);
        lblTenNhanVien.setFont(new Font("Times New Roman", Font.BOLD, 28));
        lblTenNhanVien.setBounds(156, 10, 470, 48);
        panel.add(lblTenNhanVien);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(211, 211, 211));
        panel_1.setBounds(10, 79, 830, 407);
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("M\u00E3 nh\u00E2n vi\u00EAn:");
        lblNewLabel_1.setBounds(10, 10, 98, 44);
        panel_1.add(lblNewLabel_1);
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));

        JLabel lblMaNhanVien = new JLabel("001");
        lblMaNhanVien.setBounds(102, 10, 49, 44);
        panel_1.add(lblMaNhanVien);
        lblMaNhanVien.setFont(new Font("Times New Roman", Font.BOLD, 15));

        JLabel lblNewLabel_1_1 = new JLabel("H\u1ECD t\u00EAn:");
        lblNewLabel_1_1.setBounds(91, 55, 67, 44);
        panel_1.add(lblNewLabel_1_1);
        lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));

        textHoTen = new JTextField();
        textHoTen.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        textHoTen.setBounds(181, 59, 217, 32);
        panel_1.add(textHoTen);
        textHoTen.setColumns(10);

        textNgaySinh = new JTextField();
        textNgaySinh.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        textNgaySinh.setBounds(546, 55, 217, 32);
        panel_1.add(textNgaySinh);
        textNgaySinh.setColumns(10);

        JLabel lblNewLabel_1_1_1 = new JLabel("Ng\u00E0y sinh");
        lblNewLabel_1_1_1.setBounds(456, 53, 98, 44);
        panel_1.add(lblNewLabel_1_1_1);
        lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));

        JLabel lblNewLabel_1_1_2 = new JLabel("Gi\u1EDBi t\u00EDnh");
        lblNewLabel_1_1_2.setBounds(91, 107, 98, 44);
        panel_1.add(lblNewLabel_1_1_2);
        lblNewLabel_1_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));

        JLabel lblNewLabel_1_1_3 = new JLabel("SDT");
        lblNewLabel_1_1_3.setBounds(456, 107, 98, 44);
        panel_1.add(lblNewLabel_1_1_3);
        lblNewLabel_1_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 15));

        JLabel lblNewLabel_1_1_4 = new JLabel("EMAIL");
        lblNewLabel_1_1_4.setBounds(91, 163, 98, 44);
        panel_1.add(lblNewLabel_1_1_4);
        lblNewLabel_1_1_4.setFont(new Font("Times New Roman", Font.PLAIN, 15));

        JLabel lblNewLabel_1_1_5 = new JLabel("CMND");
        lblNewLabel_1_1_5.setBounds(456, 161, 98, 44);
        panel_1.add(lblNewLabel_1_1_5);
        lblNewLabel_1_1_5.setFont(new Font("Times New Roman", Font.PLAIN, 15));

        JLabel lblNewLabel_1_1_7 = new JLabel("Ng\u00E0y v\u00E0o l\u00E0m");
        lblNewLabel_1_1_7.setBounds(456, 215, 98, 44);
        panel_1.add(lblNewLabel_1_1_7);
        lblNewLabel_1_1_7.setFont(new Font("Times New Roman", Font.PLAIN, 15));

        JLabel lblNewLabel_1_1_8 = new JLabel("Ng\u01B0\u1EDDi qu\u1EA3n l\u00FD");
        lblNewLabel_1_1_8.setBounds(91, 215, 98, 44);
        panel_1.add(lblNewLabel_1_1_8);
        lblNewLabel_1_1_8.setFont(new Font("Times New Roman", Font.PLAIN, 15));

        textDiaChi = new JTextField();
        textDiaChi.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        textDiaChi.setBounds(181, 269, 582, 32);
        panel_1.add(textDiaChi);
        textDiaChi.setColumns(10);

        JLabel lblNewLabel_1_1_10 = new JLabel("\u0110\u1ECBa ch\u1EC9");
        lblNewLabel_1_1_10.setBounds(91, 261, 98, 44);
        panel_1.add(lblNewLabel_1_1_10);
        lblNewLabel_1_1_10.setFont(new Font("Times New Roman", Font.PLAIN, 15));

        JSeparator separator = new JSeparator();
        separator.setBackground(new Color(192, 192, 192));
        separator.setBounds(20, 76, 410, -37);
        panel_1.add(separator);

        JRadioButton rdbtnNewRadioButton = new JRadioButton("Nam");
        rdbtnNewRadioButton.setBackground(new Color(192, 192, 192));
        rdbtnNewRadioButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        rdbtnNewRadioButton.setBounds(181, 119, 103, 21);
        panel_1.add(rdbtnNewRadioButton);

        JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("N\u1EEF");
        rdbtnNewRadioButton_1.setBackground(new Color(192, 192, 192));
        rdbtnNewRadioButton_1.setBounds(295, 120, 103, 21);
        panel_1.add(rdbtnNewRadioButton_1);

        textEmail = new JTextField();
        textEmail.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        textEmail.setColumns(10);
        textEmail.setBounds(181, 163, 217, 32);
        panel_1.add(textEmail);

        textSDT = new JTextField();
        textSDT.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        textSDT.setColumns(10);
        textSDT.setBounds(546, 107, 217, 32);
        panel_1.add(textSDT);

        textCMND = new JTextField();
        textCMND.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        textCMND.setColumns(10);
        textCMND.setBounds(546, 161, 217, 32);
        panel_1.add(textCMND);

        textNgayVaoLam = new JTextField();
        textNgayVaoLam.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        textNgayVaoLam.setColumns(10);
        textNgayVaoLam.setBounds(546, 215, 217, 32);
        panel_1.add(textNgayVaoLam);

        textNguoiQuanLy = new JTextField();
        textNguoiQuanLy.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        textNguoiQuanLy.setColumns(10);
        textNguoiQuanLy.setBounds(181, 217, 217, 32);
        panel_1.add(textNguoiQuanLy);

        JButton btnCapNhat = new JButton("C\u1EADp nh\u1EADt");
        btnCapNhat.setForeground(new Color(255, 255, 255));
        btnCapNhat.setBackground(new Color(0, 128, 128));
        btnCapNhat.setFont(new Font("Times New Roman", Font.BOLD, 15));
        btnCapNhat.setBounds(649, 341, 114, 44);
        panel_1.add(btnCapNhat);

        JButton btnQuayLai = new JButton("Quay l\u1EA1i");
        btnQuayLai.setForeground(Color.WHITE);
        btnQuayLai.setFont(new Font("Times New Roman", Font.BOLD, 15));
        btnQuayLai.setBackground(new Color(0, 128, 128));
        btnQuayLai.setBounds(483, 341, 114, 44);
        panel_1.add(btnQuayLai);
    }
}
