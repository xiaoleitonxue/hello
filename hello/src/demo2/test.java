package demo2;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {

        jd[] jds = new jd[3];
        jds[0] = new tv("电视", true);
        jds[1] = new washmashine("洗衣机", true);
        jds[2] = new air("空调", true);

        control1 c = control1.getInstance();
        while (true) {
            control1.print(jds);
            System.out.println("选择控制家电");
            Scanner sc = new Scanner(System.in);
            switch (sc.nextInt()){
                case 1:
                    c.control(jds[0]);
                    break;
                case 2:
                    c.control(jds[1]);
                    break;
                case 3:
                    c.control(jds[2]);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("输入错误");
            }
        }

    }
}
