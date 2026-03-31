package MultiThreading.runnableinterface;

public class MyThread implements Runnable {

    @Override
    public void run(){

        System.out.println("Inside The Run Methode");
        System.out.println(Thread.currentThread().getName());

    }


}
