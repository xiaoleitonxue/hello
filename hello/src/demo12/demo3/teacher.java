package demo12.demo3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class teacher {
    private String name;
    private int age;
    private String sex;
    private String job;
    private String work;
    private String workTime;

}
