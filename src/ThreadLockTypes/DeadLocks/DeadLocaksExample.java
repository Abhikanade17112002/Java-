package ThreadLockTypes.DeadLocks;

public class DeadLocaksExample {

    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {

        // Thread 1 → tries lock1 then lock2
        Thread t1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("Thread-1 acquired lock1");

                try { Thread.sleep(100); } catch (InterruptedException e) {}

                System.out.println("Thread-1 waiting for lock2...");
                synchronized (lock2) { // waiting here
                    System.out.println("Thread-1 acquired lock2");
                }
            }
        });

        // Thread 2 → tries lock2 then lock1 (reverse order)
        Thread t2 = new Thread(() -> {
            synchronized (lock2) {
                System.out.println("Thread-2 acquired lock2");

                try { Thread.sleep(100); } catch (InterruptedException e) {}

                System.out.println("Thread-2 waiting for lock1...");
                synchronized (lock1) { // waiting here
                    System.out.println("Thread-2 acquired lock1");
                }
            }
        });

        t1.start();
        t2.start();
    }
}