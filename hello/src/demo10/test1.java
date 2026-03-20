package demo10;

/*public class test1 {
    public static void main(String[] args){

        Runnable r = new myrunnable();

        Thread t1 = new Thread(r);
        t1.start();

        for (int i = 0; i < 5; i++) {
            System.out.println("主线程" + i);
        }
    }

}

class myrunnable implements Runnable{
    @Override
    public void run(){
        for (int i = 0; i < 5; i++) {
            System.out.println("子线程" + i);
        }
    }
}*/

public class test1 {
    public static void main(String[] args) {

        Runnable r = new Runnable(){
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("子线程1 " + i);
                }
            }
        };

        Thread t1 = new Thread(r);
        t1.start();

        //-------------------

        new Thread(new Runnable(){
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("子线程2 " + i);
                }
            }
        }).start();

        //---------------------


        new Thread(() -> {
                for (int i = 0; i < 5; i++) {
                    System.out.println("子线程3 " + i);
                }
        }).start();


        for (int i = 0; i < 5; i++) {
            System.out.println("主线程1 " + i);
        }
    }

}
