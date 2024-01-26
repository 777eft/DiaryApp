package src.page;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import src.entry.Entry;
import src.utils.DateUtil;

/**
 * Represents a page in a diary.
 */
public class Page {
    // Date format for displaying date on the page
    private static final SimpleDateFormat sdf = new SimpleDateFormat("EEE dd MMM yyyy");
    
    private String date;
    private String userFeeling; // Feeling recorded for the day
    private int pageNum;
    private ArrayList<Entry> entriesOnPage;
    private File file;

    /**
     * Constructor for creating a page with the current date.
     * @param pageNum The page number.
     * @param feeling The user feeling for the day.
     */
    public Page(int pageNum, String feeling) {
        // Get current date and format it
        this.date = sdf.format(new Date());
        this.setDate(date); // Set formatted date
        this.setUserFeeling(feeling); // Set user feeling
        this.setPageNum(pageNum); // Set page number
        this.setEntriesOnPage(new ArrayList<Entry>()); // Initialize entries list
    }

    /**
     * Constructor for creating a page with a specific date.
     * @param pageNum The page number.
     * @param feeling The user feeling for the day.
     * @param year The year of the date.
     * @param month The month of the date.
     * @param day The day of the date.
     */
    public Page(int pageNum, String feeling, int year, int month, int day) {
        // Format the provided date
        this.date = DateUtil.formatDate(year, month, day);
        this.setDate(date);
        this.setUserFeeling(feeling);
        this.setPageNum(pageNum);
        this.setEntriesOnPage(new ArrayList<Entry>());
    }

    /**
     * Adds an entry to the page.
     * @param entryToAdd The entry to add.
     */
    public void addEntry(Entry entryToAdd) {
        this.entriesOnPage.add(entryToAdd); // Add the entry to the entries list
    }

    /**
     * Gets the date of the page.
     * @return The date of the page.
     */
    public String getDate() {
        return date;
    }

    /**
     * Sets the date of the page.
     * @param date The date to set.
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Gets the user feeling for the day.
     * @return The user feeling.
     */
    public String getUserFeeling() {
        return userFeeling;
    }

    /**
     * Sets the user feeling for the day.
     * @param userFeeling The user feeling to set.
     */
    public void setUserFeeling(String userFeeling) {
        this.userFeeling = userFeeling;
    }

    /**
     * Gets the page number.
     * @return The page number.
     */
    public int getPageNum() {
        return pageNum;
    }

    /**
     * Sets the page number.
     * @param pageNum The page number to set.
     */
    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    /**
     * Gets the list of entries on the page.
     * @return The list of entries.
     */
    public ArrayList<Entry> getEntriesOnPage() {
        return entriesOnPage;
    }

    /**
     * Sets the list of entries on the page.
     * @param pageContents The list of entries to set.
     */
    public void setEntriesOnPage(ArrayList<Entry> pageContents) {
        this.entriesOnPage = pageContents;
    }    

    /**
     * Gets the file associated with the page.
     * @return The file associated with the page.
     */
    public File getFile() {
        return file;
    }

    /**
     * Sets the file associated with the page.
     * @param file The file to set.
     */
    public void setFile(File file) {
        this.file = file;
    }
}
