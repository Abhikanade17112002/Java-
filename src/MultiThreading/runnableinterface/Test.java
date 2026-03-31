package MultiThreading.runnableinterface;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Inside The Main Thread");
        System.out.println(Thread.currentThread().getName());

        MyThread r = new MyThread() ;
        Thread t = new Thread(r) ;
        // InThe New State
        System.out.println(t.getState());
        t.start(); // In The Runnable State if CPU does not give memory
        // If CPU gives memmory then running but will still show Runnable State
        System.out.println(t.getState());

        t.join(); // Main Thread will waite for the other thread finishe

        System.out.println(t.getState());
    }
}
