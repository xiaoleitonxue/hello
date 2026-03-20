package demo11.demo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPc {
    public static void main(String[] args) throws IOException {

        System.out.println("发送端启动中...");

        DatagramSocket ds = new DatagramSocket();
        byte[] butes = "123,12352,63,314,36".getBytes();
        DatagramPacket dp = new DatagramPacket(butes, butes.length,
                InetAddress.getLocalHost(), 8080);

        ds.send(dp);


    }
}
