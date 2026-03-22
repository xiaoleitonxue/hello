package com.it;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;

public class ChatServer {
    private static final int PORT = 8888;
    private static final Map<String, PrintWriter> clientWriters = new ConcurrentHashMap<>();
    private static final Set<String> onlineUsers = ConcurrentHashMap.newKeySet();

    public static void main(String[] args) {
        System.out.println("聊天服务器启动，端口：" + PORT);

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                new Thread(new ClientHandler(clientSocket)).start();
            }
        } catch (IOException e) {
            System.err.println("服务器异常：" + e.getMessage());
        }
    }

    static class ClientHandler implements Runnable {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;
        private String nickname;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    String[] parts = inputLine.split(":", 2);
                    String command = parts[0];

                    switch (command) {
                        case "LOGIN":
                            handleLogin(parts[1]);
                            break;
                        case "MESSAGE":
                            handleMessage(parts[1]);
                            break;
                        case "LOGOUT":
                            handleLogout();
                            break;
                    }
                }
            } catch (IOException e) {
                if (nickname != null) {
                    handleLogout();
                }
            } finally {
                closeConnection();
            }
        }

        private void handleLogin(String nick) {
            this.nickname = nick;
            clientWriters.put(nick, out);
            onlineUsers.add(nick);

            broadcastUserList();
            broadcastSystemMessage(nick + " 已上线");
        }

        private void handleMessage(String message) {
            broadcastMessage(nickname, message);
        }

        private void handleLogout() {
            if (nickname != null) {
                clientWriters.remove(nickname);
                onlineUsers.remove(nickname);
                broadcastUserList();
                broadcastSystemMessage(nickname + " 已下线");
            }
        }

        private void broadcastMessage(String from, String message) {
            for (PrintWriter writer : clientWriters.values()) {
                writer.println("MESSAGE:" + from + ":" + message);
            }
        }

        private void broadcastSystemMessage(String message) {
            for (PrintWriter writer : clientWriters.values()) {
                writer.println("SYSTEM:" + message);
            }
        }

        private void broadcastUserList() {
            StringBuilder userList = new StringBuilder("USERLIST:");
            userList.append(String.join(",", onlineUsers));

            for (PrintWriter writer : clientWriters.values()) {
                writer.println(userList);
            }
        }

        private void closeConnection() {
            try {
                if (socket != null && !socket.isClosed()) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
