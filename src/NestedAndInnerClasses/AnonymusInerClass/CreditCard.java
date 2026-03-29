package NestedAndInnerClasses.AnonymusInerClass;

public class CreditCard implements Payment{
    @Override
    public void pay(Double totalCartAmmount) {
        System.out.println("Paid Ammount ==> " + totalCartAmmount + " Using Credit Card " );
    }
}
