package ThreadLockTypes.IntrinsicLocks;

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
