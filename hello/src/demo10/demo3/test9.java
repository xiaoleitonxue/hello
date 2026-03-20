package demo10.demo3;

import java.util.concurrent.*;

public class test9 {
    public static void main(String[] args) {
        ExecutorService pool = new ThreadPoolExecutor(3, 5,
                10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

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
