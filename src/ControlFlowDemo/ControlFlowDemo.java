package ControlFlowDemo;

public class ControlFlowDemo {

    public static void main(String[] args) {
        // if-else
        int score = 85;
        if (score >= 90) {
            System.out.println("A");
        } else if (score >= 80) {
            System.out.println("B");
        } else {
            System.out.println("C or below");
        }

        // switch statement (old style)
        int day = 3;
        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            default:
                System.out.println("Other");
        }

        // switch expression (Java 12+)
        String dayName = switch (day) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            default -> "Other";
        };
        System.out.println("Day name: " + dayName);

        // switch with yield (for multi-line)
        int numLetters = switch (day) {
            case 1, 4 -> 6;
            case 2, 3 -> 9;
            default -> {
                System.out.println("Unknown");
                yield 0;
            }
        };
        System.out.println("Letters: " + numLetters);



        // traditional for
        for (int i = 0; i < 5; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        // for-each on array
        int[] numbers = {10, 20, 30};
        for (int n : numbers) {
            System.out.print(n + " ");
        }
        System.out.println();

        // while
        int i = 0;
        while (i < 3) {
            System.out.print(i + " ");
            i++;
        }
        System.out.println();

        // do-while
        int j = 0;
        do {
            System.out.print(j + " ");
            j++;
        } while (j < 3);
        System.out.println();

        // labelled break
        outer:
        for (int a = 0; a < 3; a++) {
            for (int b = 0; b < 3; b++) {
                if (a == 1 && b == 1) break outer;
                System.out.println("a=" + a + ", b=" + b);
            }
        }
        System.out.println("After labelled break");
    }
}
