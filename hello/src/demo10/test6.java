package demo10;

public class test6 {
    public static void main(String[] args) {
        account a1 = new account("张三", 1000);

        new drawthread("xm", a1).start();
        new drawthread("xh", a1).start();

        account a2 = new account("123", 1000);

        new drawthread("xa", a2).start();
        new drawthread("xb", a2).start();

    }
}

