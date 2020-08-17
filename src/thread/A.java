package thread;

public class A {

    static class ThreadA extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName());
            }
        }
    }

    public static void main(String[] args) {
        ThreadA thread = new ThreadA();
        thread.start(); // starting thread
    }
}
