package src.entry;

import java.util.Scanner;

/**
 * Manages operations related to diary entries.
 */
public class EntryManager {
    private static EntryManager instance = null;

    /**
     * Ensures the class cannot be instantiated otherwise
     */
    private EntryManager() {
    }

    /**
     * Returns the singleton instance of EntryManager.
     * @return The EntryManager instance.
     */
    public static EntryManager getInstance() {
        if (instance == null) {
            instance = new EntryManager();
        }
        return instance;
    }

    /**
     * Adds media to an entry.
     * @param entry The entry object.
     */
    public void addMedia(Entry entry) {
        Scanner scanner = new Scanner(System.in);  
        System.out.println("Insert the image or media path: ");
        String media = scanner.nextLine();

        entry.setContent(media);
    }

    /**
     * Writes text to an entry.
     * @param entry The entry object.
     */
    public void writeText(Entry entry) {
        Scanner scanner = new Scanner(System.in);  
        System.out.println("Insert text: ");
        String input = scanner.nextLine();
        String text =  input.substring(0, 1).toUpperCase()
                        + input.substring(1); // This ensures that the first letter of the word is Uppercase.

        entry.setContent(text);
    }
}
