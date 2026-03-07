package demo1;

public class goldcard extends card {
    private double price = 0;

    public goldcard() {
        super();
        System.out.println("您的信息是" + getName() + " " + getTelephone() + " " + getId() + " " + price);
    }

    public goldcard(String telephone, String name, double price, int id) {
        super(telephone, name, id);
        this.price = price;
        System.out.println("办理成功");
        System.out.println("您的信息是" + getName() + " " + getTelephone() + " " + getId() + " " + price);
    }
    public void deposit(double money) {
        if (money < 5000){
            System.out.println("充值金额不能小于5000");
            System.exit(0);
        }
        else{
            price += money;
            System.out.println("充值成功，您的余额为" + price);
        }
    }
    public void consume(double money) {
        double real_money = money * 0.8;
        if (real_money > price){
            System.out.println("余额不足，余额为" + price);
        }
        else{
            price -= real_money;
            System.out.println("消费成功，您的余额为" + price + "，实际支付" + real_money);
            if(real_money > 200){
                System.out.println("免费洗车票+服务");
            }
        }
    }
}
