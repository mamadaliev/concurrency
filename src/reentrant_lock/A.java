package reentrant_lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class A<T> {

    private final Lock lock = new ReentrantLock();
    private T data;

    public void setWithLock(T data) {
        try {
            lock.lock();
            this.data = data;
        } finally {
            lock.unlock();
        }
    }

    public void setWithTryLock(T data) {
        try {
            if (lock.tryLock()) {
                this.data = data;
            }
        } finally {
            lock.unlock();
        }
    }

    public void setWithLockInterruptibly(T data) {
        try {
            lock.lockInterruptibly();
            this.data = data;
        } catch (InterruptedException e) {
            System.err.println("InterruptedException:" + e.getMessage());
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        A<Integer> a = new A<>();

        // Atomic modification with lock/unlock
        a.setWithLock(1);

        // Atomic modification with trying lock/unlock
        a.setWithTryLock(2);

        // Atomic modification with interruptibly lock/unlock
        a.setWithLockInterruptibly(3);
    }
}
