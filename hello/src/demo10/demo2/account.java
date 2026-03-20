package demo10.demo2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class account {
    private String name;
    private double money;
    private final Lock lk = new ReentrantLock();

    public account(String name, double money) {
        this.name = name;
        this.money = money;
    }

    public account() {
    }

    public void drawmoney(double money) {
        String name = Thread.currentThread().getName();

        lk.lock();

        try {
            if (this.money >= money) {
                System.out.println(name + "取钱成功，取钱金额为：" + money);
                this.money -= money;
                System.out.println(name + "取钱成功，余额为：" + this.money);
            } else {
                System.out.println(name + "取钱失败，余额不足");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            lk.unlock();
        }
    }


    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
