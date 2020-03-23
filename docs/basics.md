# Basics
There are two ways to create threads in Java: 
by implementing the **Runnable** interface and 
by extending the **Thread** class.

## Thread
```java
class Main {
    public static void main(String[] args) {        
        // #1 by extending the class Thread
        MyThread thread = new MyThread().start();
    }
}

class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println(Thread.currentThread());
    }
}
```

## Runnable
```java
class MyThread implements Runnable {
    
    @Override
    public void run() {
        System.out.println(Thread.currentThread());
    }
}

class Main {
    public static void main(String[] args) {
        
        // #1 simple way
        Thread t1 = new Thread(new MyThread());
        t1.start();

        // #2 with anonymous class
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread());
            }
        }).start();

        // #3 with lambda (same as #2)
        new Thread(() -> {
            System.out.println(Thread.currentThread());
        }).start();
    }
}
```

## Callable

## Volatile

## Synchronized

## ThreadLocal

## ThreadGroup

## Synchronized collections
```java
class Main {

    public static void main(String[] args) {
        Collection<Integer> collection                  = Collections.synchronizedCollection(new Vector<>());
        List<Integer> syncList                          = Collections.synchronizedList(new ArrayList<>());
        Set<Integer> syncSet                            = Collections.synchronizedSet(new HashSet<>());
        SortedSet<Integer> syncSortedSet                = Collections.synchronizedSortedSet(new TreeSet<>());
        Map<Integer, Integer> syncQueue                 = Collections.synchronizedMap(new HashMap<>());
        NavigableMap<Integer,Integer> syncNavigableMap  = Collections.synchronizedNavigableMap(new TreeMap<>());
        SortedMap<Integer,Integer> syncSortedMap        = Collections.synchronizedNavigableMap(new TreeMap<>());
    }
}
```
