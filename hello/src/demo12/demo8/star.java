package demo12.demo8;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class star implements servise {
    private String name;

    public void sing(String name){
        System.out.println(this.name + "I'm singing" + name);
    }

    public String dance(){
        System.out.println(this.name + "I'm dancing");
        return "thanks";
    }

}
