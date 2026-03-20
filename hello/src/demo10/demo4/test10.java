package demo10.demo4;

import demo10.demo3.mycallable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class test10 {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(3);

        Future<String> f1 = pool.submit(new mycallable(100));
        Future<String> f2 = pool.submit(new mycallable(200));
        Future<String> f3 = pool.submit(new mycallable(300));
        Future<String> f4 = pool.submit(new mycallable(400));
        Future<String> f5 = pool.submit(new mycallable(500));

        try {
            System.out.println(f1.get());
            System.out.println(f2.get());
            System.out.println(f3.get());
            System.out.println(f4.get());
            System.out.println(f5.get());
        } catch (Exception e) {
            e.printStackTrace();
        }

        pool.shutdown();
    }
}
