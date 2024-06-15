import java.util.Scanner;

public class UserInput {
    public static void main(String[] args) {
        Scanner userInputScanner = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String userInput = userInputScanner.nextLine();
        System.out.println("Welcome " + userInput);
    }
}
