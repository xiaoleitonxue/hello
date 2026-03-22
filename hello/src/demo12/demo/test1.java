package demo12.demo;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class test1 {

    @Test
    public void getClass1() {

        Class c1 = student.class;
        System.out.println(c1.getName());
        System.out.println(c1.getSimpleName());

    }

    @Test
    public void getconstructor() {

        Class c1 = dog.class;
        Constructor[] constructors = c1.getDeclaredConstructors();
        for (Constructor c : constructors) {
            System.out.println(c.getName() + c.getParameterCount());
        }

        System.out.println("------------------------------------------------");

        //Constructor constructors1 = c1.getDeclaredConstructors(String.class, int.class);
        //System.out.println(constructors1.getName() + constructors1.getParameterCount());

        try {
            Constructor constructor = c1.getDeclaredConstructor(String.class, int.class);
            System.out.println(constructor.getName() + " 参数个数：" + constructor.getParameterCount());
        } catch (NoSuchMethodException e) {
            System.out.println("未找到匹配的构造函数: " + e.getMessage());
        }

    }

    @Test
    public void getField() throws NoSuchFieldException {
        Class c1 = dog.class;
        Field[] fields = c1.getDeclaredFields();
        for (Field f : fields) {
            System.out.println(f.getName() + " " + f.getType());
        }
        System.out.println("------------------------------------------------");

        Field field = c1.getDeclaredField("name");
        System.out.println(field.getName() + " " + field.getType());

        System.out.println("------------------------------------------------");

        Field field1 = c1.getDeclaredField("age");
        System.out.println(field1.getName() + " " + field1.getType());
    }

    @Test
    public void getMethod() throws NoSuchMethodException {

        Class c1 = dog.class;
        Method[] methods = c1.getDeclaredMethods();

        for (Method m : methods) {
            System.out.println(m.getName() + " " + m.getReturnType());
            System.out.println("------------------------------------------------");
        }
        System.out.println("------------------------------------------------");
        Method method = c1.getDeclaredMethod("eat");
        //Method method = c1.getDeclaredMethod("eat", String.class);
        System.out.println(method.getName() + " " + method.getReturnType());
    }
}
