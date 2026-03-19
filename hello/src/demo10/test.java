package demo10;

public class test {
    public static void main(String[] args) {
        mythread a = new mythread();
        a.start();
        //a.run();

        for (int i = 0; i < 5; i++) {
            System.out.println("主线程" + i);
        }

    }
}

class mythread extends Thread {
    @Override
    public void run(){
        for (int i = 0; i < 5; i++) {
            System.out.println("子线程" + i);
        }
    }
}
