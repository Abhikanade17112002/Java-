package NestedAndInnerClasses.MemberInnerClass;

public class Test {
    public static void main(String[] args) {
        Car thar = new Car("Thar") ;
        System.out.printf(" %s %b \n",thar.model,thar.isEngineOn);

        Car.Enginee enginee = thar.new Enginee() ;

            enginee.start();
            enginee.start();
            enginee.stop();
            enginee.stop();

    }
}
