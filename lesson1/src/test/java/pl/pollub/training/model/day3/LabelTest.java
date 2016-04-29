package pl.pollub.training.model.day3;

import org.junit.Test;

import java.util.logging.Logger;

public class LabelTest {
    private final Logger logger = Logger.getLogger(LabelTest.class.toString());


    @Test
    public void testLabel() {
        for (int i = 0; i < 10; i++) {
            label:
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    for (int l = 0; l < 10; l++) {
                        if (l == 5) {
                            continue label;
                        }
                    }
                }
            }
        }
    }

    @Test
    public void test2() {
    }
}