package src.diary;

import java.util.ArrayList;
import java.util.Scanner;

import src.entry.Entry;
import src.page.Page;
import src.utils.DateUtil;
import src.utils.UserInput;

/**
 * Manages operations related to a diary.
 */
public class DiaryManager {
    private static DiaryManager instance = null;
    
    /**
     * Ensures the class cannot be instantiated otherwise
     */
    private DiaryManager() {
    }
    
    /**
     * Returns the singleton instance of DiaryManager.
     * @return The DiaryManager instance.
     */
    public static DiaryManager getInstance() {
        if (instance == null) {
            instance = new DiaryManager();
        }
        return instance;
    }

    /**
     * Creates a new page in the diary.
     * @param diary The diary object.
     * @return The newly created page.
     */
    public Page createPage(Diary diary) {
        String feeling = UserInput.userFeeling(); // Prompt user for feeling
        Page page = new Page(diary.getCurrentPageNumber(), feeling); // Create new page with current page number and feeling
        return page; // Return the created page
    }

    /**
     * Creates a page at a specific date.
     * @param diary The diary object.
     * @return The page created at the specified date.
     */
    public Page createPageAtDate(Diary diary) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Month in number: ");
        int month = scanner.nextInt();
        System.out.println("Enter the Day of the month: ");
        int day  = scanner.nextInt();

        int dayOfYear = DateUtil.getDayOfYear(month, day); // Get day of year from DateUtil

        String feeling = UserInput.userFeeling(); // Prompt user for feeling
        Page pageAtDate = new Page(dayOfYear, feeling, Diary.getYear(), month, day); // Create new page with specified date
        return pageAtDate;
    }

    /**
     * Deletes a page from the diary.
     * @param diary The diary object.
     * @param indexToRemove The index of the page to remove.
     */
    public void deletePage(Diary diary, int indexToRemove) {
        diary.getPages().remove(indexToRemove - 1); // Remove page from diary at specified index
    }

    /**
     * Searches for a page in the diary.
     * @param diary The diary object.
     * @param pageNum The page number to search for.
     * @return The found page.
     */
    public Page searchPage(Diary diary, int pageNum) {
        return diary.getPages().get(pageNum - 1); // Get page from diary at specified page number
    }

    /**
     * Saves a page in the diary.
     * @param diary The diary object.
     * @param page The page to save.
     */
    public void savePage(Diary diary, Page page) {
        diary.getPages().set(page.getPageNum() - 1, page); // Set page in diary at specified page number
        this.updatePageNumber(diary); // Update current page number
    }

    /**
     * Reads a page from the diary.
     * @param diary The diary object.
     */
    public void readPage(Diary diary) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Month in number: ");
        int month = scanner.nextInt();
        System.out.println("Enter the Day of the month: ");
        int day  = scanner.nextInt();

        int dayOfYear = DateUtil.getDayOfYear(month, day); // Get day of year from DateUtil

        Page pageToRead = diary.getPages().get(dayOfYear - 1); // Get page from diary at calculated index
        String content = "";
        for (Entry entry : pageToRead.getEntriesOnPage()) {
            content = content + entry.getContent() + "\n";
        }

        System.out.println(pageToRead.getDate() + "\n");
        System.out.println(pageToRead.getUserFeeling() + "\n");
        System.out.println("Dear Diary,");
        System.out.println(content + "\n");
        System.out.println("Page " + pageToRead.getPageNum());
    }

    /**
     * Updates the current page number in the diary.
     * @param diary The diary object.
     */
    public void updatePageNumber(Diary diary) {
        diary.setCurrentPageNumber(diary.getCurrentPageNumber() + 1); // Increment current page number
    }

    /**
     * Sorts pages in the diary by user feeling.
     * @param diary The diary object.
     * @return The sorted list of pages.
     */
    public ArrayList<Page> sortPages(Diary diary) {
        ArrayList<Page> sortedPages = new ArrayList<>();
        Scanner scanner = new Scanner(System.in); 
        System.out.println("Feeling to sort by: ");
        String input = scanner.nextLine();

        for (Page page : diary.getPages()) { // Iterate through pages in diary
            if (page.getUserFeeling().equalsIgnoreCase(input)) { // If page feeling matches input
                sortedPages.add(page); // Add page to sorted list
            }
        }
        return sortedPages;
    }
}
