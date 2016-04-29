package pl.pollub.training.model.day3;

import org.junit.Test;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Wlad on 26.04.2016.
 */
public class TaskTest {

    int tests = 1000;
    AtomicInteger counter = new AtomicInteger(0);

    @Test
    public void test() {
        System.out.println(Thread.currentThread().getName());
        System.out.println(new Date());
        for (int i = 0; i < tests; i++) {
            new Task().execute();
        }
        System.out.println(new Date());
    }

    @Test
    public void testNewThread() {
        int threads = Runtime.getRuntime().availableProcessors() + 1;
        for (int i = 0; i < threads; i++) {
            Thread thread = new Thread(runnable());
            thread.start();
            System.out.println(thread.getName());
        }
        System.out.println("Not wait");
    }

    @Test
    public void testExecutors() {
        int threads = Runtime.getRuntime().availableProcessors() + 1;
        ExecutorService service = Executors.newFixedThreadPool(threads);
        System.out.println(new Date());
        for (int i = 0; i < threads; i++) {
            service.execute(runnable());
        }
        service.shutdown();
        while (!service.isTerminated()) {
        }
        System.out.println(new Date());
    }


    private Runnable runnable() {
        return new Runnable() {
            @Override
            public void run() {
                while (counter.incrementAndGet() < tests) {
                    new Task().execute();
                }
            }
        };
    }
}
