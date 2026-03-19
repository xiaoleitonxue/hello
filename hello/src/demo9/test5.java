package demo9;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class test5 {
    public static void main() throws IOException {

        FileUtils.copyFile(new File("hello\\src\\demo9\\txt"),new File("hello\\src\\demo9\\txt3"));

        //Files.copy(Path.of("hello\\src\\demo9\\txt"), Path.of("hello\\src\\demo9\\txt4"));

        //FileUtils.deleteDirectory(new File("hello\\src\\demo9\\txt3"));

    }
}
