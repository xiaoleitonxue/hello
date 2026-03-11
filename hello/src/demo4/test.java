package demo4;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        System.out.println("电影信息管理系统");
        List<movie> movies = new ArrayList<>();
        movies.add(new movie("唐顿庄园", 9.5, "Tim Allen", 20));
        movies.add(new movie("唐顿庄园2", 9.5, "Tim Allen", 20));
        movies.add(new movie("唐顿庄园3", 9.5, "Tim Allen", 20));
        movies.add(new movie("唐顿庄园4", 9.5, "Tim Allen", 20));
        System.out.println(movies);

        movieServise ms = new movieServise(movies);
        ms.start();
        System.out.println(movies);
    }
}
