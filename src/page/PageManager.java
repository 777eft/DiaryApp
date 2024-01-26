package src.page;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import src.entry.Entry;
import src.entry.MediaEntry;
import src.entry.TextEntry;

/**
 * Manages operations related to pages in a diary.
 */
public class PageManager {
    private static PageManager instance = null;

    /**
     * Ensures the class cannot be instantiated otherwise
     */
    private PageManager() {
    }
    
    /**
     * Returns the singleton instance of PageManager.
     * @return The PageManager instance.
     */
    public static PageManager getInstance() {
        if (instance == null) {
            instance = new PageManager();
        }
        return instance;
    }

    /**
     * Adds a text entry to the page.
     * @param page The page to add the text entry to.
     * @return The created text entry.
     */
    public TextEntry addTextEntryToPage(Page page) {
        TextEntry textEntry = new TextEntry();
        page.addEntry(textEntry);
        return textEntry;
    }

    /**
     * Adds a media entry to the page.
     * @param page The page to add the media entry to.
     * @return The created media entry.
     */
    public MediaEntry addMediaEntryToPage(Page page) {
        MediaEntry mediaEntry = new MediaEntry();
        page.addEntry(mediaEntry);
        return mediaEntry;
    }

    /**
     * Saves the page to a file.
     * @param page The page to save.
     */
    public void savePageToFile(Page page) {
        String entryDisplay = this.formatEntry(page); // Format the entries on the page
        page.setFile(new File(
            "D:\\Jaden\\Documents\\jaden\\code\\DiaryApp\\entries\\day_" + 
            page.getPageNum() + ".txt"
            )); // Set the file path for the page
        try {
            FileWriter writeToFile = new FileWriter(
                "D:\\Jaden\\Documents\\jaden\\code\\DiaryApp\\entries\\day_" + 
                page.getPageNum() + ".txt"
                ); // Create a FileWriter object
            writeToFile.write(
                page.getDate() + "\n\n" + 
                page.getUserFeeling() + 
                "\n\nDear Diary,\n" +
                entryDisplay +
                "\n\nPage " + page.getPageNum()
                ); // Write page content to file
            writeToFile.close(); // Close the FileWriter
            System.out.println("Successfully saved!"); // Print success message
        } catch (IOException e) { // Handle IOException
            System.out.println("An error has occurred"); // Print error message
            e.printStackTrace();
        }
    }

    /**
     * Formats the entries on the page.
     * @param page The page to format entries for.
     * @return The formatted entries.
     */
    public String formatEntry(Page page) {
        String formattedOutput = "";
        for (Entry entry : page.getEntriesOnPage()) {
            formattedOutput += entry; // Append each entry to the formatted output
        }

        return formattedOutput;
    }
}
