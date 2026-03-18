package demo8;

import java.io.*;

public class test3 {
    public static void main(String[] args){
        try (
                Reader read = new FileReader("hello\\src\\demo8\\123");
                BufferedReader br = new BufferedReader(read);

        ) {
            /*char[] chars = new char[3];
            int len;
            while((len = read.read(chars)) != -1){
                System.out.println(new String(chars, 0, len));

            }*/

            System.out.println("------------------------------");

            //System.out.println(read.readAllLines());

            String line;
            while((line = br.readLine()) != null){
                System.out.println(line);
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
