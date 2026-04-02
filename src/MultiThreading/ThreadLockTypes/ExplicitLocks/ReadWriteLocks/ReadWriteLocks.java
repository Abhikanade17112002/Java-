package MultiThreading.ThreadLockTypes.ExplicitLocks.ReadWriteLocks;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLocks {

    // ReadWriteLock → allows multiple readers OR one writer
    private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

    // Separate locks
    private final ReentrantReadWriteLock.ReadLock readLock = rwLock.readLock();
    private final ReentrantReadWriteLock.WriteLock writeLock = rwLock.writeLock();

    private int data = 0; // shared resource

    // 🔹 READ METHOD (multiple threads allowed)
    public void readData() {
        readLock.lock(); // acquire read lock
        try {
            System.out.println(Thread.currentThread().getName() +
                    " Reading data: " + data);

            Thread.sleep(1000); // simulate read time

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // restore interrupt
        } finally {
            readLock.unlock(); // must release
        }
    }

    // 🔹 WRITE METHOD (only one thread allowed)
    public void writeData(int value) {
        writeLock.lock(); // acquire write lock
        try {
            System.out.println(Thread.currentThread().getName() +
                    " Writing data: " + value);

            data = value;

            Thread.sleep(1000); // simulate write time

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            writeLock.unlock(); // must release
        }
    }

    public static void main(String[] args) {

        ReadWriteLocks example = new ReadWriteLocks();

        // Readers → can run in parallel
        Runnable reader = () -> example.readData();

        // Writers → exclusive access
        Runnable writer = () -> example.writeData((int)(Math.random() * 100));

        // Threads
        Thread r1 = new Thread(reader, "Reader-1");
        Thread r2 = new Thread(reader, "Reader-2");
        Thread w1 = new Thread(writer, "Writer-1");

        r1.start();
        r2.start();
        w1.start();
    }
}