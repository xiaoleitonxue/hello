package final_practice.demo3;

import lombok.Data;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test {
    public static void main(String[] args) {
        String info = "10001，张无忌，男，2023-07-22 11:11:12，东湖 - 黄鹤楼#10002，赵敏，女，2023-07-22 09:11:21，黄鹤楼 - 归元禅寺#10003，周芷若，女，2023-07-22 04:11:21，木兰文化区 - 东湖#10004，小昭，女，2023-07-22 08:11:21，东湖#10005，灭绝，女，2023-07-22 17:11:21，归元禅寺";
        List<student> students = parseStudents(info);
        Map<String, Integer> map = selectcount(students);

        String max = getmax(map);
        //统计哪些人没选择最多的地点
        notmax(map, 3);
        //统计哪些人没有选择这个最多人想去的景点
        notmax1(max, students);

    }

    private static void notmax1(String maxAddress, List<student> students) {
        for (student student : students) {
            String[] addresss = student.getAddress().split(" - ");
            boolean hasMaxAddress = false;
            for (String address : addresss) {
                if (address.equals(maxAddress)) {
                    hasMaxAddress = true;
                    break;
                }
            }
            if (!hasMaxAddress) {
                System.out.println(student.getName() + " 没选择 " + maxAddress);
            }
        }
    }

    private static void notmax(Map<String, Integer> map, Integer max) {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() < max) {
                System.out.println(entry.getKey());
            }
        }
    }

    private static String getmax(Map<String, Integer> map) {
        String max = "";
        int maxcount = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxcount) {
                max = entry.getKey();
                maxcount = entry.getValue();
            }
        }
        System.out.println(max + ":" + maxcount);
        return max;
    }

    public static Map<String, Integer> selectcount(List<student> students) {
        Map<String, Integer> counts = new HashMap<>();
        for (student student : students) {
            String address = student.getAddress();
            String[] addresss = address.split(" - ");
            for (String address1 : addresss) {
                if (counts.containsKey(address1)) {
                    counts.put(address1, counts.get(address1) + 1);
                } else {
                    counts.put(address1, 1);
                }
            }
        }
        System.out.println(counts);
        return counts;
    }

    private static List<student> parseStudents(String info) {
        String[] studentinfo = info.split("#");
        List<student> students = new ArrayList<>();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        for (String s : studentinfo) {
            String[] info1 = s.split("，");
            String time = info1[3];
            student student = new student();
            student.setId(info1[0]);
            student.setName(info1[1]);
            student.setSex(info1[2]);
            student.setLocaldatatime(time);
            student.setAddress(info1[4]);
            students.add(student);
            System.out.println(student);

        }
        return students;
    }

}


@Data
class student {
    private String id;
    private String name;
    private String sex;
    private String localdatatime;
    private String address;

}