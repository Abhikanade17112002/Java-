package MultiThreading.ThreadsUsingLambdaFunction;

/*
 * Functional Interface:
 * ----------------------
 * An interface with ONLY ONE abstract method.
 * Example: Runnable (run() method)
 *
 * Lambda Expression:
 * -------------------
 * A short way to implement functional interfaces.
 * Also called Anonymous Function (no name, no return type, no access modifier)
 */

public class Test {

    public static void main(String[] args) {

        /*
         * OLD WAY (Anonymous Class)
         * --------------------------
         * More verbose, more boilerplate
         */
//        Runnable r1 = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Same Existing Old Way");
//            }
//        };

        /*
         * LAMBDA WAY
         * ------------
         * Since Runnable is a functional interface,
         * we can directly use lambda expression
         */

        // Multi-line lambda
        Runnable r1 = () -> {
            System.out.println("Runnable 1");
        };

        // Single-line lambda (no curly braces needed)
        Runnable r2 = () -> System.out.println("Runnable 2");

        /*
         * Direct lambda inside Thread
         * ----------------------------
         * No need to create separate Runnable object
         */
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        Thread t3 = new Thread(() -> System.out.println("Runnable 3"));

        // Start threads (parallel execution)
        t1.start();
        t2.start();
        t3.start();

        try {
            /*
             * join():
             * Main thread waits for all threads to finish
             */
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Main thread executes after all threads complete
        System.out.println("Main Thread: " + Thread.currentThread().getName());
    }
}