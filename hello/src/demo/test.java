package demo;

import java.util.InputMismatchException;

public class test {
    public static void main(String[] args) {
        movie[] m = new movie[5];

        m[0] = new movie("1", 9.5, "罗宾·法拉利", "喜剧");
        m[1] = new movie("2", 9.5, "罗宾·法拉利", "喜剧");
        m[2] = new movie("33", 9.5, "罗宾·法拉利", "喜剧");
        m[3] = new movie("44", 9.5, "罗宾·法拉利", "喜剧");
        m[4] = new movie("55", 9.5, "罗宾·法拉利", "喜剧");

        movieoprater mo = new movieoprater(m);
        mo.print();
        mo.serch();
    }
}
