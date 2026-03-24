package  LiteralsAndTypeConversion ;
public class LiteralsAndTypeConversion {
    public static void main(String[] args) {
        int hex = 0x1A;       // 26
        int bin = 0b1101;     // 13
        long big = 100_000_000_000L;
        float f = 3.14F;
        double d = 3.14;      // default double

        System.out.println("hex: " + hex);
        System.out.println("bin: " + bin);
        System.out.println("long: " + big);
        System.out.println("float: " + f);
        System.out.println("double: " + d);

        // Widening (implicit)
        int i = 10;
        long l = i;           // OK
        double d2 = i;        // OK

        // Narrowing (explicit cast)
        long l2 = 1000L;
        int i2 = (int) l2;    // OK, but may lose data
        int i3 = (int) 10_000_000_000L; // overflow
        System.out.println("i3 after overflow: " + i3);
    }
}
