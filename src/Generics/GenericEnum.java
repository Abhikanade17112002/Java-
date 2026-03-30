package Generics;

public enum GenericEnum {
    ADD,SUBTRACT,MULTIPLY,DIVIDE ;
    public  <T extends Number>  double apply( T x , T y ){

        switch (this){
            case ADD : return x.doubleValue()  + y.doubleValue() ;

            case SUBTRACT:  return x.doubleValue()  - y.doubleValue() ;

            case MULTIPLY : return x.doubleValue()  * y.doubleValue() ;

            case DIVIDE : return x.doubleValue()  / y.doubleValue() ;


            default: throw new RuntimeException() ;

        }

    }
}
