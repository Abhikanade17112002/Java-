package OOPS2;

import OOPS.ClassA;


public class Test {

    public static void main(String[] args) {
        ClassA a = new ClassA() ;

        ClassA.ClassB b = a.new ClassB() ;
    }
}
