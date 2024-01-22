package src.utils;
import java.util.Scanner;

public class UserInput {
    public static int startChoices() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\n");
        System.out.println("1) Text only entry");
        System.out.println("2) Text and Media entry");
        System.out.println("3) Set a reminder");

        int choice = Integer.parseInt(scanner.nextLine());

        return choice;
    }

    public static int readChoices() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the diary entry number:");

        int choice = Integer.parseInt(scanner.nextLine());

        return choice;
    }

    public static String userFeeling() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How are you feeling today?");
        String input = scanner.nextLine();
        String feeling = input.substring(0, 1).toUpperCase()
                        + input.substring(1); // This ensures that the first letter of the word is Uppercase.
        return feeling;
    }
}
