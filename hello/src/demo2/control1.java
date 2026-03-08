package demo2;

public class control1 {

    private static control1 instance;
    private control1() {
    }
    public static control1 getInstance() {
        if (instance == null) {
            instance = new control1();
        }
        return instance;
    }
    public void control(jd jds) {
        System.out.println(jds.isFlag() ? "已" : "未");
        jds.press();
        System.out.println(jds.isFlag() ? "已" : "未");
    }

    public void control(){

    }

    public  static void print(jd[] jds) {
        for (jd jd : jds) {
            System.out.println(jd.getName() + " " + (jd.isFlag() ? "已" : "未"));
        }
    }

}


