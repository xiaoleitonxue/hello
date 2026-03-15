import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class test extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton registerButton;

    public static String currentUser = null;
    public static String currentPassword = null;
    public static boolean isLoggedIn = false;

    public test() {
        initUI();
    }

    private void initUI() {
        setTitle("系统登录");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 500);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(245, 247, 250));

        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(76, 175, 80));
        headerPanel.setPreferredSize(new Dimension(0, 120));

        JLabel titleLabel = new JLabel("欢迎登录");
        titleLabel.setFont(new Font("Microsoft YaHei", Font.BOLD, 28));
        titleLabel.setForeground(Color.WHITE);
        headerPanel.add(titleLabel);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(null);
        formPanel.setBackground(new Color(245, 247, 250));
        formPanel.setPreferredSize(new Dimension(400, 280));

        JLabel userIcon = new JLabel("👤");
        userIcon.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 20));
        userIcon.setBounds(50, 40, 30, 30);
        formPanel.add(userIcon);

        JLabel usernameLabel = new JLabel("用户名");
        usernameLabel.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
        usernameLabel.setForeground(new Color(100, 100, 100));
        usernameLabel.setBounds(90, 35, 60, 25);
        formPanel.add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(50, 70, 300, 45);
        usernameField.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
        usernameField.setBorder(new CompoundBorder(
            new LineBorder(new Color(200, 200, 200), 1),
            new EmptyBorder(5, 15, 5, 15)
        ));
        usernameField.setBackground(Color.WHITE);
        formPanel.add(usernameField);

        JLabel passIcon = new JLabel("🔒");
        passIcon.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 20));
        passIcon.setBounds(50, 130, 30, 30);
        formPanel.add(passIcon);

        JLabel passwordLabel = new JLabel("密码");
        passwordLabel.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
        passwordLabel.setForeground(new Color(100, 100, 100));
        passwordLabel.setBounds(90, 125, 60, 25);
        formPanel.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(50, 160, 300, 45);
        passwordField.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
        passwordField.setBorder(new CompoundBorder(
            new LineBorder(new Color(200, 200, 200), 1),
            new EmptyBorder(5, 15, 5, 15)
        ));
        passwordField.setBackground(Color.WHITE);
        formPanel.add(passwordField);

        loginButton = new JButton("登 录");
        loginButton.setBounds(50, 220, 140, 45);
        loginButton.setFont(new Font("Microsoft YaHei", Font.BOLD, 16));
        loginButton.setBackground(new Color(76, 175, 80));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFocusPainted(false);
        loginButton.setBorderPainted(false);
        loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        loginButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginButton.setBackground(new Color(66, 165, 70));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginButton.setBackground(new Color(76, 175, 80));
            }
        });
        formPanel.add(loginButton);

        registerButton = new JButton("注 册");
        registerButton.setBounds(210, 220, 140, 45);
        registerButton.setFont(new Font("Microsoft YaHei", Font.BOLD, 16));
        registerButton.setBackground(new Color(33, 150, 243));
        registerButton.setForeground(Color.WHITE);
        registerButton.setFocusPainted(false);
        registerButton.setBorderPainted(false);
        registerButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        registerButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                registerButton.setBackground(new Color(25, 118, 210));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                registerButton.setBackground(new Color(33, 150, 243));
            }
        });
        formPanel.add(registerButton);

        mainPanel.add(headerPanel, BorderLayout.NORTH);
        mainPanel.add(formPanel, BorderLayout.CENTER);

        JPanel footerPanel = new JPanel();
        footerPanel.setBackground(new Color(245, 247, 250));
        footerPanel.setPreferredSize(new Dimension(0, 50));

        JLabel forgotLabel = new JLabel("忘记密码？");
        forgotLabel.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
        forgotLabel.setForeground(new Color(76, 175, 80));
        forgotLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        footerPanel.add(forgotLabel);

        mainPanel.add(footerPanel, BorderLayout.SOUTH);

        add(mainPanel);
        setVisible(true);

        loginButton.addActionListener(e -> handleLogin());
        registerButton.addActionListener(e -> handleRegister());
    }

    private void handleLogin() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "请输入用户名和密码",
                "提示",
                JOptionPane.WARNING_MESSAGE);
            return;
        }

        currentUser = username;
        currentPassword = password;
        isLoggedIn = true;

        JOptionPane.showMessageDialog(this,
            "登录成功！\n用户名：" + username,
            "成功",
            JOptionPane.INFORMATION_MESSAGE);

        this.dispose();

        SwingUtilities.invokeLater(() -> new EmployeeManagerUI(username));
    }

    private void handleRegister() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "请输入用户名和密码",
                "提示",
                JOptionPane.WARNING_MESSAGE);
            return;
        }

        currentUser = username;
        currentPassword = password;
        isLoggedIn = true;

        JOptionPane.showMessageDialog(this,
            "注册成功！\n用户名：" + username,
            "成功",
            JOptionPane.INFORMATION_MESSAGE);

        this.dispose();

        SwingUtilities.invokeLater(() -> new EmployeeManagerUI(username));
    }

    public static String getCurrentUser() {
        return currentUser;
    }

    public static String getCurrentPassword() {
        return currentPassword;
    }

    public static boolean isLoggedIn() {
        return isLoggedIn;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new test());
    }
}
