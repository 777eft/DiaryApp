package src.utils;

import java.util.Scanner;

/**
 * Utility class for user input operations.
 */
public class UserInput {
    
    /**
     * Displays the start menu and retrieves user choice.
     * @return The user's choice.
     */
    public static int startChoices() {
        Scanner scanner = new Scanner(System.in); // Create a Scanner object
        
        System.out.println("\n");
        System.out.println("1) Create a new page");
        System.out.println("2) Create a new page at a specific date");
        System.out.println("3) Add a text entry");
        System.out.println("4) Add a media entry");
        System.out.println("5) Save page");
        System.out.println("6) Save page to a .txt file");
        System.out.println("7) Filter pages by feeling");
        System.out.println("8) Read a page");
        System.out.println("9) Show saved pages");
        System.out.println("10) Exit");

        int choice = Integer.parseInt(scanner.nextLine()); // Read user input as integer
        
        return choice;
    }

    /**
     * Asks the user about their feeling and returns the capitalized version.
     * @return The capitalized user feeling.
     */
    public static String userFeeling() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How are you feeling today?");
        String input = scanner.nextLine();
        String feeling = input.substring(0, 1).toUpperCase()
                        + input.substring(1); // This ensures that the first letter of the word is Uppercase.

        return feeling;
    }
}
