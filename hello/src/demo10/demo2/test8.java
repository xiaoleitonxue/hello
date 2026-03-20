package demo10.demo2;

import demo10.demo1.account;
import demo10.demo1.drawthread;

public class test8 {
    public static void main(String[] args) {
        demo10.demo1.account a1 = new account("张三", 1000);

        new demo10.demo1.drawthread("xm", a1).start();
        new drawthread("xh", a1).start();
    }
}
