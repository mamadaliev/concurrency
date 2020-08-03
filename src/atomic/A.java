package atomic;

import java.util.concurrent.atomic.*;

public class A {

    // Here reading and modification variable is not thread safe.
    // Because of in threads the variable a will be cached.
    private int a;

    // Here atomically reading of variable, because of have final modifier.
    // But, atomically modification is not thread safe.
    private final int b = 1;

    // Here reading and modification variable is thread safe.
    // But, non-atomic on operations such as increment, decrement is not thread safe.
    private volatile int c;

    // Here reading and modification variable is thread safe.
    // Also, you can use incrementAndGet(), decrementAndGet() and etc. methods
    // to non-atomic operations.
    private AtomicInteger d;

    private AtomicBoolean e;
    private AtomicLong f;

    private AtomicIntegerArray g;
    private AtomicLongArray h;
    private AtomicReferenceArray<Integer> j;

    private AtomicIntegerFieldUpdater<Integer> m;
    private AtomicLongFieldUpdater<Integer> n;

    private AtomicReference<Integer> o;
    private AtomicMarkableReference<Integer> k;
    private AtomicStampedReference<Integer> l;

    public static void main(String[] args) {
        A a = new A();

        // Atomically incrementing
        System.out.println(a.d.incrementAndGet());

        // Atomically decrementing
        System.out.println(a.d.decrementAndGet());
    }
}
