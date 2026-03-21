package demo11.demo2;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class TCPc {
    public static void main(String[] args) throws IOException {

        System.out.println("client start...");

        Socket socket = new Socket("172.22.194.217", 9999);

        OutputStream os = socket.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);
        dos.writeInt(1);
        dos.writeUTF("hello, server");

        socket.close();
    }
}
