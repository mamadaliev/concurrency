package clyclic_barrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class A {

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(3, () -> System.out.println("FINISH.."));

        Thread t1 = new Thread(new MyThread(barrier));
        Thread t2 = new Thread(new MyThread(barrier));
        Thread t3 = new Thread(new MyThread(barrier));

        t1.start();
        sleep();
        t2.start();
        sleep();
        t3.start();
    }

    static void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class MyThread implements Runnable {

        private final CyclicBarrier barrier;

        public MyThread(CyclicBarrier barrier) {
            this.barrier = barrier;
        }

        @Override
        public void run() {
            System.out.print(Thread.currentThread().getName() + ": ACTION BEFORE BARRIER ");
            System.out.print("(" + barrier.getNumberWaiting() + ")");
            System.out.print("(" + barrier.getParties() + ")");
            System.out.println("(" + barrier.isBroken() + ")");
            try {
                barrier.await(3, TimeUnit.SECONDS);
            } catch (InterruptedException | BrokenBarrierException | TimeoutException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ": ACTION AFTER BARRIER...");
        }
    }
}

 /*
    Thread-0: ACTION BEFORE BARRIER (0)(3)
    Thread-1: ACTION BEFORE BARRIER (1)(3)
    Thread-2: ACTION BEFORE BARRIER (2)(3)
    FINISH..
    Thread-2: ACTION AFTER BARRIER...
    Thread-0: ACTION AFTER BARRIER...
    Thread-1: ACTION AFTER BARRIER...
 */
