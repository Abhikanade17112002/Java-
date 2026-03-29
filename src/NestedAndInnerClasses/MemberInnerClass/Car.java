package NestedAndInnerClasses.MemberInnerClass;

public class Car {

    public String model ;

    public Boolean isEngineOn ;

    public Car( String model ){
        this.model = model ;
        this.isEngineOn = false ;
    }


    // Member Inner Class Will Be Associated With The Class Object
    // And Will Behave As A Member Attribute

    public class Enginee{

        public void start(){

            if( !isEngineOn ){
                System.out.println("Starting Engine ==> " + model);
                isEngineOn = true ;
            }
            else {
                System.out.println("The Engine Of Model ==> " + model + " Is Already Started");
            }
        }

        public void stop(){

            if( isEngineOn ){
                System.out.println("Stopping Engine ==> " + model);
                isEngineOn = false ;
            }
            else {
                System.out.println("The Engine Of Model ==> " + model + " Is Already Stopped");

            }
        }
    }
}
