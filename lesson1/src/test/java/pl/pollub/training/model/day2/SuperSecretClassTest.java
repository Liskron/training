package pl.pollub.training.model.day2;

import com.sun.istack.internal.NotNull;
import org.junit.Test;

/**
 * Created by Wlad on 25.04.2016.
 */
public class SuperSecretClassTest {

    @NotNull
    private String d;

    @Test
    @AsyncStatistic
    public void createPrivateConstuctor() {
//        Constructor[] constructors = SuperSecretClass.class.getDeclaredConstructors();
//        for (Constructor constructor : constructors) {
//            constructor.setAccessible(true);
        try {
//                SuperSecretClass instance = (SuperSecretClass) constructor.newInstance();
            throw new IllegalAccessException();
        } catch (IllegalAccessException ex) {
            System.out.println("ex1");
        } catch (Throwable ex2) {
            System.out.println("ex2");
        }
//        }
    }

    @Test
    public void test() {
        byte value = 50;
        for (int i = 0; i < 100; i++) {
            System.out.println(value++);
        }
    }
}