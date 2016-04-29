package pl.pollub.training.model.day3;

import java.util.Random;

public class Task {

    private int a;
    private int b;

    public static final Random random = new Random();

    public Task() {
        a = random.nextInt();
        b = random.nextInt();
    }

    public long execute() {
        try {
            Thread.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return a + b;
    }
}
