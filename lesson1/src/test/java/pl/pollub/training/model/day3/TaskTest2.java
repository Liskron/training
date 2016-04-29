package pl.pollub.training.model.day3;

import org.junit.Test;
import pl.pollub.training.model.day1.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

import static org.junit.Assert.assertEquals;

public class TaskTest2 {

    private List<Task> tasks = new ArrayList<>();
    private volatile int index = 0;
    private long parallelResult = 0;
    private long linearResult = 0;

    @Test
    public void test() throws InterruptedException {
        for (int i = 0; i < 5000; i++) {
            tasks.add(new Task());
        }
        tasks = Collections.synchronizedList(tasks);
        linearExecution();
        parallelWithExecutionService(10);
        assertEquals(linearResult, parallelResult);
    }

    public void linearExecution() {
        System.out.println(new Date());
        for (Task task : tasks) {
            linearResult += task.execute();
        }
        System.out.println(new Date());
        System.out.println("Result: " + linearResult);
    }

    private void parallelWithExecutionService(int threads) {
        System.out.println(new Date());
        ExecutorService executor = Executors.newFixedThreadPool(threads);
        for (int i = 0; i < threads; i++) {
            executor.execute(getRunnable());
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        System.out.println(new Date());
        System.out.println("Result: " + parallelResult);
    }

    private Future<Person> getCallable() {
        return new Future<Person>() {
            @Override
            public boolean cancel(boolean mayInterruptIfRunning) {
                return false;
            }

            @Override
            public boolean isCancelled() {
                return false;
            }

            @Override
            public boolean isDone() {
                return false;
            }

            @Override
            public Person get() throws InterruptedException, ExecutionException {
                return null;
            }

            @Override
            public Person get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
                return null;
            }
        };
    }

    private Runnable getRunnable() {
        return () -> {
            synchronized (tasks) {
                while (index < tasks.size()) {
                    Task task = tasks.get(index++);
                    parallelResult += task.execute();
                }
            }
        };
    }

}
