package NestedAndInnerClasses.AnonymusInerClass;

public class Test {
    public static void main(String[] args) {



        // Manual Way

        ShoppingCart shoppingCart = new ShoppingCart(154.345);

        CreditCard creditCard = new CreditCard() ;
        PayPal payPal = new PayPal() ;

        shoppingCart.processPayment( creditCard );

        shoppingCart.processPayment(payPal);


        // Ananomous Inner Class Way
        /*
        * Preferred When You Dont Want The Implementtaion
        * Class Of The Interface And Want An On The Go One Time Use Object
        * */

        shoppingCart.processPayment(new Payment() {
            @Override
            public void pay(Double totalCartAmmount) {
                System.out.println("Paid Using The Ananomous Inner Class Payment Method");
            }
        });
    }
}
