package demo10;

public class test4{
    public static void main(String[] args) {
        //sleep方法
        for (int i = 0; i <= 10; i++) {
            System.out.println("主" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
