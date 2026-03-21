package demo11.demo2;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPs {
    public static void main(String[] args) throws IOException {

        System.out.println("服务器启动了");

        ServerSocket serverSocket = new ServerSocket(9999);

        Socket socket = serverSocket.accept();

        InputStream is = socket.getInputStream();

        DataInputStream dis = new DataInputStream(is);

        System.out.println(dis.readInt());
        System.out.println(dis.readUTF());

        //ip 地址,端口号
        System.out.println(socket.getLocalAddress().getHostAddress() + ":" + socket.getLocalPort());

        socket.close();
    }
}
