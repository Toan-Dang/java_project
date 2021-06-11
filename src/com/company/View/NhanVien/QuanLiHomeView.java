package com.company.View.NhanVien;



import com.company.View.NhanVien.DSPHONG.QuanLyPhong;
import com.company.View.NhanVien.QuanLyNhanVien.QuanLyNhanVien;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class QuanLiHomeView extends JFrame {

    protected JPanel contentPane;
    protected JButton btnTongQuan;
    protected JButton btnLichHen;
    protected JButton btnHoaDon;
    protected JButton btnKhachHang;
    protected JButton btnBaoCao;
    protected JButton btnCaiDat;
    protected JButton btnQuanLiDichVu;
    protected JButton btnQuanLiPhong;
    protected JButton btnQuanLiNhanVien;


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    QuanLiHomeView frame = new QuanLiHomeView();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public QuanLiHomeView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1010, 730);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(SystemColor.controlDkShadow);
        panel.setBounds(10, 78, 167, 605);
        contentPane.add(panel);
        panel.setLayout(null);

        btnTongQuan = new JButton("T\u1ED5ng Quan");
        btnTongQuan.setBackground(SystemColor.scrollbar);
        btnTongQuan.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnTongQuan.setBounds(0, 83, 167, 36);
        panel.add(btnTongQuan);

        btnLichHen = new JButton("L\u1ECBch h\u1EB9n");
        btnLichHen.setBackground(SystemColor.scrollbar);
        btnLichHen.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnLichHen.setBounds(0, 129, 167, 36);
        panel.add(btnLichHen);

        btnHoaDon = new JButton("Hoa \u0110\u01A1n");
        btnHoaDon.setBackground(SystemColor.scrollbar);
        btnHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnHoaDon.setBounds(0, 175, 167, 36);
        panel.add(btnHoaDon);

        btnKhachHang = new JButton("Kh\u00E1ch h\u00E0ng ");
        btnKhachHang.setBackground(SystemColor.scrollbar);
        btnKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnKhachHang.setBounds(0, 221, 167, 36);
        panel.add(btnKhachHang);

        btnBaoCao = new JButton("B\u00E1o C\u00E1o");
        btnBaoCao.setBackground(SystemColor.scrollbar);
        btnBaoCao.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnBaoCao.setBounds(0, 267, 167, 36);
        panel.add(btnBaoCao);

        btnCaiDat = new JButton("C\u00E0i \u0111\u1EB7t");
        btnCaiDat.setBackground(SystemColor.text);
        btnCaiDat.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnCaiDat.setBounds(0, 313, 167, 36);
        panel.add(btnCaiDat);

        JPanel panel_3 = new JPanel();
        panel_3.setBounds(0, 10, 51, 52);
        panel.add(panel_3);


        JLabel lblNewLabel_1 = new JLabel("UserName");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblNewLabel_1.setBounds(61, 10, 96, 27);
        panel.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Ho\u1EA1t \u0111\u1ED9ng");
        lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 10));
        lblNewLabel_2.setForeground(new Color(50, 205, 50));
        lblNewLabel_2.setBounds(61, 37, 59, 13);
        panel.add(lblNewLabel_2);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(SystemColor.activeCaption);
        panel_1.setBounds(10, 10, 167, 68);
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        JLabel lblNewLabel = new JLabel("4T Hotel");
        lblNewLabel.setForeground(SystemColor.info);
        lblNewLabel.setBackground(SystemColor.info);
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.BOLD, 30));
        lblNewLabel.setBounds(10, 10, 147, 48);
        panel_1.add(lblNewLabel);

        JPanel panel_2 = new JPanel();
        panel_2.setBackground(SystemColor.textHighlightText);
        panel_2.setBounds(174, 10, 822, 673);
        contentPane.add(panel_2);
        panel_2.setLayout(null);

        JPanel panel_4 = new JPanel();
        panel_4.setBackground(new Color(224, 255, 255));
        panel_4.setBounds(0, 0, 822, 57);
        panel_2.add(panel_4);
        panel_4.setLayout(null);

        btnQuanLiDichVu = new JButton("Qu\u1EA3n l\u00FD d\u1ECBch v\u1EE5");
        btnQuanLiDichVu.setFont(new Font("Times New Roman", Font.BOLD, 15));
        btnQuanLiDichVu.setBounds(204, 0, 147, 57);
        panel_4.add(btnQuanLiDichVu);
        btnQuanLiDichVu.setBorderPainted (false);
        btnQuanLiDichVu.setContentAreaFilled (false);

        btnQuanLiPhong = new JButton("Qu\u1EA3n l\u00FD ph\u00F2ng ");
        btnQuanLiPhong.setFont(new Font("Times New Roman", Font.BOLD, 15));
        btnQuanLiPhong.setBounds(350, 0, 147, 57);
        panel_4.add(btnQuanLiPhong);
        btnQuanLiPhong.setBorderPainted (false);
        btnQuanLiPhong.setContentAreaFilled (false);

        btnQuanLiNhanVien = new JButton("Qu\u1EA3n l\u00FD nh\u00E2n vi\u00EAn");
        btnQuanLiNhanVien.setFont(new Font("Times New Roman", Font.BOLD, 15));
        btnQuanLiNhanVien.setBounds(495, 0, 168, 57);
        panel_4.add(btnQuanLiNhanVien);
        btnQuanLiNhanVien.setBorderPainted (false);
        btnQuanLiNhanVien.setContentAreaFilled (false);

        JLabel lblCaiDat = new JLabel("C\u00E0i \u0111\u1EB7t");
        lblCaiDat.setHorizontalAlignment(SwingConstants.CENTER);
        lblCaiDat.setFont(new Font("Times New Roman", Font.BOLD, 15));
        lblCaiDat.setBounds(10, 5, 117, 47);
        panel_4.add(lblCaiDat);

        btnQuanLiPhong.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                QuanLyPhong p = new QuanLyPhong();

            }
        });
        btnQuanLiNhanVien.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                QuanLyNhanVien nv = new QuanLyNhanVien();
            }
        });
    }
}