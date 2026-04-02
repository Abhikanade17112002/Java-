package MultiThreading.synchronisation;

public class Test {
    public static void main(String[] args) {
        Counter counter  = new Counter() ;

        MyThread t1 = new MyThread(counter) ;
        MyThread t2 = new MyThread(counter) ;


        try{
            t1.start();
            t2.start();
            t1.join();
            t2.join();


            System.out.println("Count ==> " + counter.getCount());
        } catch (Exception e) {
            System.out.println("Exception E ==> " + e );
        }
    }
}
