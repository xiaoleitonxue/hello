package demo11.demo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPs {
    public static void main(String[] args) throws IOException {
        System.out.println("启动服务端");

        DatagramSocket ds = new DatagramSocket(8080);
        byte[] butes = new byte[1024 * 64];
        DatagramPacket dp = new DatagramPacket(butes, butes.length);

        ds.receive(dp);
        System.out.println("收到数据：" + new String(dp.getData(), 0, dp.getLength()));

        String ip = dp.getAddress().getHostAddress();
        int port = dp.getPort();
        System.out.println("来自" + ip + ":" + port);

    }
}
