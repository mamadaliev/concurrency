package concurrency_in_action.chapter01;

import concurrency_in_action.annotations.GuardedBy;
import concurrency_in_action.annotations.ThreadSafe;

@ThreadSafe
public class Sequence {
    @GuardedBy("this") private int nextValue;

    public synchronized int getNextValue() {
        return nextValue++;
    }
}
