package demo12.demo2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

public class test {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ArrayList<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        list.add("java");
        list.add("hello");

        Class c1 = list.getClass();
        Method add = c1.getDeclaredMethod("add", Object.class);
        add.invoke(list, 9.9);
        add.invoke(list, true);

        System.out.println(list);
    }
}
