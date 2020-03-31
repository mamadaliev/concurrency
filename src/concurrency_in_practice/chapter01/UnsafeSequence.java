package concurrency_in_practice.chapter01;

import concurrency_in_practice.annotations.NotThreadSafe;

@NotThreadSafe
public class UnsafeSequence {
    private int value;

    /** Returns unique value */
    public int getNext() {
        return value++;
    }
}
