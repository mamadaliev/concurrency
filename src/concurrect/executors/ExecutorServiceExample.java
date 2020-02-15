package concurrect.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        executor.submit(() -> {
            System.out.println("Hello, " + Thread.currentThread().getName()); // out: Hello, pool-1-thread-1
        });
    }
}
