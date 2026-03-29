package NestedAndInnerClasses.LocalInnerClass;

public class Hotel {

    private String name ;

    private int totalNoOfRooms ;

    private int totalNoOfReservedRooms ;


    public Hotel( String name , int totalNoOfRooms , int totalNoOfReservedRooms ){
        this.name = name ;
        this.totalNoOfRooms = totalNoOfRooms ;
        this.totalNoOfReservedRooms = totalNoOfReservedRooms ;
    }


    public void reserveRoom(String guestName, int noOfRoom) {

        /*
         * Local Inner Class:
         * Used for validation logic limited to this method only
         */
        class RoomReservationValidator {

            public boolean validateReservation() {

                // 1. Validate guest name
                if (guestName == null || guestName.trim().isEmpty()) {
                    System.out.println("Guest name cannot be empty");
                    return false;
                }

                // 2. Validate number of rooms
                if (noOfRoom <= 0) {
                    System.out.println("Number of rooms must be greater than 0");
                    return false;
                }

                // 3. Max room limit per booking
                if (noOfRoom > 5) {
                    System.out.println("Cannot book more than 5 rooms");
                    return false;
                }

                // 4. Availability check
                int availableRooms = totalNoOfRooms - totalNoOfReservedRooms ;
                if (noOfRoom > availableRooms) {
                    System.out.println("Not enough rooms available");
                    return false;
                }

                // All validations passed
                totalNoOfReservedRooms += noOfRoom ;
                return true;
            }
        }

        // Create object of local inner class
        RoomReservationValidator validator = new RoomReservationValidator();

        // Call validation
        if (validator.validateReservation()) {
            System.out.println("Room booked successfully for " + guestName);
        } else {
            System.out.println("Reservation failed");
        }
    }
}
