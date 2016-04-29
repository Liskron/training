package pl.pollub.training.model.day4;

import org.junit.Test;

public class ExtGenericTest {

    @Test
    public void test() {
        String result = ExtGeneric.call("Value", String.class);
        System.out.print(result);
    }
}