package demo;

import java.util.Scanner;

public class movieoprater {
    movie[] m = new movie[5];

    public movieoprater(movie[] m) {
        this.m = m;
    }

    public void print() {
        for (int i = 0; i < m.length; i++) {
            System.out.println(m[i].getName() + " " + m[i].getPrice() + " " + m[i].getActor() + " " + m[i].getType());
        }
    }

    public  void serch(){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要查询的影片名称：");
        String name = sc.next();
        boolean flag = false;
        for (int i = 0; i < m.length; i++) {
            if (m[i].getName().equals(name)) {
                flag = true;
                System.out.println(m[i].getName() + " " + m[i].getPrice() + " " + m[i].getActor() + " " + m[i].getType());
            }
        }
        if(!flag){
            System.out.println("没有找到");
        }
    }
}