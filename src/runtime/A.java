package runtime;

public class A {

    public static void main(String[] args) throws InterruptedException {
        Runtime runtime = Runtime.getRuntime();

        // 1 megabyte = 1048576 (or 1024 * 1024) bytes.
        int megabyte = 1024 * 1024;
        int gigabyte = 1024 * 1024 * 1000;

        long total = runtime.totalMemory();
        long free  = runtime.freeMemory();
        long used  = total - free;
        long max   = runtime.maxMemory();

        System.out.println("TOTAL: " + total / megabyte + " MB");
        System.out.println("USED : " + used / megabyte + " MB");
        System.out.println("FREE : " + free / megabyte + " MB");
        System.out.println("MAX  : " + max / gigabyte + " GB");

        runtime.addShutdownHook(new Thread(() -> {
            System.out.println("Shutting down Hook...");
        }));

        System.out.print("\nHello World!\n");
        Thread.sleep(3000);
    }
}
