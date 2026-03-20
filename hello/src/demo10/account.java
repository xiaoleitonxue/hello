package demo10;

public class account {
    private String name;
    private double money;

    public account(String name, double money) {
        this.name = name;
        this.money = money;
    }

    public account() {
    }

    public void drawmoney(double money){
        String name = Thread.currentThread().getName();
        /*if (this.money >= money){
            System.out.println(name + "取钱成功，取钱金额为：" + money);
            this.money -= money;
            System.out.println(name + "取钱成功，余额为：" + this.money);
        }else {
            System.out.println(name + "取钱失败，余额不足");
        }*/

        synchronized (this /*静态方法用account.class*/) {
            if (this.money >= money){
                System.out.println(name + "取钱成功，取钱金额为：" + money);
                this.money -= money;
                System.out.println(name + "取钱成功，余额为：" + this.money);
            }else {
                System.out.println(name + "取钱失败，余额不足");
            }
        }

    }

    /*public synchronized void drawmoney(double money){
        String name = Thread.currentThread().getName();
        if (this.money >= money){
            System.out.println(name + "取钱成功，取钱金额为：" + money);
            this.money -= money;
            System.out.println(name + "取钱成功，余额为：" + this.money);
        }else {
            System.out.println(name + "取钱失败，余额不足");
        }*/


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
