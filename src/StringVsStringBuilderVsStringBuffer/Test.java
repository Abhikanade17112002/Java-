package StringVsStringBuilderVsStringBuffer;

public class Test {
    public static void main(String[] args) {

        // =========================
        // 1. STRING (IMMUTABLE)
        // =========================
        System.out.println("----- STRING EXAMPLE -----");

        String str = "Hello";
        str.concat(" World"); // does NOT modify original

        System.out.println("After concat (without assignment): " + str);

        str = str.concat(" World"); // new object created and assigned
        System.out.println("After concat (with assignment): " + str);


        // =========================
        // 2. STRINGBUILDER (MUTABLE)
        // =========================
        System.out.println("\n----- STRINGBUILDER EXAMPLE -----");

        StringBuilder sb = new StringBuilder("Hello");
        sb.append(" World"); // modifies same object

        System.out.println("StringBuilder result: " + sb);


        // =========================
        // 3. STRINGBUFFER (MUTABLE + THREAD SAFE)
        // =========================
        System.out.println("\n----- STRINGBUFFER EXAMPLE -----");

        StringBuffer sbf = new StringBuffer("Hello");
        sbf.append(" World"); // modifies same object

        System.out.println("StringBuffer result: " + sbf);


        // =========================
        // 4. PERFORMANCE TEST (LOOP)
        // =========================
        System.out.println("\n----- PERFORMANCE TEST -----");

        // ❌ Using String (creates multiple objects)
        String x = "";
        for (int i = 0; i < 5; i++) {
            x += " ";
        }
        System.out.println("String length: " + x.length());

        // ✅ Using StringBuilder (efficient)
        StringBuilder y = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            y.append(" ");
        }
        System.out.println("StringBuilder length: " + y.length());


        // =========================
        // 5. THREAD SAFETY DEMO (Conceptual)
        // =========================
        System.out.println("\n----- THREAD SAFETY NOTE -----");

        System.out.println("StringBuilder is NOT thread-safe");
        System.out.println("StringBuffer is thread-safe (synchronized)");
    }
}