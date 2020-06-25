package wait_notify;

import java.util.PriorityQueue;
import java.util.Queue;

/*
    Provider-Consumer Synchronize Problem
*/
public class A<E> {

    private final Queue<E> data;

    public A() {
        data = new PriorityQueue<>();
    }

    public synchronized void provide(E element) {
        data.offer(element);
        this.notifyAll();
    }

    public synchronized void consume() throws InterruptedException {
        while (data.size() <= 0)
            wait();

        data.remove();
        this.notifyAll();
    }

    public static void main(String[] args) {
        A<Integer> a = new A<>();

        // The first thread which call the provide method of A class and send number to queue.
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                a.provide(i);
            }
        }).start();

        // The second thread which call the consume method of A class for remove number from queue.
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    a.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
