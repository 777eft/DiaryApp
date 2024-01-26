package src.diary;

import java.util.ArrayList;
import java.util.Collections;

import src.page.Page;

/**
 * Represents a Diary
 */
public class Diary {
    private ArrayList<Page> pages;
    private static final int YEAR = 2024;
    private int currentPageNumber;

    /**
     * Constructor for Diary class.
     */
    public Diary() {
        this.setPages(new ArrayList<Page>(Collections.nCopies(365, null)));
        this.setCurrentPageNumber(1);
    }

    /**
     * Getter for pages.
     * @return ArrayList of Page objects.
     */
    public ArrayList<Page> getPages() {
        return pages;
    }

    /**
     * Setter for pages.
     * @param pages ArrayList of Page objects.
     */
    public void setPages(ArrayList<Page> pages) {
        this.pages = pages;
    }

    /**
     * Getter for year.
     * @return The year constant.
     */
    public static int getYear() {
        return YEAR;
    }

    /**
     * Getter for current page number.
     * @return The current page number.
     */
    public int getCurrentPageNumber() {
        return currentPageNumber;
    }

    /**
     * Setter for current page number.
     * @param currentPageNumber The current page number to set.
     */
    public void setCurrentPageNumber(int currentPageNumber) {
        this.currentPageNumber = currentPageNumber;
    }
}
