package basics.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SynchronizedCollectionsExample {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        List<Integer> syncList = Collections.synchronizedList(list);

        // thread 1
        Thread t1 = new Thread(() -> {
            syncList.add(1);
            syncList.add(1);
        });

        // thread 2
        Thread t2 = new Thread(() -> {
            syncList.add(2);
            syncList.add(2);
        });

        // thread 3
        Thread t3 = new Thread(() -> {
            System.out.println(Arrays.toString(syncList.toArray()));
            System.out.println(Arrays.toString(syncList.toArray()));
            System.out.println(Arrays.toString(syncList.toArray()));
            System.out.println(Arrays.toString(syncList.toArray()));
        });

        t1.start();
        t2.start();
        t3.start();

        /*
        output:

        test 1:
        [1, 1, 2, 1]
        [2, 1, 2, 1]
        [1, 2, 2, 1]
        [2, 1, 2, 1]

        test 2:
        [1, 1, 2, 2]
        [1, 1, 2, 2]
        [1, 1, 2, 2]
        [1, 1, 2, 2]

        test 3:
        [1, 2, 1, 2]
        [1, 2, 1, 2]
        [1, 2, 1, 2]
        [1, 2, 1, 2]

        */
    }
}
