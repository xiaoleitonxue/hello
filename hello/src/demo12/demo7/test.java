package demo12.demo7;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class test {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {

        test ad = new test();

        Class c1 = test.class;

        Method[] methods = c1.getMethods();

        for (Method m : methods) {
            if (m.isAnnotationPresent(a.class)){
                a a1 = m.getDeclaredAnnotation(a.class);
                int count = a1.count();

                for (int i = 0; i < count; i++){
                    m.invoke(ad);
                }
            }
        }
    }
    @a
    public void test1(){
        System.out.println("test1");

    }

    public void test2(){
        System.out.println("test2");

    }

    @a(count = 5)
    public void test3(){
        System.out.println("test3");

    }

    @a
    public void test4(){
        System.out.println("test4");

    }
}
