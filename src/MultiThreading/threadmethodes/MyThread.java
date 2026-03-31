package MultiThreading.threadmethodes;

public class MyThread extends Thread{

    public MyThread( String threadName ){
        super(threadName);
    }


    @Override
    public void run(){

        for (int i = 0; i < 10; i++) {
            try {
                // Sleep ==> Pauses The Thread execution For Given Ammount Of Time
                sleep(1000);

                // Yeild Methode tells JVM that i m willing to give my execution time to some other thread , similar to priority JVM will not follow it strictly
                Thread.yield();
                System.out.println( Thread.currentThread().getName() + " " + Thread.currentThread().getPriority() );
            } catch (InterruptedException e) {
                System.out.println( " Exception ==> " + e );
            }




        }

    }


    public static void main(String[] args) {

        MyThread thread1 = new MyThread("thread1") ;
        MyThread thread2 = new MyThread("thread2") ;
        MyThread thread3 = new MyThread("thread3") ;




        // Set Priority ==> helps to set the thread execution priority ==>
        // but its not compulsary that JVM will form this priority Strictly  Min 1 Max 10 Norm 5

        thread1.setPriority(Thread.MAX_PRIORITY);
        // Intrupt methode will intrrupt the current state of thread
        thread1.interrupt();
        thread2.setPriority(Thread.NORM_PRIORITY);
        thread3.setPriority(Thread.MIN_PRIORITY);

        // A deamon thread is a thread that belongs to background threads , non deamon threads are worker threads
        // main thread will wait for the execution of all the worker thread to finish and then only stop the execution , but it will not wait for the execution of demon thread to complete

        thread2.setDaemon(true);



        // Start Method  ==> Transits Thread from New To Runnable Or Running State
        thread1.start();
        thread2.start();
        thread3.start();


    }




}
