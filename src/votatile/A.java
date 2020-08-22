package votatile;

public class A<T> {

    // 1. The volatile modifier allows not to cache a variable in threads.
    // 2. Provides atomic reading in threads.
    private volatile T data;

    public T getData() {
        return this.data;
    }


    @SuppressWarnings("NonAtomicOperationOnVolatileField")
    public static void main(String[] args) {
        A<Integer> a = new A<>();

        // Atomic reading
        System.out.println(a.getData());

        // Non-atomic modification.
        // You need to increment/decrement variable use Atomics from Concurrency.
        a.data++;
    }
}
