package ThreadLockTypes.ExplicitLocks.WhyReentrendLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;



// ================= SYNCHRONIZED vs REENTRANTLOCK =================

// 🔹 BASIC:
// synchronized → keyword (built-in JVM lock)
// ReentrantLock → class (java.util.concurrent, more control)

// 🔹 ACQUIRING LOCK:
// synchronized → automatic (block/method entry)
// ReentrantLock → manual (lock() must be called)

// 🔹 RELEASING LOCK:
// synchronized → automatic (when block ends)
// ReentrantLock → manual (must call unlock() in finally)

// 🔹 FLEXIBILITY:
// synchronized → less flexible ❌
// ReentrantLock → more flexible ✅ (tryLock, timeout, interruptible)

// 🔹 TRY WITHOUT WAITING:
// synchronized → not possible ❌
// ReentrantLock → tryLock() available ✅

// 🔹 TIMEOUT SUPPORT:
// synchronized → no timeout ❌
// ReentrantLock → tryLock(time) ✅

// 🔹 INTERRUPTIBLE LOCK:
// synchronized → not interruptible ❌
// ReentrantLock → lockInterruptibly() ✅

// 🔹 FAIRNESS:
// synchronized → no fairness control ❌
// ReentrantLock → can enable fairness (FIFO) ✅

// 🔹 PERFORMANCE:
// synchronized → simple, optimized by JVM (good for basic use)
// ReentrantLock → better in high contention / complex scenarios

// 🔹 DEADLOCK HANDLING:
// synchronized → no control ❌
// ReentrantLock → can avoid using tryLock() ✅

// 🔹 CONDITION VARIABLES:
// synchronized → wait(), notify(), notifyAll()
// ReentrantLock → Condition (more powerful & multiple conditions)

// 🔹 CODE COMPLEXITY:
// synchronized → simple & less error-prone ✅
// ReentrantLock → complex, risk of forgetting unlock() ❌


// ================= ADVANTAGES =================

// synchronized:
// + simple to use
// + automatic lock release (safe)
// + less boilerplate

// ReentrantLock:
// + more control over locking
// + tryLock(), timeout support
// + interruptible locking
// + fairness option
// + better for advanced concurrency


// ================= DISADVANTAGES =================

// synchronized:
// - no timeout / try mechanism
// - no interruptible lock
// - less flexible

// ReentrantLock:
// - must manually unlock (risk of deadlock if forgotten)
// - more complex code
// - slightly more overhead


// ================= MEMORY TRICK =================

// synchronized → SIMPLE 🔒
// ReentrantLock → POWERFUL ⚙️

// Use:
// - synchronized → basic use cases
// - ReentrantLock → advanced control / avoid deadlocks



public class ReentrendLockExample {

    // ReentrantLock → same thread can acquire the lock multiple times
    private final Lock lock = new ReentrantLock();

    // Fair lock → threads get lock in FIFO order (slower but fair)
//    private final Lock lock = new ReentrantLock(true);

    public void outerMethode(){

        // Thread enters outer method
        System.out.println(Thread.currentThread().getName() + " Entering The Outer Methode ");

        try{
            // Acquire lock (hold count = 1)
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " Acquired The Lock On Outer Methode ");

            // Calling another method which also uses same lock
            // Without ReentrantLock → DEADLOCK ❌
            // With ReentrantLock → allowed (same thread can re-acquire)
            innerMethode();

        }
        catch (Exception e){
            System.out.println(Thread.currentThread().getName()+ " " +e);
        }
        finally {
            // MUST unlock → reduces hold count
            System.out.println(Thread.currentThread().getName() + " Unlocking The Lock On Outer Methode ");
            lock.unlock(); // hold count decreases
        }

    }

    public void innerMethode(){

        System.out.println(Thread.currentThread().getName() + " Entering The Inner Methode ");

        try{
            // Same thread acquiring lock again (hold count = 2)
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " Acquired The Lock On Inner Methode ");

        }
        catch (Exception e){
            System.out.println(Thread.currentThread().getName()+ " " +e);
        }
        finally {
            // MUST unlock again → hold count back to 1
            System.out.println(Thread.currentThread().getName() + " Unlocking The Lock On Inner Methode ");
            lock.unlock();
        }

    }

    public static void main(String[] args) throws InterruptedException {

        ReentrendLockExample example = new ReentrendLockExample();

        // Runnable → both threads will execute same method
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                example.outerMethode();
            }
        };

        Thread t1 = new Thread(runnable,"Thread-1");
        Thread t2 = new Thread(runnable,"Thread-2");

        // Start threads → only ONE thread gets lock at a time
        t1.start();
        t2.start();

        // Wait for both threads to finish
        t1.join();
        t2.join();

        // Main thread prints at end
        System.out.println(Thread.currentThread().getName());
    }
}