package com.it;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.*;

public class ChatEntryFrame extends JFrame {
    private JTextField nicknameField;
    private JButton enterButton;
    private JButton cancelButton;
    private JTextField serverAddressField;
    private JSpinner serverPortSpinner;

    public ChatEntryFrame() {
        setTitle("局域网聊天室 - 登录");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 320);
        setLocationRelativeTo(null);
        setResizable(false);

        initComponents();
    }

    private void initComponents() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(8, 10, 8, 10);

        JLabel titleLabel = new JLabel("欢迎进入局域网聊天室", SwingConstants.CENTER);
        titleLabel.setFont(new Font("微软雅黑", Font.BOLD, 20));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(titleLabel, gbc);

        JLabel serverLabel = new JLabel("服务器地址：");
        serverLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        mainPanel.add(serverLabel, gbc);

        serverAddressField = new JTextField("127.0.0.1");
        serverAddressField.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        serverAddressField.setPreferredSize(new Dimension(200, 30));
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        mainPanel.add(serverAddressField, gbc);

        JLabel portLabel = new JLabel("端口：");
        portLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        mainPanel.add(portLabel, gbc);

        serverPortSpinner = new JSpinner(new SpinnerNumberModel(8888, 1, 65535, 1));
        serverPortSpinner.setPreferredSize(new Dimension(100, 30));
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        mainPanel.add(serverPortSpinner, gbc);

        JLabel nicknameLabel = new JLabel("昵称：");
        nicknameLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
        mainPanel.add(nicknameLabel, gbc);

        nicknameField = new JTextField(20);
        nicknameField.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        nicknameField.setPreferredSize(new Dimension(200, 30));
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        mainPanel.add(nicknameField, gbc);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 0));

        enterButton = new JButton("进入");
        enterButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        enterButton.setPreferredSize(new Dimension(80, 35));

        cancelButton = new JButton("取消");
        cancelButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        cancelButton.setPreferredSize(new Dimension(80, 35));

        buttonPanel.add(enterButton);
        buttonPanel.add(cancelButton);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(buttonPanel, gbc);

        add(mainPanel);

        enterButton.addActionListener(e -> onEnter());
        cancelButton.addActionListener(e -> onCancel());
        nicknameField.addActionListener(e -> onEnter());

        getRootPane().setDefaultButton(enterButton);
    }

    private void onEnter() {
        String nickname = nicknameField.getText().trim();
        String serverAddress = serverAddressField.getText().trim();
        int port = (int) serverPortSpinner.getValue();

        if (nickname.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "请输入昵称！",
                    "提示",
                    JOptionPane.WARNING_MESSAGE);
            nicknameField.requestFocus();
            return;
        }

        if (serverAddress.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "请输入服务器地址！",
                    "提示",
                    JOptionPane.WARNING_MESSAGE);
            serverAddressField.requestFocus();
            return;
        }

        if (testConnection(serverAddress, port)) {
            dispose();
            openChatRoom(nickname, serverAddress, port);
        } else {
            JOptionPane.showMessageDialog(this,
                    "无法连接到服务器，请检查服务器是否启动！",
                    "连接失败",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean testConnection(String address, int port) {
        try (Socket socket = new Socket()) {
            socket.connect(new InetSocketAddress(address, port), 3000);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    private void onCancel() {
        int result = JOptionPane.showConfirmDialog(this,
                "确定要退出吗？",
                "确认",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (result == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    private void openChatRoom(String nickname, String serverAddress, int port) {
        ChatRoomUI chatRoom = new ChatRoomUI(nickname, serverAddress, port);
        chatRoom.setVisible(true);
    }
}
