package demo10.practice;

import java.util.List;

public class getredpacket extends Thread {
    private List<Integer> list;

    public getredpacket(List<Integer> list, String name) {
        super(name);
        this.list = list;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        while (true) {
            if (list.size() == 0){
                break;
            }
            synchronized (list){
                int index = (int) (Math.random() * list.size());
                Integer money = list.remove(index);
                System.out.println(name + "抢到红包，金额为：" + money);
                if (list.size() == 0){
                    System.out.println(name + "抢完红包");
                    break;
                }
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
