package demo1;

import java.util.Scanner;

public class ab {
    static Scanner sc = new Scanner(System.in);

    public static void aaa(){
        card goldcard = new goldcard();
        System.out.println("请输入充值金额：");
        goldcard.deposit(sc.nextDouble());

        System.out.println("请输入消费金额：");
        goldcard.consume(sc.nextDouble());
    }

    public static void bbb(){
        card silvercard = new silvercard();
        System.out.println("请输入充值金额：");
        silvercard.deposit(sc.nextDouble());

        System.out.println("请输入消费金额：");
        silvercard.consume(sc.nextDouble());
    }
}
