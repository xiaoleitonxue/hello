package demo10;

public class test3 {
    public static void main(String[] args) {
        Thread a1 = new mythread1("子线程1");
        //a1.setName("子线程1");
        a1.start();
        System.out.println(a1.getName());
        //a.run();

        Thread a2 = new mythread1("子线程2");
        //a2.setName("子线程2");
        a2.start();
        System.out.println(a2.getName());

        Thread m = Thread.currentThread();
        m.setName("主线程");
        System.out.println(m.getName());

        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + "主线程" + i);
        }

    }
}

class mythread1 extends Thread {
    public mythread1(String name) {
        super(name);
    }
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println( Thread.currentThread().getName() + "子线程" + i);
        }
    }
}
