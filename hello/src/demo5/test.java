package demo5;

import java.util.*;

public class test {
    public static void main(String[] args) {
        colc();
    }

    private static void colc() {
        List<String> list = new ArrayList<>();
        String[] names = {"张三", "李四", "王五", "赵六"};
        Random r = new Random();
        for (int i = 0; i <= 80; i++) {
            int index = r.nextInt(names.length);
            list.add(names[index]);
        }
        System.out.println(list);
        Map<String, Integer> map = new HashMap<>();
        for (String name : list) {
            /*if (map.containsKey(name)) {
                map.put(name, map.get(name) + 1);
            } else {
                map.put(name, 1);
            }*/
            map.put(name, map.containsKey(name) ? map.get(name) + 1 : 1);
        }

        /*System.out.println(map);*/
        map.forEach((name, count) -> System.out.println(name + ":" + count));
    }
}
