package MultiThreading.ThreadLockTypes.ExplicitLocks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {

    private int bankBalance = 100 ;

    private final Lock lock = new ReentrantLock() ;

    public void withdrawAmmount( int ammount ){

        System.out.println("Thread ==> " + Thread.currentThread().getName() + " Preparing To Withdraw Ammount");
        try {
            if (lock.tryLock(2000, TimeUnit.MILLISECONDS)) {
                if (ammount <= bankBalance) {
                    try {
                        System.out.println("Thread ==> " + Thread.currentThread().getName() + " Ready To Withdraw Ammount");
                        Thread.sleep(5000);

                        this.bankBalance -= ammount;

                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Thread ==> " + Thread.currentThread().getName() + "  Withdraw Amount Successfull ");
                } else {
                    System.out.println(" Insuffecient Bank Balance ");
                }
            }
            else {
                System.out.println("Current Thread ==> "+ Thread.currentThread().getName() +" Failed To Acquire The Lock  ");
            }

        } catch (Exception e) {
            System.out.println("Current Thread ==> "+ Thread.currentThread().getName() +" Exception ==> " + e);
        }
    }

    public int getBankBalance() {
        return bankBalance;
    }
}
