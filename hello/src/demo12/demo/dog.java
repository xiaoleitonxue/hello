package demo12.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class dog {
    private String name;
    private int age;

    public String eat(){
        System.out.println("234");
        return "吃吃吃";
    }

    public dog(String name) {
        this.name = name;
    }

    public dog(int age) {
        this.age = age;
    }

    public dog() {
    }

    public dog(String name, int age) {
        this.name = name;
        this.age = age;
    }


}
