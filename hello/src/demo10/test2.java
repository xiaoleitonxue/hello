package demo10;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class test2 {
    public static void main(String[] args){
        Callable<String> c = new mycallable(100);
        FutureTask<String> ft = new FutureTask<>(c);
        Thread t = new Thread(ft);
        t.start();

        Callable<String> c1 = new mycallable(50);
        FutureTask<String> ft1 = new FutureTask<>(c1);
        Thread t1 = new Thread(ft1);
        t1.start();

        try {
            System.out.println(ft.get());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            System.out.println(ft1.get());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

class mycallable implements Callable<String> {
    private int n;
    public mycallable(int n){
        this.n = n;
    }
    @Override
    public String call() throws Exception {
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += i;
        }
        return "sum = " + sum;
    }
}
