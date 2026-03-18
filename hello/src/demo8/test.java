package demo8;

import java.io.*;

public class test {
    public static void main (String[] args) throws IOException {

        InputStream is = new FileInputStream("hello\\src\\demo8\\123");
        BufferedInputStream fis = new BufferedInputStream(is);

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

        //is.flush();//flush() 只用于输出流（Output Stream）
        is.close();
    }
}
