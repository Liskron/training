package pl.pollub.training.model.day1.inheritence;

public class ClassC implements MyInterface {

    public ClassC() {
        System.out.println("class C");
    }

    public int doSomething() {
        System.out.println("c - do something");
        return 0;
    }
}
