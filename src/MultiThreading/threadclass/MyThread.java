package MultiThreading.threadclass;

public class MyThread extends Thread {

    @Override
    public void run(){

        System.out.println("Inside The Run Methode");
        System.out.println(Thread.currentThread().getName());

    }


}
