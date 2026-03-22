package com.it;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.*;
import java.awt.event.*;

public class ChatRoomUI extends JFrame {
    private String nickname;
    private String serverAddress;
    private int serverPort;
    private JTextArea messageArea;
    private JTextField messageField;
    private JButton sendButton;
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private JList<String> onlineUserList;
    private DefaultListModel<String> listModel;
    private boolean connected = false;

    public ChatRoomUI(String nickname, String serverAddress, int serverPort) {
        this.nickname = nickname;
        this.serverAddress = serverAddress;
        this.serverPort = serverPort;
        setTitle("局域网聊天室 - " + nickname);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        initComponents();
        connectToServer();
    }

    private void initComponents() {
        listModel = new DefaultListModel<>();
        onlineUserList = new JList<>(listModel);
        onlineUserList.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        JScrollPane userListScrollPane = new JScrollPane(onlineUserList);
        userListScrollPane.setPreferredSize(new Dimension(150, 0));

        messageArea = new JTextArea();
        messageArea.setEditable(false);
        messageArea.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        messageArea.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(messageArea);

        messageField = new JTextField();
        messageField.setFont(new Font("微软雅黑", Font.PLAIN, 14));

        sendButton = new JButton("发送");
        sendButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        sendButton.setPreferredSize(new Dimension(80, 40));

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());
        inputPanel.add(messageField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());
        centerPanel.add(scrollPane, BorderLayout.CENTER);
        centerPanel.add(inputPanel, BorderLayout.SOUTH);

        JSplitPane mainSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, centerPanel, userListScrollPane);
        mainSplitPane.setDividerLocation(650);
        mainSplitPane.setOneTouchExpandable(true);

        setContentPane(mainSplitPane);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                onExit();
            }
        });

        sendButton.addActionListener(e -> sendMessage());
        messageField.addActionListener(e -> sendMessage());
    }

    private void connectToServer() {
        new Thread(() -> {
            try {
                socket = new Socket(serverAddress, serverPort);
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                connected = true;
                out.println("LOGIN:" + nickname);

                SwingUtilities.invokeLater(() ->
                    messageArea.append("已连接到服务器...\n")
                );

                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    String[] parts = inputLine.split(":", 3);
                    String command = parts[0];

                    SwingUtilities.invokeLater(() -> {
                        switch (command) {
                            case "MESSAGE":
                                messageArea.append(parts[1] + ": " + parts[2] + "\n");
                                messageArea.setCaretPosition(messageArea.getDocument().getLength());
                                break;
                            case "SYSTEM":
                                messageArea.append("[系统] " + parts[1] + "\n");
                                messageArea.setCaretPosition(messageArea.getDocument().getLength());
                                break;
                            case "USERLIST":
                                updateOnlineUsers(parts[1]);
                                break;
                        }
                    });
                }
            } catch (IOException e) {
                SwingUtilities.invokeLater(() -> {
                    messageArea.append("服务器连接断开：" + e.getMessage() + "\n");
                    connected = false;
                });
            }
        }).start();
    }

    private void updateOnlineUsers(String userListString) {
        listModel.clear();
        if (userListString != null && !userListString.isEmpty()) {
            String[] users = userListString.split(",");
            for (String user : users) {
                if (!user.trim().isEmpty()) {
                    listModel.addElement(user.trim());
                }
            }
        }
    }

    private void sendMessage() {
        String message = messageField.getText().trim();
        if (message.isEmpty() || !connected) {
            return;
        }

        if (out != null) {
            out.println("MESSAGE:" + message);
            messageField.setText("");
        }
    }

    private void onExit() {
        int result = JOptionPane.showConfirmDialog(this,
            "确定要退出聊天室吗？",
            "确认",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);

        if (result == JOptionPane.YES_OPTION) {
            if (out != null && connected) {
                out.println("LOGOUT:");
            }
            closeConnection();
            System.exit(0);
        }
    }

    private void closeConnection() {
        try {
            if (in != null) in.close();
            if (out != null) out.close();
            if (socket != null && !socket.isClosed()) socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        connected = false;
    }
}
