package basics;

public class ThreadLambdaExample {

    public static void main(String[] args) {

        // #1
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread());
            }
        }).start();

        // #2 with lambda
        new Thread(() -> {
            System.out.println(Thread.currentThread());
        }).start();
    }
}
