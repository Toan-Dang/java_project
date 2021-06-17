package com.company.View.NhanVien.QuanLyNhanVien;


import com.company.Data.*;
import com.company.Model.NhanVien;
import com.company.View.NhanVien.DSPHONG.QuanLyPhong;
import com.company.View.NhanVien.DSPHONG.ThemPTP;
import com.company.View.NhanVien.QuanLiHomeView;
import com.company.View.NhanVien.QuanLyDichVu.Quanlydichvu;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;

public class QuanLyNhanVien extends QuanLiHomeView {
    JFrame frame = new JFrame();
    JPanel panel_2;
    JTabbedPane tabbebpane;
    JTextField searchfield;
    JTable table;
    TableRowSorter<TableModel> rowSorter;
    TableRowSorter<TableModel> rowSorter2;

    public QuanLyNhanVien() {
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 1200, 730);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Quản lý nhân viên");

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setBackground(SystemColor.controlDkShadow);
        frame.add(contentPane);

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
        btnCaiDat.setBackground(SystemColor.scrollbar);
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
        panel_2.setBounds(174, 10, 1000, 673);
        contentPane.add(panel_2);
        panel_2.setLayout(null);

        JPanel panel_4 = new JPanel();
         panel_4.setBackground(new Color(224, 255, 255));
    //    panel_4.setBackground(new Color(252, 255, 224));
        panel_4.setBounds(0, 0, 1000, 57);
        panel_2.add(panel_4);
        panel_4.setLayout(null);

        btnQuanLiDichVu = new JButton("Qu\u1EA3n l\u00FD d\u1ECBch v\u1EE5");
        btnQuanLiDichVu.setFont(new Font("Times New Roman", Font.BOLD, 15));
        btnQuanLiDichVu.setBounds(204, 0, 147, 57);
        panel_4.add(btnQuanLiDichVu);
        btnQuanLiDichVu.setBorderPainted(false);
        btnQuanLiDichVu.setContentAreaFilled(false);
        btnQuanLiDichVu.addActionListener(e -> {
         new Quanlydichvu();
            frame.dispose();
        });
        btnQuanLiPhong = new JButton("Qu\u1EA3n l\u00FD ph\u00F2ng ");
        btnQuanLiPhong.setFont(new Font("Times New Roman", Font.BOLD, 15));
        btnQuanLiPhong.setBounds(350, 0, 147, 57);
        panel_4.add(btnQuanLiPhong);
        btnQuanLiPhong.setBorderPainted(false);
        btnQuanLiPhong.setContentAreaFilled(false);
        btnQuanLiPhong.addActionListener(e -> {
             new QuanLyPhong();
            frame.dispose();
        });
        btnQuanLiNhanVien = new JButton("Qu\u1EA3n l\u00FD nh\u00E2n vi\u00EAn");
        btnQuanLiNhanVien.setFont(new Font("Times New Roman", Font.BOLD, 15));
        btnQuanLiNhanVien.setBounds(495, 0, 168, 57);
        panel_4.add(btnQuanLiNhanVien);
        btnQuanLiNhanVien.setBorderPainted(false);
        btnQuanLiNhanVien.setContentAreaFilled(false);
        btnQuanLiNhanVien.addActionListener(e -> {
             new QuanLyNhanVien();
            frame.dispose();
        });
        JLabel lblCaiDat = new JLabel("C\u00E0i \u0111\u1EB7t");
        lblCaiDat.setHorizontalAlignment(SwingConstants.CENTER);
        lblCaiDat.setFont(new Font("Times New Roman", Font.BOLD, 15));
        lblCaiDat.setBounds(10, 5, 117, 47);
        panel_4.add(lblCaiDat);

        JPanel panel_5 = new JPanel();
        panel_5.setBackground(new Color(132, 161, 239));
        panel_5.setBounds(0, 57, 1000, 150);
        panel_2.add(panel_5);
        panel_5.setLayout(null);

        JLabel name = new JLabel("Quan Ly Nhan Vien");
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

        searchfield = new JTextField();
        searchfield.setBounds(530, 110, 450, 30);
        panel_5.add(searchfield);


         new MultiButtonTable();

        addbtn.addActionListener(e -> {

            if (tabbebpane.getSelectedIndex() == 0)
                new ThemNhanVien();
            else
                new ThemPTP();

            frame.dispose();
        });
        searchfield.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = searchfield.getText();

