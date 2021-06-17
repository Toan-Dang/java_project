package com.company.View.NhanVien;

import com.company.Data.*;
import com.company.Model.DanhSachDatTruoc;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ThongtinPhong extends JFrame {
    JFrame frame = new JFrame();
    TableRowSorter<javax.swing.table.TableModel> rowSorter;
    JPanel contentPane;
    private JTable tableModel;

    public ThongtinPhong(int id) {
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 814, 523);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Thông tin phòng số " + id);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setBackground(SystemColor.controlDkShadow);
        frame.add(contentPane);


        JLabel lblMaPhong = new JLabel(String.valueOf(id));
        lblMaPhong.setForeground(Color.RED);
        lblMaPhong.setFont(new Font("Times New Roman", Font.BOLD, 30));
        lblMaPhong.setBounds(308, 29, 223, 51);
        contentPane.add(lblMaPhong);



        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setBounds(38, 78, 556, 167);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblTinhTrang = new JLabel("Tình Trạng");
        lblTinhTrang.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblTinhTrang.setBounds(10, 10, 100, 32);
        panel.add(lblTinhTrang);

        JLabel lblTinhTrangTD = new JLabel();
        lblTinhTrangTD.setFont(new Font("Tahoma", Font.ITALIC, 15));
        lblTinhTrangTD.setBounds(109, 16, 140, 20);
        panel.add(lblTinhTrangTD);

        JLabel lblHoTen = new JLabel("H\u1ECD t\u00EAn:");
        lblHoTen.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblHoTen.setBounds(10, 49, 73, 32);
        panel.add(lblHoTen);

        JLabel lblHoTenTD = new JLabel();
        lblHoTenTD.setFont(new Font("Tahoma", Font.ITALIC, 15));
        lblHoTenTD.setBounds(78, 49, 200, 32);
        panel.add(lblHoTenTD);

        JLabel lblNgayNhanPhong = new JLabel("Ng\u00E0y nh\u1EADn ph\u00F2ng:");
        lblNgayNhanPhong.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNgayNhanPhong.setBounds(10, 84, 140, 37);
        panel.add(lblNgayNhanPhong);

        JLabel lblNgayNhanPhongTD = new JLabel();
        lblNgayNhanPhongTD.setFont(new Font("Tahoma", Font.ITALIC, 15));
        lblNgayNhanPhongTD.setEnabled(true);
        lblNgayNhanPhongTD.setBounds(168, 86, 151, 32);
        panel.add(lblNgayNhanPhongTD);

        JLabel lblNgayTraPhong = new JLabel("Ng\u00E0y tr\u1EA3 ph\u00F2ng:");
        lblNgayTraPhong.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNgayTraPhong.setBounds(10, 120, 140, 37);
        panel.add(lblNgayTraPhong);

        JLabel lblNgayTraPhongTD = new JLabel();
        lblNgayTraPhongTD.setFont(new Font("Tahoma", Font.ITALIC, 15));
        lblNgayTraPhongTD.setEnabled(true);
        lblNgayTraPhongTD.setBounds(168, 122, 151, 32);
        panel.add(lblNgayTraPhongTD);
        try {
            Connection con = ConnectionOracle.getConnection();
            String querry = "select D.TINHTRANG, C.TENKH, B.NGAYNHANPHONG, B.NGAYTRAPHONG  from PHIEU_THUE_PHONG a , CHITIET_PHIEUTHUEPHONG b, KHACHHANG c, Phong d\n" +
                    "where b.maphong = " + id +
                    " and b.maptp = a.maptp\n" +
                    "and a.makh = c.makh\n" +
                    "and b.maphong = d.maphong";

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(querry);

            while (rs.next()) {
                String tinh_trang = rs.getString(1);
                if (tinh_trang != null) {
                    if (tinh_trang.equals("0")) tinh_trang = "trống";
                    if (tinh_trang.equals("1")) tinh_trang = "đã có người";
                    if (tinh_trang.equals("2")) tinh_trang = "đã được đặt";
                } else tinh_trang = "trống";

                lblTinhTrangTD.setText(tinh_trang);
                lblHoTenTD.setText(rs.getString(2));
                lblNgayNhanPhongTD.setText(rs.getString(3));
                lblNgayTraPhongTD.setText(rs.getString(4));
            }
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        new TBDsDatTruoc(id);
        JLabel lblDanhSachDatTruoc = new JLabel("Danh s\u00E1ch \u0111\u1EB7t tr\u01B0\u1EDBc");
        lblDanhSachDatTruoc.setFont(new Font("Times New Roman", Font.BOLD, 15));
        lblDanhSachDatTruoc.setBounds(38, 255, 223, 28);
        contentPane.add(lblDanhSachDatTruoc);

        JButton btnDatPhong = new JButton("\u0110\u1EB7t ph\u00F2ng");
        btnDatPhong.setBackground(new Color(60, 179, 113));
        btnDatPhong.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnDatPhong.setBounds(640, 78, 129, 51);
        contentPane.add(btnDatPhong);

        JButton btnQuayLai = new JButton("Quay l\u1EA1i");
        btnQuayLai.setBackground(new Color(255, 69, 0));
        btnQuayLai.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnQuayLai.setBounds(640, 162, 129, 51);
        contentPane.add(btnQuayLai);

        btnQuayLai.addActionListener(e -> frame.dispose());
    }

    public class TBDsDatTruoc {

        public TBDsDatTruoc(int id) {
            EventQueue.invokeLater(() -> {

                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }
               ArrayList<DanhSachDatTruoc> list = getDSDatTruoc.listdattruoc(id);
              MyTableModel model = new MyTableModel();
                    int rowint ;
                    Date[] rowdate = new Date[3];
                for (DanhSachDatTruoc ds : list) {
                    rowint = ds.getMaKH();
                    rowdate[0] = ds.getNgayDangKy();
                    rowdate[1] = ds.getNgayNhanPhong();
                    rowdate[2] = ds.getNgayTraPhong();

                    model.add(new DanhSachDatTruoc(rowint,rowdate[0],rowdate[1],rowdate[2]));
                }
                tableModel = new JTable(model);
                tableModel.setFillsViewportHeight(true);
                tableModel.setOpaque(true);
                tableModel.setPreferredScrollableViewportSize(new Dimension(500, 70));
                rowSorter = new TableRowSorter<>(tableModel.getModel());
                tableModel.setRowSorter(rowSorter);
                JScrollPane scrollpane = new JScrollPane(tableModel);
                scrollpane.setViewportView(tableModel);
                scrollpane.setBounds(38, 283, 556, 180);
                contentPane.add(scrollpane);
            });
        }

        public class MyTableModel extends AbstractTableModel {

            private final List<DanhSachDatTruoc> data;

            public MyTableModel() {
                data = new ArrayList<>();
            }

            @Override
            public String getColumnName(int column) {
                return switch (column) {
                    case 0 -> "MaKH";
                    case 1 -> "Ngày đặt trước";
                    case 2 -> "Ngày nhận phòng";
                    case 3 -> "Ngày trả phòng";
                    case 4 -> "";
                    default -> null;
                };
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return switch (columnIndex) {
                    case 0 -> Integer.class;
                    case 1, 2, 3 -> Date.class;
                    default -> Object.class;
                };
            }

            @Override
            public int getRowCount() {
                return data.size();
            }

            @Override
            public int getColumnCount() {
                return 5;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                DanhSachDatTruoc obj = data.get(rowIndex);
                Object value = null;
                switch (columnIndex) {
                    case 0:
                        value = obj.getMaKH();
                        break;
                    case 1:
                        value = obj.getNgayDangKy();
                        break;
                    case 2:
                        value = obj.getNgayNhanPhong();
                        break;
                    case 3:
                        value = obj.getNgayTraPhong();
                        break;
                    case 4:
                        break;
                }
                return value;
            }

            @Override
            public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
                if (columnIndex == 4) {

                    System.out.println(aValue);

                    DanhSachDatTruoc value = data.get(rowIndex);
                    if ("accept".equals(aValue)) {
                        System.out.println("Accepted");
                    } else {
                        System.out.println("Rejected");
                    }
                    fireTableCellUpdated(rowIndex, columnIndex);
                    remove(value);

                }
            }

            public void add(DanhSachDatTruoc value) {
                int startIndex = getRowCount();
                data.add(value);
                fireTableRowsInserted(startIndex, getRowCount() - 1);
            }

            public void remove(DanhSachDatTruoc value) {
                int startIndex = data.indexOf(value);
                System.out.println("startIndex = " + startIndex);
                data.remove(value);
                fireTableRowsInserted(startIndex, startIndex);
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return columnIndex == 4;
            }
        }


    }
}
