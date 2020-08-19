package daemon;

public class A {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            while (true) {
                System.out.println("Is daemon: " + Thread.currentThread().isDaemon());
            }
        });

        // Setting daemon.
        thread.setDaemon(true);

        // Starting thread.
        thread.start();
    }
}
