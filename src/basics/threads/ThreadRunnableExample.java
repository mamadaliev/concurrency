package basics.threads;

public class ThreadRunnableExample {

    public static void main(String[] args) {

        // start five threads
        for (int i = 0; i < 5; i++) {
            new Thread(new MyThread()).start();
        }

        /*
        output:
        Thread[Thread-0,5,main]
        Thread[Thread-3,5,main]
        Thread[Thread-2,5,main]
        Thread[Thread-1,5,main]
        Thread[Thread-4,5,main]
        */
    }

    static class MyThread implements Runnable {

        @Override
        public void run() {
            System.out.println(Thread.currentThread());
        }
    }
}
