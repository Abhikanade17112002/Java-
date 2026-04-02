package MultiThreading.synchronisation;

public class MyThread extends Thread{
    private Counter counter ;

    public MyThread( Counter counter){
      this.counter = counter ;
    }


    @Override
    public void run(){
        for( int i = 0 ; i < 1000 ; i++ ){
            this.counter.incrementCount();
        }
    }
}
