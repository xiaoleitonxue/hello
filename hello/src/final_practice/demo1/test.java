package final_practice.demo1;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class test {
    public static void main(String[] args) {
        TreeSet<Integer> red = new TreeSet<>();
        while(red.size() < 6){
            red.add((int)(Math.random() * 35 + 1));
        }
        System.out.println(red);

        int blue = (int)(Math.random() * 15 + 1);
        System.out.println(blue);

        Set<Integer> luckeyred = new TreeSet<>();
        Collections.addAll(luckeyred, 10, 12, 30, 16, 7, 17);

        int coount = 0;
        for (Integer num : red) {
            if (luckeyred.contains(num)) {
                coount++;
            }
        }
        System.out.println("中奖个数：" + coount);

        int luckeyblue = 12;
        System.out.println("中奖蓝球：" + (luckeyblue == blue ? "1" : "0"));
    }
}
