package demo8;

import java.io.*;
import java.util.concurrent.CopyOnWriteArrayList;

/*public class test2 {
    public static void main(String[] args) {

        try {
            copyfile("D:\\lesson\\作业图片\\0.png", "D:\\lesson\\图片\\0-new.jpg");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void copyfile(String aaa, String bbb) throws IOException {

        InputStream fis = new FileInputStream(aaa);
        OutputStream fot = new FileOutputStream(bbb);

        byte[] buffer = new byte[1024];
        int len;
        while((len = fis.read(buffer))!= -1){
            fot.write(buffer, 0, len);
        }
        System.out.println("success");

        fis.close();
        fot.close();
    }
}*/


/*public class test2 {
    public static void main(String[] args) {

            copyfile("D:\\lesson\\作业图片\\0.png", "D:\\lesson\\图片\\0-new.jpg");

    }

    private static void copyfile(String aaa, String bbb)  {

        InputStream fis = null;
        OutputStream fot = null;
        try {
            fis = new FileInputStream(aaa);
            fot = new FileOutputStream(bbb);

            byte[] buffer = new byte[1024];
            int len;
            while((len = fis.read(buffer))!= -1){
                fot.write(buffer, 0, len);
            }
            System.out.println("success");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            if(fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if(fot != null) {
                try {
                    fot.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}*/


public class test2 {
    public static void main(String[] args) {

        copyfile("D:\\lesson\\作业图片\\0.png", "D:\\lesson\\图片\\0-new.jpg");

    }

    private static void copyfile(String aaa, String bbb)  {

        try(
            InputStream fis = new FileInputStream(aaa);
            OutputStream fot = new FileOutputStream(bbb);
            ) {

            byte[] buffer = new byte[1024];
            int len;
            while((len = fis.read(buffer))!= -1){
                fot.write(buffer, 0, len);
            }
            System.out.println("success");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}