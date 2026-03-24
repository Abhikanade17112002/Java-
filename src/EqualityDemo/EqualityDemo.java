package EqualityDemo;

public class EqualityDemo {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "hello";
        String s3 = new String("hello");

        System.out.println(s1 == s2);        // true (same string literal, interned)
        System.out.println(s1 == s3);        // false (different objects)
        System.out.println(s1.equals(s3));   // true (content equal)

        Integer i1 = 100;
        Integer i2 = 100;
        Integer i3 = new Integer(100);
        System.out.println(i1 == i2);        // true (cached)
        System.out.println(i1 == i3);        // false
    }
}
