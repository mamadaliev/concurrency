package synchronized_method;

public class A {

    private volatile int i;

    public synchronized void inc() {
        i++;
    }

    public synchronized void dec() {
        i--;
    }

    public int getI() {
        return i;
    }

    public static void main(String[] args) {
        A a = new A();

        // Atomic increment
        a.inc();

        // Atomic decrement
        a.dec();

        // Atomic reading
        System.out.println(a.getI());
    }
}
