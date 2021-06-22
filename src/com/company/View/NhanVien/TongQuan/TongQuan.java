package com.company.View.NhanVien.TongQuan;

import com.company.Controller.PhongController;
import com.company.Model.Phong;
import com.company.View.NhanVien.TongQuan.Phong.ThongtinPhong;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

public class TongQuan extends JFrame {

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
              new TongQuan();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
    JFrame frame = new JFrame();
    JPanel soDoPhong;
    /**
     * Create the frame.
     */
    public TongQuan() {
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 1240, 730);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Tong Quan");

        JPanel contentPane = new JPanel();
        contentPane.setBackground(new Color(248, 248, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        frame.add(contentPane);

        JPanel panel = new JPanel();
        panel.setBounds(10, 10, 1206, 47);
        panel.setBackground(new Color(178, 34, 34));
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("4T HOTEL");
        lblNewLabel.setFont(new Font("Wide Latin", Font.BOLD, 17));
        lblNewLabel.setBounds(10, 0, 194, 47);
        panel.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("T\u00EAn nh\u00E2n vi\u00EAn");
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblNewLabel_1.setBounds(974, 10, 194, 27);
        panel.add(lblNewLabel_1);

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(10, 58, 170, 595);
        panel_1.setBackground(new Color(255, 255, 255));
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        JButton btnTongQuan = new JButton("T\u1ED5ng quan");
        btnTongQuan.setBackground(new Color(192, 192, 192));
        btnTongQuan.setFont(new Font("Times New Roman", Font.BOLD, 17));
        btnTongQuan.setBounds(0, 10, 170, 44);
        panel_1.add(btnTongQuan);
        btnTongQuan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TongQuan();
            }
        });
        JButton btnPhieuThuePhong = new JButton("Phi\u1EBFu thu\u00EA ph\u00F2ng");
        btnPhieuThuePhong.setBackground(new Color(192, 192, 192));
        btnPhieuThuePhong.setFont(new Font("Times New Roman", Font.BOLD, 17));
        btnPhieuThuePhong.setBounds(0, 54, 170, 44);
        panel_1.add(btnPhieuThuePhong);

        JPanel panel_2 = new JPanel();
        panel_2.setBackground(new Color(178, 34, 34));
        panel_2.setBounds(179, 67, 1020, 36);
        contentPane.add(panel_2);
        panel_2.setLayout(null);

        JLabel lblNewLabel_2 = new JLabel("T\u1ED5ng quan");
        lblNewLabel_2.setForeground(new Color(255, 255, 255));
        lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblNewLabel_2.setBounds(39, 0, 134, 36);
        panel_2.add(lblNewLabel_2);

        JLabel lblChuThich = new JLabel("Ch\u00FA th\u00EDch: ");
        lblChuThich.setFont(new Font("Times New Roman", Font.BOLD, 15));
        lblChuThich.setBounds(189, 113, 83, 30);
        contentPane.add(lblChuThich);

        JPanel panel_3 = new JPanel();
        panel_3.setBackground(new Color(60, 179, 113));
        panel_3.setBounds(266, 113, 38, 30);
        panel_3.setLayout(null);
        contentPane.add(panel_3);

        JLabel lblNewLabel_4 = new JLabel("Tr\u1ED1ng");
        lblNewLabel_4.setFont(new Font("Times New Roman", Font.ITALIC, 14));
        lblNewLabel_4.setBounds(314, 118, 83, 20);
        contentPane.add(lblNewLabel_4);

        JPanel panel_3_1 = new JPanel();
        panel_3_1.setBackground(new Color(255, 0, 0));
        panel_3_1.setBounds(371, 113, 38, 30);
        contentPane.add(panel_3_1);

        JLabel lblNewLabel_4_1 = new JLabel("\u0110ang \u1EDF");
        lblNewLabel_4_1.setFont(new Font("Times New Roman", Font.ITALIC, 14));
        lblNewLabel_4_1.setBounds(419, 118, 83, 20);
        contentPane.add(lblNewLabel_4_1);

        JPanel panel_3_2 = new JPanel();
        panel_3_2.setBackground(new Color(148, 0, 211));
        panel_3_2.setBounds(479, 113, 38, 30);
        contentPane.add(panel_3_2);

        JLabel lblNewLabel_4_2 = new JLabel("\u0110\u00E3 \u0111\u1EB7t tr\u01B0\u1EDBc");
        lblNewLabel_4_2.setFont(new Font("Times New Roman", Font.ITALIC, 14));
        lblNewLabel_4_2.setBounds(527, 118, 83, 20);
        contentPane.add(lblNewLabel_4_2);

        JPanel panel_3_2_1 = new JPanel();
        panel_3_2_1.setBackground(new Color(192, 192, 192));
        panel_3_2_1.setBounds(614, 113, 38, 30);
        contentPane.add(panel_3_2_1);

        JLabel lblNewLabel_5 = new JLabel("1");
        lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        panel_3_2_1.add(lblNewLabel_5);

        JLabel lblNewLabel_4_2_1 = new JLabel("Ph\u00F2ng \u0111\u01A1n");
        lblNewLabel_4_2_1.setFont(new Font("Times New Roman", Font.ITALIC, 14));
        lblNewLabel_4_2_1.setBounds(662, 118, 83, 20);
        contentPane.add(lblNewLabel_4_2_1);

        JPanel panel_3_2_2 = new JPanel();
        panel_3_2_2.setBackground(new Color(192, 192, 192));
        panel_3_2_2.setBounds(736, 113, 38, 30);
        contentPane.add(panel_3_2_2);

        JLabel lblNewLabel_6 = new JLabel("2");
        lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        panel_3_2_2.add(lblNewLabel_6);

        JLabel lblNewLabel_4_2_2 = new JLabel("Ph\u00F2ng \u0111\u00F4i");
        lblNewLabel_4_2_2.setFont(new Font("Times New Roman", Font.ITALIC, 14));
        lblNewLabel_4_2_2.setBounds(784, 118, 83, 20);
        contentPane.add(lblNewLabel_4_2_2);

        JPanel panel_3_2_3 = new JPanel();
        panel_3_2_3.setBackground(new Color(192, 192, 192));
        panel_3_2_3.setBounds(855, 113, 38, 30);
        contentPane.add(panel_3_2_3);

        JLabel lblNewLabel_7 = new JLabel("n");
        lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        panel_3_2_3.add(lblNewLabel_7);

        JLabel lblNewLabel_4_2_3 = new JLabel("Ph\u00F2ng \u0111o\u00E0n");
        lblNewLabel_4_2_3.setFont(new Font("Times New Roman", Font.ITALIC, 14));
        lblNewLabel_4_2_3.setBounds(903, 118, 83, 20);
        contentPane.add(lblNewLabel_4_2_3);

        JButton btnThemPTP = new JButton("Th\u00EAm PTP +");
        btnThemPTP.setBackground(new Color(0, 206, 209));
        btnThemPTP.setFont(new Font("Times New Roman", Font.BOLD, 16));
        btnThemPTP.setBounds(1050, 185, 166, 47);
        contentPane.add(btnThemPTP);

        JButton btnDSCheckin = new JButton("DS checkin");
        btnDSCheckin.setBackground(new Color(0, 206, 209));
        btnDSCheckin.setFont(new Font("Times New Roman", Font.BOLD, 15));
        btnDSCheckin.setBounds(1050, 255, 166, 47);
        contentPane.add(btnDSCheckin);

        soDoPhong = new JPanel();
        soDoPhong.setBounds(190, 153, 832, 500);
        contentPane.add(soDoPhong);

        new test();
    }
    public class test {

        private final JPanel controls = new JPanel() {
            @Override
            public Dimension getMinimumSize() {
                return new Dimension(832, 500);
            }

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(832, 500);
            }

            @Override
            public Dimension getMaximumSize() {
                return new Dimension(832, 500);
            }
        };

        test() {
            initUI();
        }

        public final void initUI() {

            soDoPhong.add(controls);
            controls.setBackground(new Color(185, 243, 243));
            controls.setBorder(new TitledBorder("Danh sách phòng"));

            soDoPhong.add(getCheckBoxPanel());

        }

        private void addLabel(String maphong,String tinhtrang,String loaiphong) {
            Color color = Color.green;
            if(tinhtrang.equals("đã có người")) color = Color.red;
            if(tinhtrang.equals("đã được đặt")) color = Color.yellow;
            JPanel controls1 = new JPanel();
            controls1.setBackground(color);
            controls1.setBorder(new EmptyBorder(0, 0, 0, 0));
            controls1.setLayout(new BorderLayout());

            JLabel txtmaphong = new JLabel();
            txtmaphong.setText(maphong);
            txtmaphong.setHorizontalAlignment(SwingConstants.CENTER);
            txtmaphong.setFont(new Font("Times New Roman", Font.BOLD, 20));
            controls1.add(txtmaphong,BorderLayout.CENTER);

            JLabel txtloaiphong = new JLabel();
            txtloaiphong.setText(loaiphong);
            txtloaiphong.setForeground(Color.blue);
            txtloaiphong.setBackground(Color.gray);
            txtloaiphong.setHorizontalAlignment(SwingConstants.RIGHT);
            txtloaiphong.setFont(new Font("Times New Roman", Font.ITALIC, 15));
            controls1.add(txtloaiphong,BorderLayout.NORTH);

            controls1.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    JPanel p = (JPanel) e.getSource();
                    JLabel label = (JLabel)p.getComponent(0);
                    System.out.println(label.getText());
                    new ThongtinPhong(Integer.parseInt(label.getText()));
                }
            });


            controls.add(controls1);
        }

        private JPanel getCheckBoxPanel() {

            ArrayList<Phong> listphong = PhongController.listphong() ;

            for (Phong p : listphong) {
                if (controls.getComponentCount() < 1) {
                    controls.setLayout(new BorderLayout());
                    addLabel(String.valueOf(p.getMaPhong()),p.getTinhTrang(),p.getMaLoaiPhong());
                    makeChange();
                } else if (controls.getComponentCount() == 1  ) {
                    controls.setLayout(new GridLayout(0, 2, 10, 10));
                    addLabel(String.valueOf(p.getMaPhong()),p.getTinhTrang(),p.getMaLoaiPhong());
                    makeChange();
                } else {
                    controls.setLayout(new GridLayout(3, 0, 10, 10));
                    addLabel(String.valueOf(p.getMaPhong()),p.getTinhTrang(),p.getMaLoaiPhong());
                    makeChange();
                }

            }
            return new JPanel();
        }

        private void makeChange() {
            soDoPhong.revalidate();
            soDoPhong.repaint();
        }


    }
}
