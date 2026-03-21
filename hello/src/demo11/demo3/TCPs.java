package demo11.demo3;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPs {
    public static void main(String[] args) throws IOException {

        System.out.println("服务器启动了");

        ServerSocket serverSocket = new ServerSocket(9999);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("一个客户端连接了:" +  socket.getInetAddress().getHostAddress());

            new servicereader(socket).start();
        }
    }
}
