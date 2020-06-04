package synchronized_block;

public class A {

    private volatile int i;

    public void inc() {
        synchronized (this) {
            i++;
        }
    }

    public void dec() {
        synchronized (this) {
            i--;
        }
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
