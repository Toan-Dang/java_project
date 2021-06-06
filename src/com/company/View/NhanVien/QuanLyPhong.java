package com.company.View.NhanVien;


import com.company.Data.ConnectionOracle;
import com.company.Model.PhieuThuePhong;
import com.company.Model.Phong;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.EventObject;
import java.util.List;

public class QuanLyPhong extends QuanLiHomeView {
    JFrame frame = new JFrame();
    JPanel panel_2;
    JTabbedPane tabbebpane;

    public QuanLyPhong() {
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 1010, 730);

        frame.setLocationRelativeTo(null);
        frame.setTitle("Phong");


        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setBackground(SystemColor.blue);
        frame.add(contentPane);

        JPanel panel = new JPanel();
        panel.setBackground(SystemColor.controlDkShadow);
        panel.setBackground(SystemColor.black);
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
        btnCaiDat.setBackground(SystemColor.red);
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
        panel_1.setBackground(SystemColor.red);
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

        panel_2 = new JPanel();
        panel_2.setBackground(SystemColor.textHighlightText);
        panel_2.setBounds(174, 10, 822, 673);
        contentPane.add(panel_2);
        panel_2.setLayout(null);

        JPanel panel_4 = new JPanel();
        // panel_4.setBackground(new Color(224, 255, 255));
        panel_4.setBackground(new Color(252, 255, 224));
        panel_4.setBounds(0, 0, 822, 57);
        panel_2.add(panel_4);
        panel_4.setLayout(null);

        btnQuanLiDichVu = new JButton("Qu\u1EA3n l\u00FD d\u1ECBch v\u1EE5");
        btnQuanLiDichVu.setFont(new Font("Times New Roman", Font.BOLD, 15));
        btnQuanLiDichVu.setBounds(204, 0, 147, 57);
        panel_4.add(btnQuanLiDichVu);
        btnQuanLiDichVu.setBorderPainted(false);
        btnQuanLiDichVu.setContentAreaFilled(false);

        btnQuanLiPhong = new JButton("Qu\u1EA3n l\u00FD ph\u00F2ng ");
        btnQuanLiPhong.setFont(new Font("Times New Roman", Font.BOLD, 15));
        btnQuanLiPhong.setBounds(350, 0, 147, 57);
        panel_4.add(btnQuanLiPhong);
        btnQuanLiPhong.setBorderPainted(false);
        btnQuanLiPhong.setContentAreaFilled(false);

        btnQuanLiNhanVien = new JButton("Qu\u1EA3n l\u00FD nh\u00E2n vi\u00EAn");
        btnQuanLiNhanVien.setFont(new Font("Times New Roman", Font.BOLD, 15));
        btnQuanLiNhanVien.setBounds(495, 0, 168, 57);
        panel_4.add(btnQuanLiNhanVien);
        btnQuanLiNhanVien.setBorderPainted(false);
        btnQuanLiNhanVien.setContentAreaFilled(false);

        JLabel lblCaiDat = new JLabel("C\u00E0i \u0111\u1EB7t");
        lblCaiDat.setHorizontalAlignment(SwingConstants.CENTER);
        lblCaiDat.setFont(new Font("Times New Roman", Font.BOLD, 15));
        lblCaiDat.setBounds(10, 5, 117, 47);
        panel_4.add(lblCaiDat);


        JPanel panel_5 = new JPanel();
        panel_5.setBackground(new Color(255, 224, 224));
        panel_5.setBounds(0, 57, 822, 150);
        panel_2.add(panel_5);
        panel_5.setLayout(null);

        JLabel name = new JLabel("Quan Ly Phong");
        name.setHorizontalAlignment(SwingConstants.CENTER);
        name.setFont(new Font("Arial", Font.BOLD, 30));
        name.setBounds(150, 0, 600, 100);
        panel_5.add(name);

        JButton addbtn = new JButton("Them +");
        addbtn.setFont(new Font("Arial", Font.BOLD, 15));
        addbtn.setBounds(5, 110, 100, 30);
        addbtn.setBackground(new Color(201, 246, 3));
        addbtn.setForeground(new Color(0, 0, 0));
        panel_5.add(addbtn);

        JTextField searchfield = new JTextField();
        searchfield.setBounds(345, 110, 400, 30);
        panel_5.add(searchfield);

