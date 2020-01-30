package concurreny;

import java.util.concurrent.*;

public class CallableExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        Callable task = () -> {
            TimeUnit.SECONDS.sleep(2);
            return 123;
        };

        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<Integer> future = executor.submit(task);

        System.out.println(future.isDone());
        Integer result = future.get(3, TimeUnit.SECONDS);
        System.out.println(future.isDone());
        System.out.println(result);
        executor.shutdown();
    }
}
