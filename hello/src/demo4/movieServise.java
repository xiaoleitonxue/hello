package demo4;

import javax.swing.*;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class movieServise {

    private List<movie> movies;
    Scanner sc = new Scanner(System.in);

    public movieServise(List<movie> movies) {
        this.movies = movies;
    }

    public void start() {
        System.out.println("电影信息操作系统");
        System.out.println("1.上架");
        System.out.println("2.下架");
        System.out.println("3.查询");
        System.out.println("4.删除sb");

        while (true) {
            System.out.println("输入命令");
            String cmd = sc.next();
            switch (cmd) {
                case "1":
                    add();
                    break;
                case "2":
                    remove();
                    break;
                case "3":
                    serch();
                    break;
                case "4":
                    delete();
                    break;
                case "5":
                    System.out.println("退出系统");
                    return;
                default:
                    System.out.println("命令错误");
            }
        }


    }


    private void delete() {
        System.out.println("请输入要删除的actor");
        String index = sc.next();
        boolean found = false;
        /*for (int i = 0; i < movies.size(); i++){
            if (movies.get(i).getActor().contains(index)) {
                movies.remove(i);
                found = true;
                System.out.println("删除成功：" + index);
                i--;
            }
           }*/
        Iterator<movie> it = movies.iterator();
        while (it.hasNext()) {
            movie movie = it.next();
            if (movie.getActor().contains(index)) {
                it.remove();
                found = true;
                System.out.println("删除成功：" + index);
            }
        }

        if (!found) {
            System.out.println("没有此演员：" + index);
        }
    }

    private void serch() {
        System.out.println("请输入要查询的编号");
        String index = sc.next();
        sm(index);
    }

    private void sm(String index) {
        for (movie movie : movies) {
            if (movie.getName().equals(index)) {
                System.out.println(movie.getName() + " " + movie.getScore() + " " + movie.getActor() + " " + movie.getPrice());
            }
        }
    }

    private void remove() {
        System.out.println("请输入要删除的编号");
        String index = sc.next();
        boolean found = false;
        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).getName().equals(index)) {
                movies.remove(i);
                found = true;
                System.out.println("下架成功：" + index);
                break;
            }
        }
        if (!found) {
            System.out.println("没有此电影：" + index);
        }
    }

    private void add() {
        System.out.println("请输入电影名称");
        String name = sc.next();
        System.out.println("请输入电影评分");
        double score = sc.nextDouble();
        System.out.println("请输入主演");
        String actor = sc.next();
        System.out.println("请输入价格");
        double price = sc.nextDouble();
        System.out.println(movies.add(new movie(name, score, actor, price)));
    }

}
