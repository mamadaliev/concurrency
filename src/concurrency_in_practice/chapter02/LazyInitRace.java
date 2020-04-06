package concurrency_in_practice.chapter02;

import concurrency_in_practice.annotations.NotThreadSafe;

@NotThreadSafe
public class LazyInitRace {
    private ExpensiveObject instance = null;

    public ExpensiveObject getInstance() {
        if (instance == null) {
            return new ExpensiveObject();
        }
        return instance;
    }
}
