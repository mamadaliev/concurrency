package basics.notify;

import java.util.*;

public class WaitNotifyLogicExample {
    public static void main(String[] args) {
        new Operator().start();
        new Machine().start();
    }
}

class Generator {
    static final List<String> list = Collections.synchronizedList(new LinkedList<>());
}

class Operator extends Thread {

    @Override
    public void run() {
        Scanner in = new Scanner(System.in);

        //noinspection InfiniteLoopStatement
        while (true) {
            synchronized (Generator.list) {
                Generator.list.add(in.nextLine());
                Generator.list.notify();
            }
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Machine extends Thread {

    @Override
    public void run() {
        while (Generator.list.isEmpty()) {
            synchronized (Generator.list) {
                try {
                    Generator.list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Generator.list.remove(0));
            }
        }
    }
}
