package MultiThreading.ExecutorFramework;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/*
 * EXECUTOR FRAMEWORK (VERY IMPORTANT FOR INTERVIEWS)
 * --------------------------------------------------
 * Instead of manually creating threads, we use thread pools.
 *
 * Benefits:
 * - Reuse threads (better performance)
 * - Manage concurrency efficiently
 * - Avoid overhead of thread creation
 */

public class Test {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        /*
         * TYPES OF THREAD POOLS
         * ----------------------
         */

        // 1. Single Thread Executor → only ONE thread
        // ExecutorService service = Executors.newSingleThreadExecutor();

        // 2. Fixed Thread Pool → fixed number of threads
        ExecutorService service = Executors.newFixedThreadPool(3);

        /*
         * SUBMIT TASKS (Runnable)
         * ------------------------
         * Runnable → does NOT return result
         */
        for (int i = 1; i <= 5; i++) {
            final int x = i;

            service.submit(() -> {
                int temp = factorial(x);
                System.out.println("Factorial of " + x + " = " + temp);
            });
        }

        /*
         * FUTURE (VERY IMPORTANT)
         * ------------------------
         * Future represents result of async computation
         */

        Future<Integer> future = service.submit(() -> 100);

        // get() → blocks main thread until result is available
        System.out.println("Future Result: " + future.get());

        /*
         * CALLABLE vs RUNNABLE
         * ---------------------
         * Runnable → no return, no exception
         * Callable → returns value, can throw exception
         */

        Callable<String> callableTask = () -> "Hello from Callable";

        Future<String> callableResult = service.submit(callableTask);
        System.out.println(callableResult.get());

        /*
         * Runnable with Result
         */
        Runnable r = () -> System.out.println("Runnable executed");
        Future<String> result = service.submit(r, "Runnable Result");
        System.out.println(result.get());

        /*
         * invokeAll()
         * ------------
         * Executes multiple Callables
         * Blocks until ALL tasks complete
         */
        Callable<Integer> c1 = () -> 1;
        Callable<Integer> c2 = () -> 2;
        Callable<Integer> c3 = () -> 3;

        List<Callable<Integer>> list = Arrays.asList(c1, c2, c3);

        List<Future<Integer>> results = service.invokeAll(list);

        for (Future<Integer> f : results) {
            System.out.println("invokeAll Result: " + f.get());
        }

        /*
         * SHUTDOWN METHODS
         * -----------------
         */

        // Initiates shutdown (no new tasks accepted)
        service.shutdown();

        /*
         * isShutdown() → checks if shutdown initiated
         * isTerminated() → checks if ALL tasks finished
         */
        System.out.println("Is Shutdown: " + service.isShutdown());
        System.out.println("Is Terminated: " + service.isTerminated());

        /*
         * awaitTermination()
         * -------------------
         * Waits for tasks to finish
         */
        if (!service.awaitTermination(5, TimeUnit.SECONDS)) {
            System.out.println("Forcing Shutdown...");
            service.shutdownNow(); // force shutdown
        }

        /*
         * SCHEDULED EXECUTOR SERVICE
         * ---------------------------
         * Used for delayed & periodic tasks
         */
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        /*
         * schedule()
         * -----------
         * Runs task after delay
         */
        scheduler.schedule(() -> {
            System.out.println("Task after 3 sec delay");
        }, 3, TimeUnit.SECONDS);

        /*
         * scheduleAtFixedRate()
         * ----------------------
         * Runs repeatedly:
         * next start time is fixed (ignores task duration)
         */
        scheduler.scheduleAtFixedRate(() -> {
            System.out.println("Fixed Rate Task (every 2 sec)");
        }, 2, 2, TimeUnit.SECONDS);

        /*
         * scheduleWithFixedDelay()
         * -------------------------
         * Runs after previous task completes + delay
         */
        scheduler.scheduleWithFixedDelay(() -> {
            System.out.println("Fixed Delay Task");
        }, 2, 2, TimeUnit.SECONDS);

        /*
         * Stop scheduler after 10 seconds
         */
        scheduler.schedule(() -> {
            System.out.println("Shutting down scheduler...");
            scheduler.shutdown();
        }, 10, TimeUnit.SECONDS);

        System.out.println("Main Thread: " + Thread.currentThread().getName());
    }

    /*
     * FACTORIAL METHOD
     * -----------------
     * Simulates long-running task using sleep
     */
    public static int factorial(int n) {

        try {
            Thread.sleep(1000); // simulate delay
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (n == 0) return 1;

        int ans = 1;
        for (int i = 1; i <= n; i++) {
            ans *= i;
        }

        return ans;
    }
}