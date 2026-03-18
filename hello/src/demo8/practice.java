package demo8;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class practice {
    public static void main(String[] args){
        try (
                BufferedReader br = new BufferedReader(new FileReader("hello\\src\\demo8\\txt"));

                BufferedWriter bw = new BufferedWriter(new FileWriter("hello\\src\\demo8\\txt2"));

        ) {
            List<String> data = new ArrayList<>();

            String line;
            while((line = br.readLine()) != null){
                data.add(line);
            }

            Collections.sort(data, ((o1, o2) -> o1.charAt(0) - o2.charAt(0)));

            System.out.println(data);

            for (String s : data){
                bw.write(s);
                bw.newLine();
            }

            System.out.println("处理成功");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
