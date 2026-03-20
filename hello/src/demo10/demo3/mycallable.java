package demo10.demo3;

import java.util.concurrent.Callable;

public class mycallable implements Callable<String> {
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
        return n + "sum = " + sum;
    }
}

