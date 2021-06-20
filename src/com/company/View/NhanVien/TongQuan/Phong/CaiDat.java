package com.company.View.NhanVien.TongQuan.Phong;

import com.company.Controller.PhongController;
import com.company.Model.Phong;
import com.company.View.NhanVien.TongQuan.DichVu.CaiDat_QuanLyDichVu;
import com.company.View.NhanVien.TongQuan.TongQuan;

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

public class CaiDat extends JFrame {

    JTable table;
    TableRowSorter<TableModel> rowSorter;
    JFrame frame = new JFrame();
    private final JPanel contentPane;

    public CaiDat() {
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 1240, 730);
        frame.setLocationRelativeTo(null);
        frame.setTitle("DS Phòng");

        contentPane = new JPanel();
        contentPane.setForeground(new Color(255, 255, 255));
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

        JButton btnPhieuThuePhong = new JButton("Phi\u1EBFu thu\u00EA ph\u00F2ng");
        btnPhieuThuePhong.setBackground(new Color(192, 192, 192));
        btnPhieuThuePhong.setFont(new Font("Times New Roman", Font.BOLD, 17));
        btnPhieuThuePhong.setBounds(0, 53, 170, 44);
        panel_1.add(btnPhieuThuePhong);

        JButton btnNewButton = new JButton("New button");
        btnNewButton.setBackground(new Color(192, 192, 192));
        btnNewButton.setBounds(0, 96, 170, 44);
        panel_1.add(btnNewButton);

        JButton btnNewButton_2 = new JButton("New button");
        btnNewButton_2.setBackground(new Color(192, 192, 192));
        btnNewButton_2.setBounds(0, 139, 170, 44);
        panel_1.add(btnNewButton_2);

        JButton btnNewButton_1 = new JButton("New button");
        btnNewButton_1.setBackground(new Color(192, 192, 192));
        btnNewButton_1.setBounds(0, 182, 170, 44);
        panel_1.add(btnNewButton_1);

