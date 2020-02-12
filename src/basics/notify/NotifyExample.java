package basics.notify;

public class NotifyExample {
    private static final MyThread t1 = new MyThread();

    public static void main(String[] args) throws InterruptedException {

        // create a new thread
        t1.start();

        // waiting for t1 until t1 sends a notification
        synchronized (t1) {
            t1.wait();
        }

        // output the text after t1
        System.out.println("Successfully! Count: " + t1.getCount());
    }
}

class MyThread extends Thread {

    private int count;

    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0; i < 4; i++) {
                count++;
                System.out.println(i);

                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.notify();
        }
    }

    int getCount() {
        return count;
    }
}
