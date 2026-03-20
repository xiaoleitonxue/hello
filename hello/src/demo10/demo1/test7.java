package demo10.demo1;

public class test7 {
    public static void main(String[] args) {
        account a1 = new account("张三", 1000);

        new drawthread("xm", a1).start();
        new drawthread("xh", a1).start();
    }
}
