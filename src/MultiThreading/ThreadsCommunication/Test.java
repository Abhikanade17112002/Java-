package MultiThreading.ThreadsCommunication;

/*
 * CLASS: SharedResource
 * ----------------------
 * This is the shared object between Producer and Consumer.
 * It acts as a communication medium.
 */
class SharedResource {

    private int data = 0;          // Shared data
    private boolean hasData = false; // Flag to check if data is available

    /*
     * METHOD: produceData
     * --------------------
     * Produces data only if buffer is empty.
     * If data already exists → Producer goes into WAIT state.
     */
    public synchronized void produceData(int dataValue) {

        // Wait until previous data is consumed
        while (hasData) {
            try {
                System.out.println("Producer " + Thread.currentThread().getName() + " WAITING...");

                /*
                 * wait():
                 * - Releases lock of SharedResource
                 * - Moves thread to WAITING state
                 * - Wakes up only when notify()/notifyAll() is called
                 */
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // Produce data
        System.out.println("Producing: " + dataValue);
        this.data = dataValue;
        this.hasData = true;

        /*
         * notify():
         * - Wakes up ONE waiting thread (consumer in this case)
         * - Does NOT release lock immediately
         */
        notify();
    }

    /*
     * METHOD: consumeData
     * --------------------
     * Consumes data only if available.
     * If no data → Consumer goes into WAIT state.
     */
    public synchronized void consumeData() {

        // Wait until data is available
        while (!hasData) {
            try {
                System.out.println("Consumer " + Thread.currentThread().getName() + " WAITING...");
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // Consume data
        System.out.println("Consumed: " + this.data);
        this.hasData = false;

        // Notify producer that buffer is empty again
        notify();
    }
}


/*
 * CLASS: ProducerThread
 * ----------------------
 * Produces data 10 times
 */
class ProducerThread extends Thread {

    private SharedResource sharedResource;

    public ProducerThread(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {

            /*
             * Calls shared resource method
             * Synchronization handled inside SharedResource
             */
            sharedResource.produceData(i + 1);
        }
    }
}


/*
 * CLASS: ConsumerThread
 * ----------------------
 * Consumes data 10 times
 */
class ConsumerThread extends Thread {

    private SharedResource sharedResource;

    public ConsumerThread(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {

            // Calls shared resource method
            sharedResource.consumeData();
        }
    }
}


/*
 * CLASS: Test (Main Class)
 * ------------------------
 * Entry point of program
 */
public class Test {

    public static void main(String[] args) {

        // Shared object
        SharedResource sharedResource = new SharedResource();

        // Create threads
        ProducerThread pt = new ProducerThread(sharedResource);
        ConsumerThread ct = new ConsumerThread(sharedResource);

        // Start threads
        pt.start();
        ct.start();

        try {
            /*
             * join():
             * - Main thread waits until child threads finish execution
             */
            pt.join();
            ct.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Main thread prints at the end
        System.out.println("Main Thread: " + Thread.currentThread().getName());
    }
}