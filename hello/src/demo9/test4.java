package demo9;

import java.io.*;

public class test4 {
    public static void main(String[] args) {
        try (
                DataOutputStream dos = new DataOutputStream(new FileOutputStream("hello\\src\\demo9\\txt2"));
                DataInputStream dis = new DataInputStream(new FileInputStream("hello\\src\\demo9\\txt2"));
        ) {
            dos.writeInt(34);
            dos.writeChar('s');
            dos.writeUTF("三大法5");
            dos.writeUTF("123dsa");
            dos.writeUTF("\n");
            dos.writeUTF("阿发是的");
            dos.writeUTF("123dsa");
            dos.writeUTF("\r\n");
            dos.writeUTF("123dsa");

            System.out.println(dis.readInt());
            System.out.println(dis.readChar());
            System.out.println(dis.readUTF());
            System.out.println(dis.readUTF());
            System.out.println(dis.readUTF());
            System.out.println(dis.readUTF());
            System.out.println(dis.readUTF());
            System.out.println(dis.readUTF());
            System.out.println(dis.readUTF());


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
