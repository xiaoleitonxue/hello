package demo7;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class test {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String name = "af发送1423";
        byte[] bytes = name.getBytes("gbk");
        System.out.println(bytes.length);
        System.out.println(Arrays.toString(bytes));

        String name2 = new String(bytes, "gbk");
        System.out.println(name2);
    }
}