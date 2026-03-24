package final_practice.demo2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        List<prisoner> list = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            int code = (int) (Math.random() * 200) + 1;
            if (isPrisoner(list, code)) {
                i--;
                continue;
            }
            prisoner p = new prisoner(code, i);
            list.add(p);
        }
        System.out.println(list);

        while(true){
            List<prisoner> list1 = new ArrayList<>();
            for (int i = 1; i < list.size(); i+=2) {
                list1.add(list.get(i));
            }
            if(list1.size() == 1){
                System.out.println(list1.get(0));
            }
            list = list1;
        }
    }

    public static boolean isPrisoner(List<prisoner> list, int code) {
        for (prisoner p : list) {
            if (p.getCode() == code) {
                return true;
            }
        }
        return false;
    }

}

@Data
@AllArgsConstructor
@NoArgsConstructor
class prisoner {
    private int code;
    private int id;
}