package demo12.demo6;

import org.junit.Test;

import java.lang.reflect.Method;
import java.util.Arrays;

public class test {
    @Test
    public void test1() {
        // 1. 获取类对象
        Class c1 = demo.class;
// 2、使用 isAnnotationPresent 判断这个类上是否陈列了注解 a
        if (c1.isAnnotationPresent(a.class)) {
            // 3、获取注解对象
            a a = (a) c1.getAnnotation(a.class);

            // 4、获取注解属性值
            String[] address = a.address();
            double height = a.price();
            String value = a.value();

            // 5、打印注解属性值
            System.out.println(Arrays.toString(address));
            System.out.println(height);
            System.out.println(value);
        }

    }

    @Test
    public void test2() throws NoSuchMethodException {
        Class c1 = demo.class;
        Method method = c1.getMethod("go");
        if (method.isAnnotationPresent(a.class)) {

            a a = method.getAnnotation(a.class);

            String[] address = a.address();
            double height = a.price();
            String value = a.value();

            System.out.println(Arrays.toString(address));
            System.out.println(height);
            System.out.println(value);
        }
    }
}
