package demo8;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class test1 {
    public static void main(String[] args) throws IOException {

        //OutputStream os = new FileOutputStream("hello\\src\\demo8\\123");
        OutputStream os = new FileOutputStream("hello\\src\\demo8\\123", true);

        os.write(97);
        os.write('f');
        //os.write('放');
        os.write("\r\n".getBytes());

        byte[] bytes = "请问2问13".getBytes();
        os.write(bytes);
        os.write("\r\n".getBytes());

        os.write(bytes, 0, 3);
        os.write("\r\n".getBytes());

        os.close();

        }
    }
