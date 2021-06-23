package com.company.View.NhanVien.TongQuan.Phong.ThanhToan;

import com.company.Controller.PhongController;
import com.company.Controller.ThanhToanController;
import com.company.Model.Phong;
import com.company.Model.ThanhToan;
import com.company.View.NhanVien.TongQuan.Phong.CaiDat;
import com.company.View.NhanVien.TongQuan.Phong.CaiDat_QuanLyPhong_SuaPhong;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;

public class ThanhToanV extends JFrame  {

    JTable table;
    TableRowSorter<TableModel> rowSorter;
    private final JPanel contentPane;
    private JButton btnTongQuan;
    private JButton btnDichVu;
    private JTable table_1;
    private JTextField textTimKiem;


    public ThanhToanV() {
        this.dispose();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100, 100, 1240, 730);
        this.setLocationRelativeTo(null);
        this.setTitle("DS Phòng");

        contentPane = new JPanel();
        contentPane.setForeground(new Color(255, 255, 255));
        contentPane.setBackground(new Color(248, 248, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

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

        JButton btnBaoCao = new JButton("Báo cáo");
        btnBaoCao.setFont(new Font("Times New Roman", Font.BOLD, 17));
        btnBaoCao.setBackground(Color.LIGHT_GRAY);
        btnBaoCao.setBounds(0, 184, 170, 44);
        panel_1.add(btnBaoCao);

        JButton btnKhachHang = new JButton("Khách hàng");
        btnKhachHang.setFont(new Font("Times New Roman", Font.BOLD, 17));
        btnKhachHang.setBackground(Color.LIGHT_GRAY);
        btnKhachHang.setBounds(0, 141, 170, 44);
        panel_1.add(btnKhachHang);

        JButton btnThanhToan = new JButton("Thanh toán");
        btnThanhToan.setFont(new Font("Times New Roman", Font.BOLD, 17));
        btnThanhToan.setBackground(Color.WHITE);
        btnThanhToan.setBounds(0, 97, 170, 44);
        panel_1.add(btnThanhToan);

        btnDichVu = new JButton("Dịch vụ");
        btnDichVu.setFont(new Font("Times New Roman", Font.BOLD, 17));
        btnDichVu.setBackground(Color.LIGHT_GRAY);
        btnDichVu.setBounds(0, 54, 170, 44);
        panel_1.add(btnDichVu);


        btnTongQuan = new JButton("Tổng quan");
        btnTongQuan.setFont(new Font("Times New Roman", Font.BOLD, 17));
        btnTongQuan.setBackground(new Color(192, 192, 192));
        btnTongQuan.setBounds(0, 10, 170, 44);
        panel_1.add(btnTongQuan);


        JButton btnCaiDat = new JButton("Cài đặt");
        btnCaiDat.setFont(new Font("Times New Roman", Font.BOLD, 17));
        btnCaiDat.setBackground(Color.LIGHT_GRAY);
        btnCaiDat.setBounds(0, 228, 170, 44);
        panel_1.add(btnCaiDat);

        JPanel panel_2 = new JPanel();
        panel_2.setBounds(190, 67, 1009, 36);
        panel_2.setBackground(new Color(178, 34, 34));
        contentPane.add(panel_2);
        panel_2.setLayout(null);

        JLabel lblNewLabel_2 = new JLabel("Thanh To\u00E1n");
        lblNewLabel_2.setForeground(new Color(255, 255, 255));
        lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblNewLabel_2.setBounds(39, 0, 134, 36);
        panel_2.add(lblNewLabel_2);

        JPanel panel_4 = new JPanel();
        panel_4.setBackground(new Color(178, 34, 34));
        panel_4.setBounds(480, 625, 736, 3);
        contentPane.add(panel_4);

        JLabel lblNewLabel_4 = new JLabel("Khách hàng là thượng đế!");
        lblNewLabel_4.setFont(new Font("Times New Roman", Font.ITALIC, 17));
        lblNewLabel_4.setBounds(1011, 628, 243, 25);
        contentPane.add(lblNewLabel_4);

        JLabel lblTimKiem = new JLabel("Tìm kiếm:");
        lblTimKiem.setForeground(new Color(0, 0, 0));
        lblTimKiem.setBackground(new Color(0, 0, 0));
        lblTimKiem.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblTimKiem.setBounds(190, 131, 62, 19);
        contentPane.add(lblTimKiem);

        JTextField searchfield = new JTextField();
        searchfield.setBounds(289, 128, 291, 27);
        contentPane.add(searchfield);
        searchfield.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = searchfield.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = searchfield.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });

