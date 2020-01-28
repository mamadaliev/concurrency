package basics.synchronizes;

public class BasicSynchronizedExample {

    public static void main(String[] args) {
        Counter counter = new Counter();

        // User
        new Thread(() -> {
            Thread.currentThread().setName("User");

            for (;;) {
                synchronized (counter) {
                    counter.a = (int) (Math.random() * 10);
                    counter.b = (int) (Math.random() * 10);
                    System.out.println(Thread.currentThread().getName() + ": " + counter.a + ", B: " + counter.b);
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        // Solver
        new Thread(() -> {
            Thread.currentThread().setName("Solver");

            for (;;) {
                synchronized (counter) {
                    System.out.println(Thread.currentThread().getName() + ": " + (counter.a + counter.b));
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        /*
        output:
        User: 6, B: 5
        Solver: 11
        User: 1, B: 5
        User: 8, B: 6
        Solver: 14
        User: 1, B: 8
        Solver: 9
        Solver: 9
        User: 1, B: 2
        Solver: 3
        User: 3, B: 7
        Solver: 10
        User: 0, B: 2
        ...
        */
    }

    static class Counter {
        private Integer a = 0;
        private Integer b = 0;
    }
}
