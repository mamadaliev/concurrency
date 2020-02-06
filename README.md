# multithreading
Examples of the basics of multithreading and concurrency in Java for beginners.

- **[Basics]()**
    - [Thread]()
    - [Runnable]()
    - [ThreadLocal]()
    - [ThreadGroup]()
- **[Concurrent]()**
    - [Atomics]()
    - [Collections]()
    - [Executors]()
    - [Locks]()
    - [Queues]()
    - [Synchronizes]()

## Basics
### Thread
### Runnable
### ThreadLocal
### ThreadGroup
### Synchronized collections
```java
class Example {
    public static void main(String[] args){
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

## Concurrent
### Atomics

### Collections
#### CopyOnWriteArrayList
###### Analogue of ArrayList with CopyOnWrite algorithm.

#### CopyOnWriteArraySet
Implementation of the Set interface using CopyOnWriteArrayList as the basis.

#### ConcurrentHashMap
An analogue of HashMap that implements the ConcurrentMap interface.

#### ConcurrentNavigableMap
An interface that extends the NavigableMap interface.

#### ConcurrentSkipListMap
An analogue of TreeMap with data sorting by key and with multithreading support.

#### ConcurrentSkipListSet
Implementation of the Set interface, based on the ConcurrentSkipListMap class.

### Executors
### Locks
### Queues
### Synchronizes

## Contribute
For any problems, comments, or feedback please create an issue [here](https://github.com/egnaf/multithreading/issues).

## License
This software is released under the [MIT](http://mitlicense.org) license.
