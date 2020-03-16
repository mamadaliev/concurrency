package concurrency_in_action.chapter01;

import concurrency_in_action.annotations.NotThreadSafe;

@NotThreadSafe
public class UnsafeSequence {
    private int value;

    /** Returns unique value */
    public int getNext() {
        return value++;
    }
}
