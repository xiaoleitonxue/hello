import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class EmployeeManagerUI extends JFrame {
    private JTextField searchField;
    private JButton searchButton;
    private JButton addButton;
    private JTable employeeTable;
    private JScrollPane scrollPane;
    private DefaultTableModel tableModel;
    private String currentUser;

    public EmployeeManagerUI(String currentUser) {
        this.currentUser = currentUser;
        initUI();
    }

    private void initUI() {
        setTitle("员工信息管理系统 - 当前用户：" + currentUser);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));
        mainPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
        mainPanel.setBackground(new Color(245, 247, 250));

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        topPanel.setBackground(new Color(245, 247, 250));

        JLabel searchLabel = new JLabel("搜索：");
        searchLabel.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
        topPanel.add(searchLabel);

        searchField = new JTextField(20);
        searchField.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
        searchField.setPreferredSize(new Dimension(200, 35));
        searchField.setBorder(new CompoundBorder(
            new LineBorder(new Color(200, 200, 200), 1),
            new EmptyBorder(5, 10, 5, 10)
        ));
        topPanel.add(searchField);

        searchButton = new JButton("🔍 搜索");
        searchButton.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
        searchButton.setBackground(new Color(52, 152, 219));
        searchButton.setForeground(Color.WHITE);
        searchButton.setFocusPainted(false);
        searchButton.setBorderPainted(false);
        searchButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        searchButton.setPreferredSize(new Dimension(100, 35));
        searchButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                searchButton.setBackground(new Color(41, 128, 185));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                searchButton.setBackground(new Color(52, 152, 219));
            }
        });
        topPanel.add(searchButton);

        addButton = new JButton("➕ 添加");
        addButton.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
        addButton.setBackground(new Color(46, 204, 113));
        addButton.setForeground(Color.WHITE);
        addButton.setFocusPainted(false);
        addButton.setBorderPainted(false);
        addButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        addButton.setPreferredSize(new Dimension(100, 35));
        addButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addButton.setBackground(new Color(39, 174, 96));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addButton.setBackground(new Color(46, 204, 113));
            }
        });
        topPanel.add(addButton);

        String[] columns = {"工号", "姓名", "年龄", "部门", "薪资"};
        tableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        employeeTable = new JTable(tableModel);
        employeeTable.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
        employeeTable.setRowHeight(35);
        employeeTable.getTableHeader().setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
        employeeTable.getTableHeader().setBackground(new Color(52, 152, 219));
        employeeTable.getTableHeader().setForeground(Color.WHITE);
        employeeTable.setSelectionBackground(new Color(230, 240, 250));
        employeeTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        employeeTable.getColumnModel().getColumn(0).setPreferredWidth(100);
        employeeTable.getColumnModel().getColumn(1).setPreferredWidth(150);
        employeeTable.getColumnModel().getColumn(2).setPreferredWidth(80);
        employeeTable.getColumnModel().getColumn(3).setPreferredWidth(200);
        employeeTable.getColumnModel().getColumn(4).setPreferredWidth(120);

        scrollPane = new JScrollPane(employeeTable);
        scrollPane.setBorder(new LineBorder(new Color(200, 200, 200), 1));

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());
        centerPanel.add(scrollPane, BorderLayout.CENTER);
        centerPanel.setBackground(Color.WHITE);
        centerPanel.setBorder(new CompoundBorder(
            new LineBorder(new Color(200, 200, 200), 1),
            new EmptyBorder(0, 0, 0, 0)
        ));

        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(centerPanel, BorderLayout.CENTER);

        add(mainPanel);
        setVisible(true);

        loadEmployeeData();

        searchButton.addActionListener(e -> searchEmployee());
        addButton.addActionListener(e -> addEmployee());

        employeeTable.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    int row = employeeTable.rowAtPoint(e.getPoint());
                    if (row >= 0) {
                        employeeTable.setRowSelectionInterval(row, row);
                        showContextMenu(e);
                    }
                }
            }
        });
    }

    private void loadEmployeeData() {
        tableModel.setRowCount(0);
        List<manager.Employee> employees = manager.getAllEmployees();
        for (manager.Employee emp : employees) {
            Object[] row = {
                emp.getId(),
                emp.getName(),
                emp.getAge(),
                emp.getDepartment(),
                emp.getSalary()
            };
            tableModel.addRow(row);
        }
    }

    private void searchEmployee() {
        String keyword = searchField.getText().trim();
        if (keyword.isEmpty()) {
            loadEmployeeData();
            return;
        }

        tableModel.setRowCount(0);
        manager.Employee emp = manager.searchEmployee(keyword);
        if (emp != null) {
            Object[] row = {
                emp.getId(),
                emp.getName(),
                emp.getAge(),
                emp.getDepartment(),
                emp.getSalary()
            };
            tableModel.addRow(row);
        }
    }

    private void addEmployee() {
        JTextField idField = new JTextField(15);
        JTextField nameField = new JTextField(15);
        JTextField ageField = new JTextField(15);
        JTextField deptField = new JTextField(15);
        JTextField salaryField = new JTextField(15);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 10, 10));
        panel.setBorder(new EmptyBorder(15, 15, 15, 15));

        panel.add(new JLabel("工号:"));
        panel.add(idField);
        panel.add(new JLabel("姓名:"));
        panel.add(nameField);
        panel.add(new JLabel("年龄:"));
        panel.add(ageField);
        panel.add(new JLabel("部门:"));
        panel.add(deptField);
        panel.add(new JLabel("薪资:"));
        panel.add(salaryField);

        int result = JOptionPane.showConfirmDialog(this, panel, "添加员工",
            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            try {
                String id = idField.getText().trim();
                String name = nameField.getText().trim();
                int age = Integer.parseInt(ageField.getText().trim());
                String dept = deptField.getText().trim();
                double salary = Double.parseDouble(salaryField.getText().trim());

                manager.Employee newEmp = new manager.Employee(id, name, age, dept, salary);
                manager.addEmployee(newEmp);
                loadEmployeeData();
                JOptionPane.showMessageDialog(this, "添加成功！", "成功", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "输入数据有误，请检查！", "错误", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void showContextMenu(MouseEvent e) {
        int selectedRow = employeeTable.getSelectedRow();
        if (selectedRow < 0) return;

        String empId = (String) tableModel.getValueAt(selectedRow, 0);
        String empName = (String) tableModel.getValueAt(selectedRow, 1);
        int empAge = (Integer) tableModel.getValueAt(selectedRow, 2);
        String empDept = (String) tableModel.getValueAt(selectedRow, 3);
        double empSalary = (Double) tableModel.getValueAt(selectedRow, 4);

        JPopupMenu popupMenu = new JPopupMenu();
        popupMenu.setBackground(Color.WHITE);

        JMenuItem editItem = new JMenuItem("✏️ 修改");
        editItem.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
        editItem.addActionListener(action -> editEmployee(empId, empName, empAge, empDept, empSalary));

        JMenuItem deleteItem = new JMenuItem("🗑️ 删除");
        deleteItem.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
        deleteItem.setForeground(new Color(231, 76, 60));
        deleteItem.addActionListener(action -> deleteEmployee(empId));

        popupMenu.add(editItem);
        popupMenu.addSeparator();
        popupMenu.add(deleteItem);

        popupMenu.show(employeeTable, e.getX(), e.getY());
    }

    private void editEmployee(String id, String name, int age, String dept, double salary) {
        JTextField nameField = new JTextField(name, 15);
        JTextField ageField = new JTextField(String.valueOf(age), 15);
        JTextField deptField = new JTextField(dept, 15);
        JTextField salaryField = new JTextField(String.valueOf(salary), 15);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2, 10, 10));
        panel.setBorder(new EmptyBorder(15, 15, 15, 15));

        panel.add(new JLabel("姓名:"));
        panel.add(nameField);
        panel.add(new JLabel("年龄:"));
        panel.add(ageField);
        panel.add(new JLabel("部门:"));
        panel.add(deptField);
        panel.add(new JLabel("薪资:"));
        panel.add(salaryField);

        int result = JOptionPane.showConfirmDialog(this, panel, "修改员工信息",
            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            try {
                String newName = nameField.getText().trim();
                int newAge = Integer.parseInt(ageField.getText().trim());
                String newDept = deptField.getText().trim();
                double newSalary = Double.parseDouble(salaryField.getText().trim());

                manager.Employee updatedEmp = new manager.Employee(id, newName, newAge, newDept, newSalary);
                manager.updateEmployee(updatedEmp);
                loadEmployeeData();
                JOptionPane.showMessageDialog(this, "修改成功！", "成功", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "输入数据有误，请检查！", "错误", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void deleteEmployee(String id) {
        int confirm = JOptionPane.showConfirmDialog(this,
            "确定要删除该员工吗？", "确认删除",
            JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

        if (confirm == JOptionPane.YES_OPTION) {
            manager.deleteEmployee(id);
            loadEmployeeData();
            JOptionPane.showMessageDialog(this, "删除成功！", "成功", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
