package Generics;


/*
* Generics Will Help With , Type Sefty And Manual Casting Errros
* */

import java.util.ArrayList;

public class Test {


    public static void main(String[] args) {
//        ArrayList list = new ArrayList() ;
//        // This Is By Default An Object Class Arraylist and will accept any type of Data Value Class
//
//        list.add("String") ;
//        list.add(123.5f);
//        list.add(1234567) ;
//        list.add(123.45345345);
//        list.add(true) ;
//        list.add(new ArrayList<>());


        Box<String> string  = new Box<>("Abhishek") ;
        System.out.println(string.getElement());

        Box<Integer> integer  = new Box<>(123) ;
        System.out.println(integer.getElement());
        Box<Double> ddouble  = new Box<>(123.123) ;
        System.out.println(ddouble.getElement());
        Box<Boolean> bboolean  = new Box<>(true) ;
        System.out.println(bboolean.getElement());



        KVBox<String,Boolean> kvBox = new KVBox<>("Abhishek Rangnath Kanade" , true) ;

        System.out.println(kvBox);


        BoundedGenericClass<Float> b =
                new BoundedGenericClass<>(123.31212f) ; // This Is Accepted

        System.out.println(b);


//        BoundedGenericClass<String> s =
//                new BoundedGenericClass<>(123.31212f) ; // This Is Not Accepted



        GenericInterfaceClass c = new GenericInterfaceClass() ;
        System.out.println("Addition ==> " + c.add(12.34,54.9));



        // Non Generic Class Can Have A Non Generic Constructor

        GenericConstructor d1 = new GenericConstructor(123) ;
        GenericConstructor d2 = new GenericConstructor("123") ;
        GenericConstructor d3 = new GenericConstructor(123.212) ;
        GenericConstructor d4 = new GenericConstructor(1232.3f) ;

        GenericEnum add = GenericEnum.ADD;

        System.out.println(add.apply(1,2));

        // Wild Card ( ? )  Generic Is Only Allowed Till The Read Only Purpose
        // Java Does Not Support The Generic Generic Exception Due To Type Erasure
        // means that generic type information is removed at the run time
        // Like Extends which sets the upper bound we can also use super which will set the lower bound
        
        
        
        
        // Read This Link ==> https://engineeringdigest.medium.com/generics-b158a743d18f

    }
}
