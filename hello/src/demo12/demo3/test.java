package demo12.demo3;

import java.io.FileNotFoundException;

public class test {
    public static void main(String[] args) throws FileNotFoundException {

        teacher t1 = new teacher("张三", 18, "男", "教师", "教师", "2019-01-01");
        framework.save(t1);

        teacher t2 = new teacher("李四", 25, "女", "讲师", "教学", "2020-09-01");
        framework.save(t2);


    }
}
