package demo8;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class test {
    public static void main (String[] args) throws IOException {

        InputStream is = new FileInputStream("hello\\src\\demo8\\123");

        /*int b;
        while ((b = is.read()) != -1) {
            System.out.println((char)b);
            System.out.println(b);*/

        /*byte[] buffer = new byte[3];
        int len;
        while ((len = is.read(buffer)) != -1) {
            System.out.println(new String(buffer, 0, len));*/

        byte[] bytes = is.readAllBytes();
        System.out.println(new String(bytes));

        is.close();
    }
}
