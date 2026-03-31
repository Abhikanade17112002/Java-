package synchronisation;

public class Counter {

    private int count = 0 ;

//    public void incrementCount(){
//        this.count++ ;
//    }

//    public synchronized void incrementCount(){
//        this.count++ ;
//    }

// Other Than A Methode A Block Of The Code Can Also Be Synchronised
    public  void incrementCount(){
        synchronized (this) {
            this.count++;
        }
    }

    public int getCount(){
        return this.count ;
    }
}
