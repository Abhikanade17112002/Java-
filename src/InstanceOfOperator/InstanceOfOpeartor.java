package InstanceOfOperator;

public class InstanceOfOpeartor {
    public static void main(String[] args) {
        Object obj = "Hello";
        System.out.println(obj instanceof String);   // true
        System.out.println(obj instanceof Object);   // true
        System.out.println(null instanceof String);  // false (null is not an instance)

        // Pattern matching (Java 16+)
        if (obj instanceof String s) {
            System.out.println("Length: " + s.length()); // s is already cast
        }


//        This does 3 things in one line:
//
//✔ Checks type → obj instanceof String
//✔ Casts → (String) obj
//✔ Assigns → s
//
//👉 Equivalent OLD code:
//
//        if (obj instanceof String) {
//            String s = (String) obj;
//            System.out.println(s.length());
//        }
    }
}
