package demo12.demo1;

import demo12.demo.student;

public class test {
    public static void main(String[] args) throws ClassNotFoundException {
        Class c1 = student.class;
        System.out.println(c1);

        Class c2 = Class.forName("demo12.demo.student");
        System.out.println(c2);

        System.out.println(c1 == c2);

        student s1 = new student();
        Class c3 = s1.getClass();
        System.out.println(c3);

        System.out.println(c1 == c3);

    }
}
