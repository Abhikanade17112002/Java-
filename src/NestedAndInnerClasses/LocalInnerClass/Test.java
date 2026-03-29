package NestedAndInnerClasses.LocalInnerClass;

public class Test {
    public static void main(String[] args) {

        // Create hotel with 10 rooms, 2 already reserved
        Hotel hotel = new Hotel("Taj", 10, 2);

        System.out.println("---- Test Case 1: Valid Booking ----");
        hotel.reserveRoom("Abhishek", 2);

        System.out.println("\n---- Test Case 2: Empty Guest Name ----");
        hotel.reserveRoom("", 2);

        System.out.println("\n---- Test Case 3: Zero Rooms ----");
        hotel.reserveRoom("Rahul", 0);

        System.out.println("\n---- Test Case 4: Exceed Max Limit (5) ----");
        hotel.reserveRoom("Amit", 6);

        System.out.println("\n---- Test Case 5: Not Enough Rooms ----");
        hotel.reserveRoom("Neha", 9);

        System.out.println("\n---- Test Case 6: Boundary Case (Exact Available) ----");
        hotel.reserveRoom("Priya", 6); // depends on previous bookings

        System.out.println("\n---- Test Case 7: Multiple Valid Bookings ----");
        hotel.reserveRoom("Karan", 1);
        hotel.reserveRoom("Simran", 2);
    }
}