        JButton btnNewButton_3 = new JButton("Cài đặt");
        btnNewButton_3.setBackground(new Color(255, 255, 255));
        btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 17));
        btnNewButton_3.setBounds(0, 225, 170, 44);
        panel_1.add(btnNewButton_3);

        JPanel panel_2 = new JPanel();
        panel_2.setBounds(190, 67, 1009, 36);
        panel_2.setBackground(new Color(178, 34, 34));
        contentPane.add(panel_2);
        panel_2.setLayout(null);

        JLabel lblNewLabel_2 = new JLabel("Cài Đặt");
        lblNewLabel_2.setForeground(new Color(255, 255, 255));
        lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblNewLabel_2.setBounds(39, 0, 134, 36);
        panel_2.add(lblNewLabel_2);

        JPanel panel_3 = new JPanel();
        panel_3.setBounds(189, 101, 537, 36);
        contentPane.add(panel_3);
        panel_3.setLayout(null);

        JButton btnNewButton_4 = new JButton("Cài đặt phòng");
        btnNewButton_4.setForeground(new Color(0, 0, 0));
        btnNewButton_4.setBackground(new Color(255, 255, 255));
        btnNewButton_4.setFont(new Font("Times New Roman", Font.BOLD, 16));
        btnNewButton_4.setBounds(0, 0, 179, 36);
        panel_3.add(btnNewButton_4);

        JButton btnQuanLyDichVu = new JButton("Quản lý dịch vụ");
        btnQuanLyDichVu.setForeground(new Color(0, 0, 0));
        btnQuanLyDichVu.setBackground(new Color(192, 192, 192));
        btnQuanLyDichVu.setFont(new Font("Times New Roman", Font.BOLD, 16));
        btnQuanLyDichVu.setBounds(178, 0, 179, 36);
        panel_3.add(btnQuanLyDichVu);

        JButton btnQuanLyNhanVien = new JButton("Quản lý nhân viên");
        btnQuanLyNhanVien.setForeground(new Color(0, 0, 0));
        btnQuanLyNhanVien.setBackground(new Color(192, 192, 192));
        btnQuanLyNhanVien.setFont(new Font("Times New Roman", Font.BOLD, 16));
        btnQuanLyNhanVien.setBounds(357, 0, 179, 36);
        panel_3.add(btnQuanLyNhanVien);

        JLabel lblNewLabel_3 = new JLabel("Danh sách phòng");
        lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
        lblNewLabel_3.setBounds(190, 168, 163, 37);
        contentPane.add(lblNewLabel_3);

        JButton btnNewButton_7_1 = new JButton("Thêm +");
        btnNewButton_7_1.setForeground(Color.WHITE);
        btnNewButton_7_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
        btnNewButton_7_1.setBackground(new Color(0, 139, 139));
        btnNewButton_7_1.setBounds(646, 201, 99, 27);
        contentPane.add(btnNewButton_7_1);
        btnNewButton_7_1.addActionListener(e -> new CaiDat_QuanLyPhong_ThemPhong());

        JPanel panel_4 = new JPanel();
        panel_4.setBackground(new Color(178, 34, 34));
        panel_4.setBounds(480, 625, 736, 3);
        contentPane.add(panel_4);

        JLabel lblNewLabel_4 = new JLabel("Khách hàng là thượng đế!");
        lblNewLabel_4.setFont(new Font("Times New Roman", Font.ITALIC, 17));
        lblNewLabel_4.setBounds(1011, 628, 243, 25);
        contentPane.add(lblNewLabel_4);

        //thanh tìm kiếm
        JTextField searchfield = new JTextField();
        searchfield.setBounds(261, 202, 291, 27);
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

        new MultiButtonTablePhong();

        btnTongQuan.addActionListener(e -> {
                    new TongQuan();
                    frame.dispose();
                }
        );
        btnQuanLyDichVu.addActionListener(e -> {
            frame.dispose();
            new CaiDat_QuanLyDichVu();
        });
        btnNewButton_4.addActionListener(e -> {new CaiDat();frame.dispose();});
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(CaiDat::new);
    }

    public class MultiButtonTablePhong {

        public MultiButtonTablePhong() {
            EventQueue.invokeLater(() -> {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }
                ////ds phong
                ArrayList<Phong> list = PhongController.listphongfull();
                MyTableModel model = new MyTableModel();
                int[] row = new int[2];
                String[] row1 = new String[2];
                double gia;
                for (Phong phong : list) {
                    row[0] = phong.getMaPhong();
                    row1[0] = phong.getMaLoaiPhong();
                    row[1] = phong.getSoLuongNguoiHienTai();
                    row1[1] = phong.getTinhTrang();
                    gia = phong.getGia();
                    model.add(new Phong(row[0], row1[0], row[1], row1[1], gia));
                }
                table = new JTable(model);
                AcceptRejectRenderer renderer = new AcceptRejectRenderer();
                table.getColumnModel().getColumn(5).setCellRenderer(renderer);
                table.getColumnModel().getColumn(5).setCellEditor(new AcceptRejectEditor());
                table.setRowHeight(renderer.getTableCellRendererComponent(table, null, true, true, 0, 0).getPreferredSize().height);
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
                scrollpane.setBounds(190, 238, 917, 300);

                contentPane.add(scrollpane);
            });
        }

        //phong
        public class MyTableModel extends AbstractTableModel {

            private final List<Phong> data;

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
                    case 4 -> "Gia";
                    case 5 -> "";
                    default -> null;
                };
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return switch (columnIndex) {
                    case 0, 2 -> Integer.class;
                    case 1, 3 -> String.class;
                    case 4 -> Double.class;
                    default -> Object.class;
                };
            }

            @Override
            public int getRowCount() {
                return data.size();
            }

            @Override
            public int getColumnCount() {
                return 6;
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
                        value = obj.getGia();
                        break;
                    case 5:
                        break;
                }
                return value;
            }

            @Override
            public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
                if (columnIndex == 5) {

                    System.out.println(aValue);

                    Phong value = data.get(rowIndex);
                    if ("accept".equals(aValue)) {
                        System.out.println("Accepted");
                    } else {
                        System.out.println("Rejected");
                    }
                    fireTableCellUpdated(rowIndex, columnIndex);
                  //  remove(value);

                }
            }

            public void add(Phong value) {
                int startIndex = getRowCount();
                data.add(value);
                fireTableRowsInserted(startIndex, getRowCount() - 1);
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return columnIndex == 5;
            }
        }

        public class AcceptRejectPane extends JPanel {

            private final JButton accept;
            private final JButton reject;
            private int row;
            private String state;


            public AcceptRejectPane() {
                setLayout(new GridBagLayout());
                accept = new JButton("Chỉnh sửa");
                accept.setActionCommand("accept");
                reject = new JButton("Xóa");
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
                acceptRejectPane.addActionListener(e -> SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        int reply;
                        int r = acceptRejectPane.getRow();
                        r = PhongController.getMaPhongrow(++r);
                        if(!PhongController.isDatPhong(r)){
                            if (acceptRejectPane.getState().equals("reject")) {
                                reply = JOptionPane.showConfirmDialog(null, "are u sure?", "comfirn", JOptionPane.YES_NO_OPTION);
                                if (reply == JOptionPane.YES_OPTION) {
                                     PhongController.XoaPhong(r);
                                    frame.dispose();
                                    new CaiDat();
                                } else {
                                    JOptionPane.showMessageDialog(null, "Canecled Delete ");
                                }
                            } else {
                                new CaiDat_QuanLyPhong_SuaPhong(r);
                                frame.dispose();

                            }
                        }
                         else {
                            JOptionPane.showMessageDialog(null, "Phòng số " + r + " đã đặt không thể thao tác");
                            frame.dispose();
                            new CaiDat();
                        }

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
                    acceptRejectPane.setRow(row);
                    return acceptRejectPane;
                }  else{acceptRejectPane.setBackground(table.getBackground());}

                return null;
            }
        }
    }
}


