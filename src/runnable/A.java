package runnable;

public class A {
    static class ThreadA implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName());
            }
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new ThreadA());
        thread.start(); // starting thread
    }
}
