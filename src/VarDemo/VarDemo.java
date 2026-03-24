package VarDemo;

public class VarDemo {
    public static void main(String[] args) {
        var name = "Alice";           // String
        var age = 25;                 // int
        var list = java.util.List.of(1,2,3); // List<Integer>

        // var cannot be used for fields, method parameters, or return types
        // var x;                      // error: cannot infer type without initializer

        System.out.println(name.getClass());
        System.out.println(age);
        System.out.println(list);
    }
}
