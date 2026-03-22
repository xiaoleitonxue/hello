package demo12.demo1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class student {
    private String name;
    private int age;

    public student(String name){
        this.name = name;
    }

    public student(int age){
        this.age = age;
    }

}