        JButton btnTT = new JButton("Thanh toán");
        btnTT.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        btnTT.setBounds(625, 123, 101, 36);
        contentPane.add(btnTT);

        new Table();

    }

    public static void main(String[] args) {
        new ThanhToanV();
    }


    public class Table {
        public Table() {
            EventQueue.invokeLater(() -> {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                ArrayList<ThanhToan> list = ThanhToanController.listphieu();
                TableModel model = new TableModel();

                int maphieu;
                String[] rowstr = new String[6];
                for (ThanhToan tt : list) {
                    maphieu = tt.getMaPhieu();
                    rowstr[0] = tt.getTenKH();
                    rowstr[1] = tt.getCMND();
                    rowstr[2] = tt.getSDT();
                    rowstr[3] = tt.getEmail();
                    rowstr[4] = tt.getLoaiPhieu();
                    rowstr[5] = tt.getTinhTrang();
                    model.add(new ThanhToan(maphieu,rowstr[0],rowstr[1],rowstr[2],rowstr[3],rowstr[4],rowstr[5]));
                }
                table = new JTable(model);
                table.setFillsViewportHeight(true);

                table.setShowGrid(false);
                table.setPreferredScrollableViewportSize(new Dimension(500, 70));
                rowSorter = new TableRowSorter<>(table.getModel());
                table.setRowSorter(rowSorter);
                table.setOpaque(true);

                table.setBackground(new Color(255, 255, 255));
                table.setFont(new Font("Times New Roman", Font.PLAIN, 14));
                table.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 15));
                table.getTableHeader().setOpaque(false);
                table.getTableHeader().setBackground(new Color(178, 34, 34));
                table.getTableHeader().setForeground(new Color(255, 255, 255));
                table.setSurrendersFocusOnKeystroke(true);

                JScrollPane scrollpane = new JScrollPane(table);
                scrollpane.setViewportView(table);
                scrollpane.setBounds(190, 174, 889, 392);

                contentPane.add(scrollpane);
            });
        }

        public class TableModel extends AbstractTableModel {

            private final List<ThanhToan> data;

            public TableModel() {
                data = new ArrayList<>();
            }
          //  maptp, tenkh,cmnd,sdt,email,loai phieu,tinhtrrang
            @Override
            public String getColumnName(int column) {
                return switch (column) {
                    case 0 -> "Mã Phiếu";
                    case 1 -> "Tên khách hàng";
                    case 2 -> "CMND";
                    case 3 -> "SDT";
                    case 4 -> "Email";
                    case 5 -> "Loại Phiếu";
                    case 6 -> "Tình trạng phiếu";
                    case 7 -> "";
                    default -> null;
                };
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return switch (columnIndex) {
                    case 0 -> Integer.class;
                    case 1, 2,3,4,5,6 -> String.class;
                    default -> Object.class;
                };
            }

            @Override
            public int getRowCount() {
                return data.size();
            }

            @Override
            public int getColumnCount() {
                return 7;
           }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                ThanhToan obj = data.get(rowIndex);
                return switch (columnIndex) {
                    case 0 -> obj.getMaPhieu();
                    case 1 -> obj.getTenKH();
                    case 2 -> obj.getCMND();
                    case 3 -> obj.getSDT();
                    case 4 -> obj.getEmail();
                    case 5 -> obj.getLoaiPhieu();
                    case 6 -> obj.getTinhTrang();
                    default -> null;
                };
            }


            public void add(ThanhToan value) {
                int startIndex = getRowCount();
                data.add(value);
                fireTableRowsInserted(startIndex, getRowCount() - 1);
            }

        }

    }
}


