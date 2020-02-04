package basics;

import java.util.concurrent.TimeUnit;

public class JoinExample {

    public static void main(String[] args) {
        Thread t1, t2;

        // Thread 1
        t1 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread 1");
        });

        // Thread 2
        t2 = new Thread(() -> {
            try {
                t1.join(); // t2 waits for thread 1 to complete
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread 2");
        });

        t1.start();
        t2.start();
    }
}
