package demo9;

import java.io.*;

public class test {
    private static final String src = "D:\\lesson\\作业图片\\0.png";
    private static final String dest = "D:\\lesson\\图片";

    public static void main(String[] args){
        copy();
        copy1();
        copy2();
        copy3();
    }

    public static void copy(){

        long start = System.currentTimeMillis();


        try (
                InputStream fis = new FileInputStream(src);
                OutputStream fos = new FileOutputStream(dest + "1.jpg");
        ) {
            int b;
            while ((b = fis.read()) != -1){
                fos.write(b);

            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        long end = System.currentTimeMillis();
        System.out.println("one" + (end - start)/1000.0);

    }

    public static void copy1(){
        long start = System.currentTimeMillis();
        try (
                InputStream fis = new FileInputStream(src);
                OutputStream fos = new FileOutputStream(dest + "2.jpg");
        ) {
            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) != -1){
                fos.write(buffer, 0, len);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        long end = System.currentTimeMillis();
        System.out.println("two" + (end - start)/1000.0);
    }

    public static void copy2(){
        long start = System.currentTimeMillis();
        try (
                InputStream fis = new FileInputStream(src);
                OutputStream fos = new FileOutputStream(dest + "3.jpg");
                BufferedInputStream bis = new BufferedInputStream(fis);
                BufferedOutputStream bos = new BufferedOutputStream(fos);
        ) {
            int b;
            while ((b = bis.read()) != -1){
                bos.write(b);

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        long end = System.currentTimeMillis();
        System.out.println("three" + (end - start)/1000.0);
    }

    public static void copy3(){
        long start = System.currentTimeMillis();
        try (
                InputStream fis = new FileInputStream(src);
                OutputStream fos = new FileOutputStream(dest + "4.jpg");
                BufferedInputStream bis = new BufferedInputStream(fis);
                BufferedOutputStream bos = new BufferedOutputStream(fos);
        ) {
            byte[] buffer = new byte[1024];
            int len;
            while ((len = bis.read(buffer)) != -1){
                bos.write(buffer, 0, len);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        long end = System.currentTimeMillis();
        System.out.println("four" + (end - start)/1000.0);
    }

}
