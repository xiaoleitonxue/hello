package demo11.demo3;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TCPc {
    public static void main(String[] args) throws IOException {

        System.out.println("client start...");

        Socket socket = new Socket("172.22.194.217", 9999);

        OutputStream os = socket.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("请输入内容：");
            String s = sc.nextLine();
            if ("886".equals(s)){
                System.out.println("发送完毕");
                os.close();
                socket.close();
                break;
            }
            dos.writeUTF(s);
            dos.flush();
        }
    }
}