        JButton searchbtn = new JButton("OK");
        searchbtn.setHorizontalAlignment(SwingConstants.CENTER);
        searchbtn.setVerticalAlignment(SwingConstants.CENTER);
        searchbtn.setFont(new Font("Arial", Font.BOLD, 10));
        searchbtn.setBounds(744, 110, 50, 29);
        searchbtn.setBackground(new Color(167, 167, 167));
        searchbtn.setOpaque(true);
        panel_5.add(searchbtn);

        MultiButtonTable tablez = new MultiButtonTable();

        addbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ThemPhong p;
                ThemPTP ptp;
                if(tabbebpane.getSelectedIndex() == 0)
                  p = new ThemPhong();
                else
                    ptp = new ThemPTP();


                frame.dispose();
            }
        });

    }

    public ArrayList<Phong> listphong() {
        ArrayList<Phong> listphong = new ArrayList<>();
        Connection connection = ConnectionOracle.getConnection();
        String query = "SELECT MAPHONG,TENLOAIPHONG,SOLUONGNGUOIHIENTAI,TINHTRANG FROM PHONG P inner join LOAIPHONG L on P.MALOAIPHONG = L.MALOAIPHONG ORDER BY MAPHONG";
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                int maphong = rs.getInt(1);
                String maloaiphong = rs.getString(2);
                String tinh_trang = rs.getString(3);
                int soluong = rs.getInt(4);

                if (tinh_trang != null) {
                    if (tinh_trang.equals("0")) tinh_trang = "trống";
                    if (tinh_trang.equals("1")) tinh_trang = "đã có ngừoi";
                    if (tinh_trang.equals("2")) tinh_trang = "đã được đặt";
                } else tinh_trang = "trống";
                listphong.add(new Phong(maphong, maloaiphong, soluong, tinh_trang));
            }
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listphong;

    }

    public ArrayList<PhieuThuePhong> listphieuthuephong() {
        ArrayList<PhieuThuePhong> listptp = new ArrayList<>();
        Connection connection = ConnectionOracle.getConnection();
        String query = "SELECT MAPTP, B.HOTENNV, C.TENKH, NGAYLAPPTP, TONGTIENTHANHTOAN, TINHTRANGTHANHTOAN, NGAYTHANHTOAN FROM PHIEU_THUE_PHONG A, NHANVIEN B, KHACHHANG C \n" +
                "WHERE A.MANV = B.MANV \n" +
                "AND A.MAKH = C.MAKH ;";
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                int MaPTP = rs.getInt(1);
                String TenKh = rs.getString(2);
                String TenNV = rs.getString(3);
                Date NgayPapPTP = rs.getDate(4);
                int TinhTrangThanhToan = rs.getInt(5);
                double TongTienThanhToan = rs.getDouble(6);
                Date NgayThanhToan = rs.getDate(7);

                listptp.add(new PhieuThuePhong(MaPTP, TenKh, TenNV, NgayPapPTP, TinhTrangThanhToan, TongTienThanhToan, NgayThanhToan));
            }
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listptp;

    }

    public class MultiButtonTable {

        public MultiButtonTable() {
            EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {

                    try {
                        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                        ex.printStackTrace();
                    }
                    ////ds phong
                    ArrayList<Phong> list = listphong();
                    MyTableModel model = new MyTableModel();
                    int[] row = new int[2];
                    String[] row1 = new String[2];
                    for (Phong phong : list) {
                        row[0] = phong.getMaPhong();
                        row1[0] = phong.getMaLoaiPhong();
                        row[1] = phong.getSoLuongNguoiHienTai();
                        row1[1] = phong.getTinhTrang();

                        model.add(new Phong(row[0], row1[0], row[1], row1[1]));
                    }

                    JTable table = new JTable(model);
                    AcceptRejectRenderer renderer = new AcceptRejectRenderer();
                    table.getColumnModel().getColumn(4).setCellRenderer(renderer);
                    table.getColumnModel().getColumn(4).setCellEditor(new AcceptRejectEditor());
                    table.setRowHeight(renderer.getTableCellRendererComponent(table, null, true, true, 0, 0).getPreferredSize().height);
                    table.setFillsViewportHeight(true);
                    table.setOpaque(true);
                    table.setPreferredScrollableViewportSize(new Dimension(500, 70));

                    JScrollPane scrollpane = new JScrollPane(table);
                    scrollpane.setViewportView(table);

                    //phieu thue phong

                    ArrayList<PhieuThuePhong> listptp = listphieuthuephong();
                    MyTablePTPModel modelptp = new MyTablePTPModel();
                    int[] rowint = new int[2];
                    String[] rowStr = new String[2];
                    Date[] rowdate = new Date[2];
                    double rowdb;
                    for (PhieuThuePhong ptp : listptp) {
                        rowint[0] = ptp.getMaPTP();
                        rowint[1] = ptp.getTinhTrangThanhToan();
                        rowStr[0] = ptp.getTenKh();
                        rowStr[1] = ptp.getTenNV();
                        rowdate[0] = ptp.getNgayPapPTP();
                        rowdate[1] = ptp.getNgayThanhToan();
                        rowdb = ptp.getTongTienThanhToan();

                        modelptp.add(new PhieuThuePhong(rowint[0], rowStr[0], rowStr[1], rowdate[0], rowint[1], rowdb, rowdate[1]));
                    }

                    JTable table2 = new JTable(modelptp);
                    AcceptRejectRendererPTP renderer2 = new AcceptRejectRendererPTP();
                    table2.getColumnModel().getColumn(7).setCellRenderer(renderer2);
                    table2.getColumnModel().getColumn(7).setCellEditor(new AcceptRejectEditorPTP());
                    table2.setRowHeight(renderer2.getTableCellRendererComponent(table2, null, true, true, 0, 0).getPreferredSize().height);
                    table2.setFillsViewportHeight(true);
                    table2.setOpaque(true);
                    table2.setPreferredScrollableViewportSize(new Dimension(500, 70));

                    JScrollPane scrollpanez = new JScrollPane(table2);
                    scrollpanez.setViewportView(table2);

                    tabbebpane = new JTabbedPane();
                    tabbebpane.setBounds(0, 207, 840, 600);

                    tabbebpane.addTab("Danh sach phong", scrollpane);
                    tabbebpane.setMnemonicAt(0, KeyEvent.VK_1);

                    tabbebpane.addTab("Phieu thue phong", scrollpanez);
                    tabbebpane.setMnemonicAt(1, KeyEvent.VK_2);

                    panel_2.add(tabbebpane);
                }
            });
        }

        //phong
        public class MyTableModel extends AbstractTableModel {

            private List<Phong> data;

            public MyTableModel() {
                data = new ArrayList<>();
            }

            @Override
            public String getColumnName(int column) {
                return switch (column) {
                    case 0 -> "ID";
                    case 1 -> "Name";
                    case 2 -> "So luong";
                    case 3 -> "tinh trang";
                    case 4 -> "";
                    default -> null;
                };
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return switch (columnIndex) {
                    case 0, 2 -> Integer.class;
                    case 1, 3 -> String.class;
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
                Phong obj = data.get(rowIndex);
                Object value = null;
                switch (columnIndex) {
                    case 0:
                        value = obj.getMaPhong();
                        break;
                    case 1:
                        value = obj.getMaLoaiPhong();
                        break;
                    case 2:
                        value = obj.getSoLuongNguoiHienTai();
                        break;
                    case 3:
                        value = obj.getTinhTrang();
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

                    Phong value = data.get(rowIndex);
                    if ("accept".equals(aValue)) {
                        System.out.println("Accepted");
                    } else {
                        System.out.println("Rejected");
                    }
                    fireTableCellUpdated(rowIndex, columnIndex);
                    remove(value);

                }
            }

            public void add(Phong value) {
                int startIndex = getRowCount();
                data.add(value);
                fireTableRowsInserted(startIndex, getRowCount() - 1);
            }

            public void remove(Phong value) {
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

        public class AcceptRejectPane extends JPanel {

            private JButton accept;
            private JButton reject;
            private int row;
            private String state;


            public AcceptRejectPane() {
                setLayout(new GridBagLayout());
                accept = new JButton("Đặt");
                accept.setActionCommand("accept");
                reject = new JButton("Xóa");
                reject.setActionCommand("reject");

                add(accept);
                add(reject);

                ActionListener listener = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        state = e.getActionCommand();
                        System.out.println("State = " + state);
                    }
                };

                accept.addActionListener(listener);
                reject.addActionListener(listener);
            }

            public void addActionListener(ActionListener listener) {
                accept.addActionListener(listener);
                reject.addActionListener(listener);
            }

            public String getState() {
                return state;
            }

            public int getRow() {
                return row;
            }

            public void setRow(int row) {
                this.row = row;
            }
        }

        public class AcceptRejectRenderer extends DefaultTableCellRenderer {

            private AcceptRejectPane acceptRejectPane;


            public AcceptRejectRenderer() {
                acceptRejectPane = new AcceptRejectPane();
            }


            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                if (isSelected) {
                    acceptRejectPane.setBackground(table.getSelectionBackground());
                } else {
                    acceptRejectPane.setBackground(table.getBackground());
                }
                return acceptRejectPane;
            }
        }

        public class AcceptRejectEditor extends AbstractCellEditor implements TableCellEditor {

            private AcceptRejectPane acceptRejectPane;


            public AcceptRejectEditor() {
                acceptRejectPane = new AcceptRejectPane();
                acceptRejectPane.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        SwingUtilities.invokeLater(new Runnable() {


                            @Override
                            public void run() {
                                int reply;
                                int r = acceptRejectPane.getRow();
                                ++r;

                                if (acceptRejectPane.getState().equals("reject")) {
                                    reply = JOptionPane.showConfirmDialog(null, "are u sure?", "comfir", JOptionPane.YES_NO_OPTION);
                                    if (reply == JOptionPane.YES_OPTION) {
                                        try {
                                            ArrayList<Phong> listphong = new ArrayList<>();
                                            Connection con = ConnectionOracle.getConnection();
                                            String query = "DELETE FROM PHONG WHERE MAPHONG = (SELECT MAPHONG FROM PHONG WHERE ROWNUM <=" + r + " MINUS SELECT MAPHONG FROM PHONG WHERE ROWNUM <" + r + " )";
                                            PreparedStatement pt = con.prepareStatement(query);
                                            pt.execute();
                                            con.close();
                                            frame.dispose();
                                            JOptionPane.showMessageDialog(null, "Delete Success!!");
                                            QuanLyPhong pz = new QuanLyPhong();

                                        } catch (SQLException throwables) {
                                            throwables.printStackTrace();
                                            JOptionPane.showMessageDialog(null, "Delete NOT Success!!");

                                        }

                                    } else {
                                        JOptionPane.showMessageDialog(null, "Canecled Delete ");
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "Chua co chuc nang nay" + r);
                                    frame.dispose();
                                    QuanLyPhong p = new QuanLyPhong();
                                }

                            }
                        });
                    }
                });
            }

            @Override
            public Object getCellEditorValue() {
                return acceptRejectPane.getState();
            }


            @Override
            public boolean isCellEditable(EventObject e) {
                return true;
            }


            @Override
            public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
                if (isSelected) {
                    acceptRejectPane.setBackground(table.getSelectionBackground());
                } else {
                    acceptRejectPane.setBackground(table.getBackground());
                }
                acceptRejectPane.setRow(row);
                return acceptRejectPane;
            }


        }

        //phieuthuephong

        public class MyTablePTPModel extends AbstractTableModel {

            private List<PhieuThuePhong> data;

            public MyTablePTPModel() {
                data = new ArrayList<>();
            }

            @Override
            public String getColumnName(int column) {
                return switch (column) {
                    case 0 -> "ID";
                    case 1 -> "Tên Nhân viên";
                    case 2 -> "Tên khách hàng";
                    case 3 -> "Ngay lap phieu";
                    case 4 -> "Tinh trang";
                    case 5 -> "Tong tien";
                    case 6 -> "Ngay thanh toan ";
                    case 7 -> "";
                    default -> null;
                };
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return switch (columnIndex) {
                    case 0 -> Integer.class;
                    case 1 -> String.class;
                    case 2 -> String.class;
                    case 3 -> Date.class;
                    case 4 -> Integer.class;
                    case 5 -> Double.class;
                    case 6 -> Date.class;
                    default -> Object.class;
                };
            }

            @Override
            public int getRowCount() {
                return data.size();
            }

            @Override
            public int getColumnCount() {
                return 8;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                PhieuThuePhong obj = data.get(rowIndex);
                Object value = null;
                switch (columnIndex) {
                    case 0:
                        value = obj.getMaPTP();
                        break;
                    case 1:
                        value = obj.getTenKh();
                        break;
                    case 2:
                        value = obj.getTenNV();
                        break;
                    case 3:
                        value = obj.getNgayPapPTP();
                        break;
                    case 4:
                        value = obj.getTinhTrangThanhToan();
                        break;
                    case 5:
                        value = obj.getTongTienThanhToan();
                        break;
                    case 6:
                        value = obj.getNgayThanhToan();
                        break;
                    case 7:
                        break;
                }
                return value;
            }

            @Override
            public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
                if (columnIndex == 7) {

                    System.out.println(aValue);

                    PhieuThuePhong value = data.get(rowIndex);
                    if ("accept".equals(aValue)) {
                        System.out.println("Accepted");
                    } else {
                        System.out.println("Rejected");
                    }
                    fireTableCellUpdated(rowIndex, columnIndex);
                    remove(value);

                }
            }

            public void add(PhieuThuePhong value) {
                int startIndex = getRowCount();
                data.add(value);
                fireTableRowsInserted(startIndex, getRowCount() - 1);
            }

            public void remove(PhieuThuePhong value) {
                int startIndex = data.indexOf(value);
                System.out.println("startIndex = " + startIndex);
                data.remove(value);
                fireTableRowsInserted(startIndex, startIndex);
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return columnIndex == 7;
            }
        }

        public class AcceptRejectPanePTP extends JPanel {

            private JButton accept;
            private JButton reject;
            private int row;
            private String state;


            public AcceptRejectPanePTP() {
                setLayout(new GridBagLayout());
                accept = new JButton("Update");
                accept.setActionCommand("accept");
                reject = new JButton("Kiểm tra");
                reject.setActionCommand("reject");

                add(accept);
                add(reject);

                ActionListener listener = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        state = e.getActionCommand();
                        System.out.println("State = " + state);
                    }
                };

                accept.addActionListener(listener);
                reject.addActionListener(listener);
            }

            public void addActionListener(ActionListener listener) {
                accept.addActionListener(listener);
                reject.addActionListener(listener);
            }

            public String getState() {
                return state;
            }

            public int getRow() {
                return row;
            }

            public void setRow(int row) {
                this.row = row;
            }
        }

        public class AcceptRejectRendererPTP extends DefaultTableCellRenderer {

            private AcceptRejectPanePTP acceptRejectPane;


            public AcceptRejectRendererPTP() {
                acceptRejectPane = new AcceptRejectPanePTP();
            }


            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                if (isSelected) {
                    acceptRejectPane.setBackground(table.getSelectionBackground());
                } else {
                    acceptRejectPane.setBackground(table.getBackground());
                }
                return acceptRejectPane;
            }
        }

        public class AcceptRejectEditorPTP extends AbstractCellEditor implements TableCellEditor {

            private AcceptRejectPanePTP acceptRejectPane;


            public AcceptRejectEditorPTP() {
                acceptRejectPane = new AcceptRejectPanePTP();
                acceptRejectPane.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        SwingUtilities.invokeLater(new Runnable() {


                            @Override
                            public void run() {
                                int reply;
                                int r = acceptRejectPane.getRow();
                                ++r;

                                if (acceptRejectPane.getState().equals("reject")) {
                                    reply = JOptionPane.showConfirmDialog(null, "are u sure?", "comfir", JOptionPane.YES_NO_OPTION);
                                    if (reply == JOptionPane.YES_OPTION) {


                                    } else {
                                        JOptionPane.showMessageDialog(null, "Canecled Delete ");
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "Chua co chuc nang nay" + r);
                                    frame.dispose();
                                    QuanLyPhong p = new QuanLyPhong();
                                }

                            }
                        });
                    }
                });
            }

            @Override
            public Object getCellEditorValue() {
                return acceptRejectPane.getState();
            }


            @Override
            public boolean isCellEditable(EventObject e) {
                return true;
            }


            @Override
            public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
                if (isSelected) {
                    acceptRejectPane.setBackground(table.getSelectionBackground());
                } else {
                    acceptRejectPane.setBackground(table.getBackground());
                }
                acceptRejectPane.setRow(row);
                return acceptRejectPane;
            }


        }


    }


}