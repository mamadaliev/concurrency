package examples.synchronized_method;

import concurrency_in_practice.annotations.NotThreadSafe;
import concurrency_in_practice.annotations.ThreadSafe;

@NotThreadSafe
public class SynchronizedViewsCounter {

    private long viewsCount;

    /**
     * This method is not a thread safe
     * because the instance variable is not setViewsCount
     * will be caching by for everyone thread.
     *
     * Solution:
     * 1. Use volatile modifier before the viewsCount instance variable.
     * 2. Use synchronized block in a method.
     */
    @NotThreadSafe
    public void setViewsCount(long viewsCount) {
        this.viewsCount = viewsCount;
    }

    @ThreadSafe
    public long getViewsCount() {
        return viewsCount;
    }

    /**
     * This method is not a thread safe
     * because the instance variable is not setViewsCount
     * will be caching by for everyone thread.
     *
     * Solution:
     * 1. Use volatile modifier before the viewsCount instance variable.
     * 2. Use synchronized block in a method.
     */
    @NotThreadSafe
    public synchronized void increment() {
        this.viewsCount++;
    }
}
