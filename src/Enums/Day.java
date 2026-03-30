package Enums;

public enum Day {

    MONDAY("Monday" , "Somwar") ,
    TUESDAY("Tuesday","Mangalwar") ,
    WEDNESDAY("Wednesday","Budhwar") ,
    THURSDAY("Thursday","Guruwar") ,
    FRIDAY("Friday","Shukrawar") ,
    SATURDAY("Saturday","Shaniwar") ,
    SUNDAY("Sunday","Raviwar") ;


    String capitalCase  ;

    String hindi ;


    private Day(String day ,String hindi){
        this.capitalCase = day ;
        this.hindi = hindi ;
    }


    public String getDay(){
        return "Day ==> " + this.capitalCase + " Din ==> " + this.hindi ;
    }

}
