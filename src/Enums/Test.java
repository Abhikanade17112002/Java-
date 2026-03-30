package Enums;

public class Test {
    public static void main(String[] args) {
        System.out.println("Day ==> " + Day.MONDAY.name()+ " Ordinal " + Day.MONDAY.ordinal());
        System.out.println("Day ==> " + Day.TUESDAY.name()+ " Ordinal " + Day.TUESDAY.ordinal());
        System.out.println("Day ==> " + Day.WEDNESDAY.name()+ " Ordinal " + Day.WEDNESDAY.ordinal());
        System.out.println("Day ==> " + Day.THURSDAY.name()+ " Ordinal " + Day.THURSDAY.ordinal());
        System.out.println("Day ==> " + Day.FRIDAY.name()+ " Ordinal " + Day.FRIDAY.ordinal());
        System.out.println("Day ==> " + Day.SATURDAY.name()+ " Ordinal " + Day.SATURDAY.ordinal());
        System.out.println("Day ==> " + Day.SUNDAY.name()+ " Ordinal " + Day.SUNDAY.ordinal());


        System.out.println();

        for (Day day : Day.values()){
            System.out.printf(" Day ==> %s Ordinal ==> %d\n",day.name(),day.ordinal());
        }


        System.out.println();

        for (Day day : Day.values()){
            System.out.printf(day.getDay());
            System.out.println();
        }
    }
}
