package MultiThreading.ThreadLockTypes.IntrinsicLocks;

public class BankAccount {

    private int bankBalance = 100 ;

    public synchronized  void withdrawAmmount( int ammount ){

        System.out.println("Thread ==> " + Thread.currentThread().getName() + " Preparing To Withdraw Ammount");

        if( ammount <= bankBalance ){
            try{
                System.out.println("Thread ==> " + Thread.currentThread().getName() + " Ready To Withdraw Ammount");
                Thread.sleep(5000);

                this.bankBalance -= ammount ;

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread ==> " + Thread.currentThread().getName() + "  Withdraw Amount Successfull ");
        }
        else{
            System.out.println(" Insuffecient Bank Balance " );
        }
    }

    public int getBankBalance() {
        return bankBalance;
    }
}
