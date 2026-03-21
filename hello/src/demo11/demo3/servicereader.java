package demo11.demo3;

import java.io.*;
import java.net.Socket;

public class servicereader extends Thread {
    private Socket socket;
    public servicereader(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        InputStream is = null;
        try {
            is = socket.getInputStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        DataInputStream dis = new DataInputStream(is);

        try {
            while (true) {
                System.out.println(dis.readUTF());
                //ip 地址,端口号
                System.out.println(socket.getLocalAddress().getHostAddress() + ":" + socket.getLocalPort());
                System.out.println("--------------------------------------------");
            }
        } catch (IOException e) {
            System.out.println("连接断开");
        }
    }
}
