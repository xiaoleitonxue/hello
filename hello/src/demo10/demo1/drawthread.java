package demo10.demo1;

public class drawthread extends Thread {
    private account a;

    public drawthread(String name, account a) {
        super(name);
        this.a = a;
    }

    @Override
    public void run() {
        a.drawmoney(1000);
    }
}
