package Generics;


// Non Generic Class Can Hve A Generic Constructor
public class GenericConstructor {

    public <T> GenericConstructor( T x ){
        System.out.println("  <T> x  = " + x);
    }
}