                if (tabbebpane.getSelectedIndex() == 0)
                    if (text.trim().length() == 0) {
                        rowSorter.setRowFilter(null);
                    } else {
                        rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                    }
                else if (text.trim().length() == 0) {
                    rowSorter2.setRowFilter(null);
                } else {
                    rowSorter2.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }

            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = searchfield.getText();
                if (tabbebpane.getSelectedIndex() == 0)
                    if (text.trim().length() == 0) {
                        rowSorter.setRowFilter(null);
                    } else {
                        rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                    }
                else if (text.trim().length() == 0) {
                    rowSorter2.setRowFilter(null);
                } else {
                    rowSorter2.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }

            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        });
    }




    public class MultiButtonTable {

        public MultiButtonTable() {
            EventQueue.invokeLater(() -> {

                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }
                ////ds nhan vien
                ArrayList<NhanVien> list = getListNhanVien.listnhanvien();
                MyTableModel model = new MyTableModel();
                int manv;
                String[] row = new String[3];
                for (NhanVien nv : list) {
                    manv = nv.getMaNV();
                    row[0] = nv.getTenNV();
                    row[1] = nv.getUserName();
                    row[2] = nv.getChucVu();

                    model.add(new NhanVien(manv, row[0], row[1], row[2]));
                }

                table = new JTable(model);
                AcceptRejectRenderer renderer = new AcceptRejectRenderer();
                table.getColumnModel().getColumn(4).setCellRenderer(renderer);
                table.getColumnModel().getColumn(4).setCellEditor(new AcceptRejectEditor());
                table.setRowHeight(renderer.getTableCellRendererComponent(table, null, true, true, 0, 0).getPreferredSize().height);
                table.setFillsViewportHeight(true);
                table.setOpaque(true);
                table.setPreferredScrollableViewportSize(new Dimension(500, 70));
                rowSorter = new TableRowSorter<>(table.getModel());
                table.setRowSorter(rowSorter);

                JScrollPane scrollpane = new JScrollPane(table);
                scrollpane.setViewportView(table);

                tabbebpane = new JTabbedPane();
                tabbebpane.setBounds(0, 207, 1000, 600);

                tabbebpane.addTab("Danh sach nhan vien", scrollpane);
                tabbebpane.setMnemonicAt(0, KeyEvent.VK_1);
                //quanly

                ArrayList<NhanVien> listql = getListQuanLyData.listquanly();
                MyTableModelQL modelql = new MyTableModelQL();
                int maql;
                String[] rowz = new String[3];
                for (NhanVien nv : listql) {
                    maql = nv.getMaNV();
                    rowz[0] = nv.getTenNV();
                    rowz[1] = nv.getUserName();
                    rowz[2] = nv.getChucVu();

                    modelql.add(new NhanVien(maql, rowz[0], rowz[1], rowz[2]));
                }
                JTable table2 = new JTable(modelql);
                AcceptRejectRendererQL renderer2 = new AcceptRejectRendererQL();
                table2.getColumnModel().getColumn(4).setCellRenderer(renderer2);
                table2.getColumnModel().getColumn(4).setCellEditor(new AcceptRejectEditorQL());
                table2.setRowHeight(renderer2.getTableCellRendererComponent(table2, null, true, true, 0, 0).getPreferredSize().height);
                table2.setFillsViewportHeight(true);
                table2.setOpaque(true);
                table2.setPreferredScrollableViewportSize(new Dimension(500, 70));
                rowSorter2 = new TableRowSorter<>(table2.getModel());
                table2.setRowSorter(rowSorter2);

                JScrollPane scrollpanez = new JScrollPane(table2);
                scrollpanez.setViewportView(table2);

                tabbebpane.addTab("Danh sach quan ly", scrollpanez);
                tabbebpane.setMnemonicAt(1, KeyEvent.VK_2);

                panel_2.add(tabbebpane);
            });
        }

        //nhan vien
        public class MyTableModel extends AbstractTableModel {

            private final List<NhanVien> data;

            public MyTableModel() {
                data = new ArrayList<>();
            }

            @Override
            public String getColumnName(int column) {
                return switch (column) {
                    case 0 -> "ID";
                    case 1 -> "Name";
                    case 2 -> "Username";
                    case 3 -> "Chuc vu";
                    case 4 -> "";
                    default -> null;
                };
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return switch (columnIndex) {
                    case 0 -> Integer.class;
                    case 1, 2, 3 -> String.class;
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
                NhanVien obj = data.get(rowIndex);
                Object value = null;
                switch (columnIndex) {
                    case 0:
                        value = obj.getMaNV();
                        break;
                    case 1:
                        value = obj.getTenNV();
                        break;
                    case 2:
                        value = obj.getUserName();
                        break;
                    case 3:
                        value = obj.getChucVu();
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

                    NhanVien value = data.get(rowIndex);
                    if ("accept".equals(aValue)) {
                        System.out.println("Accepted");
                    } else {
                        System.out.println("Rejected");
                    }
                    fireTableCellUpdated(rowIndex, columnIndex);
                    remove(value);

                }
            }

            public void add(NhanVien value) {
                int startIndex = getRowCount();
                data.add(value);
                fireTableRowsInserted(startIndex, getRowCount() - 1);
            }

            public void remove(NhanVien value) {
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

            private final JButton chitiet;
            private final JButton reject;
            private int row;
            private int col;
            private String state;


            public AcceptRejectPane() {
                setLayout(new GridBagLayout());
                chitiet = new JButton("Xem chi tiết");
                chitiet.setActionCommand("chitiet");
                reject = new JButton("Xóa");
                reject.setActionCommand("reject");

                add(chitiet);
                add(reject);

                ActionListener listener = e -> {
                    state = e.getActionCommand();
                    System.out.println("State = " + state);
                };

                chitiet.addActionListener(listener);
                reject.addActionListener(listener);
            }

            public void addActionListener(ActionListener listener) {
                chitiet.addActionListener(listener);
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

            public int getCol() {
                return col;
            }

            public void setCol(int col) {
                this.col = col;
            }
        }

        public class AcceptRejectRenderer extends DefaultTableCellRenderer {

            private final AcceptRejectPane acceptRejectPane;


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

            private final AcceptRejectPane acceptRejectPane;


            public AcceptRejectEditor() {
                acceptRejectPane = new AcceptRejectPane();
                acceptRejectPane.addActionListener(e -> SwingUtilities.invokeLater(() -> {
                    int reply;
                    int r = acceptRejectPane.getRow();
                    ++r;
                    if (acceptRejectPane.getState().equals("reject")) {
                        reply = JOptionPane.showConfirmDialog(null, "are u sure?", "comfirn", JOptionPane.YES_NO_OPTION);
                        if (reply == JOptionPane.YES_OPTION) {
                            new XoaNhanVienData(r);
                            frame.dispose();
                            new QuanLyNhanVien();
                        } else {
                            JOptionPane.showMessageDialog(null, "Canecled Delete ");
                        }
                    } else {
                        int getusernamenv = searchNhanVienData.searchNhanVien(r);
                        frame.dispose();
                        new ThongTinNhanVien(getusernamenv);
                    }
                }));
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
        //quanly
        public class MyTableModelQL extends AbstractTableModel {

            private final List<NhanVien> data;

            public MyTableModelQL() {
                data = new ArrayList<>();
            }

            @Override
            public String getColumnName(int column) {
                return switch (column) {
                    case 0 -> "ID";
                    case 1 -> "Name";
                    case 2 -> "Username";
                    case 3 -> "Chuc vu";
                    case 4 -> "";
                    default -> null;
                };
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return switch (columnIndex) {
                    case 0 -> Integer.class;
                    case 1, 2, 3 -> String.class;
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
                NhanVien obj = data.get(rowIndex);
                Object value = null;
                switch (columnIndex) {
                    case 0:
                        value = obj.getMaNV();
                        break;
                    case 1:
                        value = obj.getTenNV();
                        break;
                    case 2:
                        value = obj.getUserName();
                        break;
                    case 3:
                        value = obj.getChucVu();
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

                    NhanVien value = data.get(rowIndex);
                    if ("accept".equals(aValue)) {
                        System.out.println("Accepted");
                    } else {
                        System.out.println("Rejected");
                    }
                    fireTableCellUpdated(rowIndex, columnIndex);
                    remove(value);

                }
            }

            public void add(NhanVien value) {
                int startIndex = getRowCount();
                data.add(value);
                fireTableRowsInserted(startIndex, getRowCount() - 1);
            }

            public void remove(NhanVien value) {
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

        public class AcceptRejectPaneQL extends JPanel {

            private final JButton accept;
            private final JButton reject;
            private int row;
            private String state;


            public AcceptRejectPaneQL() {
                setLayout(new GridBagLayout());
                accept = new JButton("Xem chi tiết");
                accept.setActionCommand("accept");
                reject = new JButton("xem nhân viên");
                reject.setActionCommand("reject");

                add(accept);
                add(reject);

                ActionListener listener = e -> {
                    state = e.getActionCommand();
                    System.out.println("State = " + state);
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

        public class AcceptRejectRendererQL extends DefaultTableCellRenderer {

            private final AcceptRejectPaneQL acceptRejectPane;


            public AcceptRejectRendererQL() {
                acceptRejectPane = new AcceptRejectPaneQL();
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

        public class AcceptRejectEditorQL extends AbstractCellEditor implements TableCellEditor {

            private final AcceptRejectPaneQL acceptRejectPane;


            public AcceptRejectEditorQL() {
                acceptRejectPane = new AcceptRejectPaneQL();
                acceptRejectPane.addActionListener(e -> SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        int r = acceptRejectPane.getRow();
                        ++r;
                        JOptionPane.showMessageDialog(null, "Chua co chuc nang nay" + r);
                        frame.dispose();
                     new QuanLyNhanVien();
                    }
                }));
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