package src.entry;

import java.util.Scanner;

public class EntryManager {
    private static EntryManager instance = null;

    private EntryManager() {
    }

    public static EntryManager getInstance() {
        if (instance == null) {
            instance = new EntryManager();
        }
        return instance;
    }

    public void addMedia(Entry entry) {
        Scanner scanner = new Scanner(System.in);  
        System.out.println("Insert the image or media path: ");
        String media = scanner.nextLine();

        entry.setContent(media);
    }

    public void writeText(Entry entry) {
        Scanner scanner = new Scanner(System.in);  
        System.out.println("Insert text: ");
        String input = scanner.nextLine();
        String text =  input.substring(0, 1).toUpperCase()
                        + input.substring(1); // This ensures that the first letter of the word is Uppercase.

        entry.setContent(text);
    }

    public void editText() {
        // Implement text editing functionality
    }
}
