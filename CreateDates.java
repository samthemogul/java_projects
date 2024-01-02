import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

class Createdates {
    public static void main(String args[]) {
        // Creating a LocalDate object with the current date
        LocalDate currentDate = LocalDate.now();
        System.out.println("Current Date: " + currentDate);

        // Creating a LocalDateTime object with the current date and time
        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println("Current Date and Time: " + currentDateTime);

        // Creating a ZonedDateTime object with the current date and time in a specific time zone
        ZonedDateTime currentZonedDateTime = ZonedDateTime.now();
        System.out.println("Current Date and Time with Time Zone: " + currentZonedDateTime);

        // Creating a LocalDate object with a specific date
        LocalDate specificDate = LocalDate.of(2023, 1, 31); // Replace these values with your desired date
        System.out.println("Specific Date: " + specificDate);

    }
}
