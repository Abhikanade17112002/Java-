package Generics;

public class GenericInterfaceClass implements GenericInterface<Double>{
    @Override
    public Double add(Double x, Double y) {
        return x + y ;
    }
}
