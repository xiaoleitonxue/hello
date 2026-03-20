package demo10.demo;

import demo10.account;
import demo10.drawthread;

public class test6 {
    public static void main(String[] args) {
        demo10.account a1 = new demo10.account("张三", 1000);

        new demo10.drawthread("xm", a1).start();
        new demo10.drawthread("xh", a1).start();

        demo10.account a2 = new account("123", 1000);

        new demo10.drawthread("xa", a2).start();
        new drawthread("xb", a2).start();

    }
}

