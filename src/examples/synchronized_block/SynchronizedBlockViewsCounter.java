package examples.synchronized_block;

import concurrency_in_practice.annotations.ThreadSafe;

@ThreadSafe
public class SynchronizedBlockViewsCounter {

    private long viewsCount;

    @ThreadSafe
    public void setViewsCount(long viewsCount) {
        synchronized (this) {
            this.viewsCount = viewsCount;
        }
    }

    @ThreadSafe
    public long getViewsCount() {
        return viewsCount;
    }

    @ThreadSafe
    public void increment() {
        synchronized (this) {
            this.viewsCount++;
        }
    }
}
