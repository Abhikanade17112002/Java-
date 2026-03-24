package WrapperDemo;

public class WrapperDemo {

    public static void main(String[] args) {
        Integer a = 100;
        Integer b = 100;
        System.out.println(a == b);      // true (cached)
        System.out.println(a.equals(b)); // true
//        Java uses something called Integer Cache
//
//        Range: -128 to 127
//        Values in this range are reused (cached)
        Integer c = 200;
        Integer d = 200;
        System.out.println(c == d);      // false (not cached)
        System.out.println(c.equals(d)); // true

        // Autoboxing in expressions
        Integer i = 5;
        int j = i;                       // unboxing
        Integer k = j;                   // boxing

        // Null pointer risk
        // int n = null;                 // compilation error
        // Integer m = null;
        // int n2 = m;                   // NullPointerException at runtime
    }
}
