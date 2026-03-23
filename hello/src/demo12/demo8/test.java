package demo12.demo8;

public class test {
    public static void main(String[] args) {

        star star = new star("赵敏");

        servise proxy = proxyutil.getProxy(star);

        proxy.sing("I'm singingggggggggggggggg");

        System.out.println(proxy.dance());

    }
}
