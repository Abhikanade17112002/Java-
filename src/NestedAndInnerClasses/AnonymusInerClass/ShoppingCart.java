package NestedAndInnerClasses.AnonymusInerClass;

public class ShoppingCart {
    private Double totalCartAmmount ;

    public ShoppingCart(Double totalCartAmmount){
        this.totalCartAmmount = totalCartAmmount ;
    }

    public void processPayment( Payment payment ){
        payment.pay(this.totalCartAmmount);
        System.out.println("Payment Completed");
    }
}
