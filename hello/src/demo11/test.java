package demo11;

import java.net.InetAddress;

public class test {
    public static void main(String[] args) {
        InetAddress a = null;
        try {
            a = InetAddress.getLocalHost();
            System.out.println(a);
            System.out.println(a.getHostName());
            System.out.println(a.getHostAddress());

            InetAddress b = InetAddress.getByName("www.baidu.com");
            System.out.println(b);
            System.out.println(b.getHostName());
            System.out.println(b.getHostAddress());

            InetAddress[] c = InetAddress.getAllByName("www.baidu.com");
            for (InetAddress inetAddress : c) {
                System.out.println(inetAddress);
            }

            System.out.println(b.isReachable(5000));

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
