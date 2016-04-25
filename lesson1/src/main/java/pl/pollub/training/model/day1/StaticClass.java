package pl.pollub.training.model.day1;

public class StaticClass {

    public static int VALUE = 5;

    static {
        int a = 5;
        int b = 6;
        System.out.println(a + b);
    }

    public static Person person = new Person();

    public static int getNumber() {
        System.out.println("Static method invoked");
        return 9;
    }

    public StaticClass() {
        System.out.println("Static creation");
    }
}
