package demo10.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class test {
    public static void main(String[] args) {
        List<Integer> list = get();

        for (int i = 1; i <= 100; i++) {
            new getredpacket(list, "人" + i).start();
        }

    }

    public static List<Integer> get(){
        Random r = new Random();

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 160; i++) {
            int money = (int)(r.nextInt(30) + 1);
            list.add(money);
        }
        for (int i = 0; i < 40; i++) {
            int money = (int)(r.nextInt(70) + 31);
            list.add(money);
        }

        return list;
    }
}
