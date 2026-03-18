package demo8;

import java.io.*;

public class test1 {
    public static void main(String[] args) throws IOException {

        //OutputStream os = new FileOutputStream("hello\\src\\demo8\\123");
        OutputStream os = new FileOutputStream("hello\\src\\demo8\\123", true);
        BufferedOutputStream fos = new BufferedOutputStream(os);

        fos.write(97);
        fos.write('f');
        //fos.write('放');
        fos.write("\r\n".getBytes());

        byte[] bytes = "请问2问13".getBytes();
        fos.write(bytes);
        fos.write("\r\n".getBytes());

        fos.write(bytes, 0, 3);
        fos.write("\r\n".getBytes());

        fos.flush();
        fos.close();

        }
    }
