package thread_group;

public class A {

    public static void main(String[] args) {
        ThreadGroup groupA = new ThreadGroup("Group A");
        ThreadGroup groupB = new ThreadGroup("Group B");

        Thread a = new Thread(groupA, () -> System.out.println("A1"));
        Thread b = new Thread(groupA, () -> System.out.println("A2"));
        Thread c = new Thread(groupB, () -> System.out.println("B1"));

        // Get active threads count in thread's group.
        System.out.println(a.getThreadGroup().activeCount());

        // Get thread group name.
        System.out.println(c.getThreadGroup().getName());
    }
}
