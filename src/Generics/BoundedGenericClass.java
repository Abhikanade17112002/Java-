package Generics;


// This Class Can Only Have The Data Type That Can Be Passed
// To It That Is The Child Of Number Class Like Int , Double , Flot etc  And Not Like String



//also supposts extends class and interface
//public class BoundedGenericClass < T extends Number & interface >{
public class BoundedGenericClass < T extends Number>{

    private T number ;

    public BoundedGenericClass(T number) {
        this.number = number;
    }

    public T getNumber() {
        return number;
    }

    public void setNumber(T number) {
        this.number = number;
    }


    @Override
    public String toString() {
        return "BoundedGenericClass{" +
                "number=" + number +
                '}';
    }
}
