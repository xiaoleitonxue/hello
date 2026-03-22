package demo12.demo3;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;

public class framework {
    public static void save(Object obj) throws FileNotFoundException {
        PrintStream ps = new PrintStream(new FileOutputStream("D:\\lesson\\myproject\\hello\\hello\\src\\demo12\\demo3\\txt", true));

        Class c = obj.getClass();

        String simpleName = c.getSimpleName();
        System.out.println("=====================" + simpleName + "================================");

        Field[] fields = c.getDeclaredFields();
        for (Field f : fields) {
            f.setAccessible(true);
            try {
                ps.println(f.getName() + ":" + f.get(obj));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        ps.close();
    }
}
