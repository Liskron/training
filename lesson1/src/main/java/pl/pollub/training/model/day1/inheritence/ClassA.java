package pl.pollub.training.model.day1.inheritence;

public class ClassA extends ClassB {
    public ClassA() {
        System.out.println("class A");
    }

    @Override
    public int doSomething() {
        System.out.println("a - do something");
        return 0;
    }
}
