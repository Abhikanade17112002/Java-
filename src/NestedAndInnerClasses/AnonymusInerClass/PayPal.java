package NestedAndInnerClasses.AnonymusInerClass;

public class PayPal implements Payment{
    @Override
    public void pay(Double totalCartAmmount) {
        System.out.println("Paid Ammount ==> " + totalCartAmmount + " Using Pay Pal " );
    }
}
