package demo2;

public class jd {
    private String name;
    private boolean flag;


    public jd() {
    }

    public jd(String name, boolean flag) {
        this.name = name;
        this.flag = flag;
    }



    public void press() {
        flag = !flag;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
