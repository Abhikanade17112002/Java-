package ThreadLockTypes.ExplicitLocks;

// lock() → blocks indefinitely until lock is acquired (no timeout, can cause deadlock if not handled)

// tryLock() → non-blocking; tries once and returns immediately (true = got lock, false = didn't)

// tryLock(time) → waits up to given time; returns false if timeout happens (better control than lock())
//if(lock.tryLock(2, TimeUnit.SECONDS)) {
//        // lock acquired ✅
//        } else {
//        // timeout happened ❌ (no exception)
//        }


// unlock() → releases the lock; MUST be called in finally block to avoid deadlock

// Notes:
// - Only the thread that acquired the lock should call unlock()
// - Prefer tryLock() / tryLock(timeout) to avoid waiting forever
// - Use try-finally pattern:
//     lock.lock();
//     try { /* critical section */ }
//     finally { lock.unlock(); }





// InterruptedException handling:
//
// - Thrown when a thread is asked to stop (interrupt signal)
// - Throwing it CLEARS the interrupt flag
// - If you just catch & ignore → you LOSE the interrupt signal ❌
//   → thread may continue running incorrectly (bad for shutdown, thread pools)
//
// Correct handling:
// 1) Restore interrupt flag (most common):
//    Thread.currentThread().interrupt();
//
// 2) Or rethrow:
//    throw e;
//
// 3) Optionally: clean up + exit (return / break)
//
// Rule:
// ❌ Never swallow (ignore) InterruptedException
// ✅ Either propagate OR restore the interrupt status

public class Test {
    public static void main(String[] args) throws InterruptedException {


        BankAccount account = new BankAccount() ;
        Runnable runnable = new Runnable() {
            @Override
            public void run() {


                account.withdrawAmmount(50);


            }
        } ;

        Thread t1 = new Thread(runnable,"Thread-1") ;
        Thread t2 = new Thread(runnable,"Thread-2") ;



        t1.start();
        t2.start();


        t1.join();
        t2.join();


        System.out.println(account.getBankBalance());

    }
}
