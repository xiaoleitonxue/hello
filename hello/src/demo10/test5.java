package demo10;

public class test5 {
    public static void main(String[] args) {
        //join方法
        mythread2 t1 = new mythread2();
        t1.start();

        for (int i = 0; i < 5; i++) {
            System.out.println("主线程" + i);
            if (i == 1){
                try {
                    t1.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
}

class mythread2 extends Thread {
    public mythread2() {
        super("子线程");
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + "子线程" + i);
        }
    }
}
