package examples.volatile_variable;

import concurrency_in_practice.annotations.NotThreadSafe;
import concurrency_in_practice.annotations.ThreadSafe;

@NotThreadSafe
public class VolatileViewsCounter {

    /**
     * If done without volatile in this variable,
     * we get a race condition problem
     * when calling the getViewsCount method.
     * Because the volatile modifier turn off caching
     * variables between threads.
     * private volatile long viewsCount;
     */
    private volatile long viewsCount;

    /**
     * We don't get a race condition problem,
     * because the set operation is atomic.
     *
     * @param viewsCount parameter for set a value of viewsCount.
     */
    @ThreadSafe
    public void setViewsCount(long viewsCount) {
        this.viewsCount = viewsCount;
    }

    /**
     * We don't get a race condition problem,
     * because the get operation is atomic.
     */
    @ThreadSafe
    public long getViewsCount() {
        return viewsCount;
    }

    /**
     * We get a race condition problem,
     * because the increment operation is not atomic.
     * For solution this problem use:
     * - synchronized method
     * - synchronized block
     */
    @NotThreadSafe
    @SuppressWarnings("NonAtomicOperationOnVolatileField")
    public void increment() {
        this.viewsCount++;
    }
}
