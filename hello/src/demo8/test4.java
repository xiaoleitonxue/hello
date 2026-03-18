package demo8;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class test4 {
    public static void main(String[] args){

        try (
                Writer br = new FileWriter("hello\\src\\demo8\\123", true);
                BufferedWriter bw = new BufferedWriter(br);
        ) {
            bw.write('1');
            bw.write('a');
            //bw.write("\r\n");
            bw.newLine();

            bw.write(123);
            bw.write(56);
            bw.write('但');
            //bw.write("\r\n");
            bw.newLine();

            bw.write("1saa123d");
            bw.write("阿斯顿弄2阿瑟东13sjad");
            //bw.write("\r\n");
            bw.newLine();

            char[] aaa = "123asd阿迪斯".toCharArray();
            bw.write(aaa, 2, 5);
            bw.write("asd122阿瑟东13".toCharArray());
            //bw.write("\r\n");
            bw.newLine();

            bw.flush();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
