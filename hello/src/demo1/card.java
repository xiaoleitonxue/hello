package demo1;

import java.util.Scanner;

public class card {
    private String name;
    private String telephone;
    private double price;
    private int id;

    Scanner sc = new Scanner(System.in);

    public card() {
        System.out.println("name:");
        this.name = sc.next();
        System.out.println("telephone:");
        this.telephone = sc.next();
        System.out.println("id:");
        this.id = sc.nextInt();
        System.out.println("办理成功");
    }

    public card(String telephone, String name, int id) {
        this.telephone = telephone;
        this.name = name;
        this.id = id;
    }

    public void deposit(double money) {
        System.out.println("请输入存款金额");
    }

    public void consume(double money) {
        System.out.println("请输入消费金额:");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

