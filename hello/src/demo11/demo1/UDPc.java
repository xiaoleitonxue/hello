package demo11.demo1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPc {
    public static void main(String[] args) throws IOException {

        System.out.println("发送端启动中...");

        DatagramSocket ds = new DatagramSocket();

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("请输入要发送的内容：");
            String s = sc.nextLine();

            if ("886".equals(s)){
                System.out.println("发送完毕");
                ds.close();
                break;
            }

            byte[] butes = s.getBytes();

            DatagramPacket dp = new DatagramPacket(butes, butes.length,
                    InetAddress.getLocalHost(), 8080);

            ds.send(dp);
        }


    }
}
