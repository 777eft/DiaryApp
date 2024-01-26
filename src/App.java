package src;

import src.diary.Diary;
import src.diary.DiaryManager;
import src.entry.EntryManager;
import src.entry.MediaEntry;
import src.entry.TextEntry;
import src.page.Page;
import src.page.PageManager;
import src.utils.UserInput;

/**
 * Main class representing the diary application.
 */
public class App {
    public static void main(String[] args) {
        // Initialise managers and objects
        DiaryManager diaryManager = DiaryManager.getInstance();
        PageManager pageManager = PageManager.getInstance();
        EntryManager entryManager = EntryManager.getInstance();

        Diary diary = new Diary(); // Create a new diary
        Page page = null; // Initialise page as null
        TextEntry textEntry; // Text entry object
        MediaEntry mediaEntry; // Media entry object

        boolean pageCreated = false; // Flag to track if page is created
        
        int selection; // User selection

        // Main menu loop
        do {
            selection = UserInput.startChoices(); // Get user choice
            
            // Check if page is created before certain actions
            if (!pageCreated && selection >= 3 && selection <= 8) {
                System.out.println("Please create a page first."); // Prompt user to create a page
                continue; // Continue to next iteration
            }
            
            // Handle user selection
            switch (selection) {
                case 1:
                    page = diaryManager.createPage(diary); // Create a new page
                    pageCreated = true; // Set pageCreated flag to true
                    break;
                case 2:
                    page = diaryManager.createPageAtDate(diary); // Create a new page with specific date
                    pageCreated = true; // Set pageCreated flag to true
                    break;
                case 3:
                    textEntry = pageManager.addTextEntryToPage(page); // Add a text entry to the page
                    entryManager.writeText(textEntry); // Write text entry content
                    break;
                case 4:
                    mediaEntry = pageManager.addMediaEntryToPage(page); // Add a media entry to the page
                    entryManager.addMedia(mediaEntry); // Add media content
                    break;
                case 5:
                    diaryManager.savePage(diary, page); // Save page
                    break;
                case 6:
                    pageManager.savePageToFile(page); // Save page to file
                    break;
                case 7:
                    diaryManager.sortPages(diary); // Filter pages by feeling
                    break;
                case 8:
                    diaryManager.readPage(diary); // Read a page
                    break;
                case 9:
                    System.out.println(diary.getPages()); // Show saved pages
                    break;
                case 10:
                    System.exit(0); // Exit the application
                    break;
            }
        } while (selection != 10); // Repeat until user chooses to exit
    }
}
