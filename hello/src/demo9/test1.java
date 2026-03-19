package demo9;

import java.io.*;

public class test1 {
    public static void main(String[] args) {
        try (
                //Reader read = new FileReader("hello\\src\\demo9\\txt");
                InputStream is = new FileInputStream("hello\\src\\demo9\\txt");
                Reader read = new InputStreamReader(is, "gbk");
                BufferedReader br = new BufferedReader(read);
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
