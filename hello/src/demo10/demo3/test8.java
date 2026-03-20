package demo10.demo3;

import java.util.concurrent.*;

public class test8 {
    public static void main(String[] args) {
        ExecutorService pool = new ThreadPoolExecutor(3, 5,
                10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        Runnable r = new myrunnable();
        pool.execute(r);
        pool.execute(r);
        pool.execute(r);

        pool.execute(r);
        pool.execute(r);

        pool.execute(r);
        pool.execute(r);
        pool.execute(r);

        pool.execute(r);

        //pool.shutdown();
        //pool.shutdownNow();

    }
}
