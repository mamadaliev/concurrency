package concurrency_in_practice.chapter01;

import concurrency_in_practice.annotations.GuardedBy;
import concurrency_in_practice.annotations.ThreadSafe;

@ThreadSafe
public class Sequence {
    @GuardedBy("this") private int nextValue;

    public synchronized int getNextValue() {
        return nextValue++;
    }
}
