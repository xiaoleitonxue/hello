package demo9;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;

public class test2 {
    public static void main(String[] args) {
        try (
                //PrintStream ps = new PrintStream("hello\\src\\demo9\\txt1");
                //PrintWriter ps = new PrintWriter("hello\\src\\demo9\\txt1");
                PrintWriter ps = new PrintWriter(new FileOutputStream("hello\\src\\demo9\\txt1", true));

        ) {
            ps.println(34);
            ps.println('s');
            ps.println("三大法5");
            ps.println("123dsa");
            ps.println("\n");
            ps.println(32);
            ps.println("\r\n");
            ps.println("阿发是的");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
