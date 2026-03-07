package demo1;

import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要办理的card：");
        String card_type = sc.next();


        if (card_type.equals("gold")) {
            ab.aaa();
        }
        else if (card_type.equals("silver")) {
            ab.bbb();
        }
        else {
            System.out.println("输入错误");
        }


    }
}
