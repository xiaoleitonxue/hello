package demo12.demo4;

public @interface a {
    String name();
    int age() default 18;
    String[] add();
}
