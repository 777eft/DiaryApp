package src.diary;

import java.util.ArrayList;
import java.util.Collections;

import src.page.Page;

public class Diary {
    private ArrayList<Page> pages;
    private int currentPageNumber;

    public Diary() {
        this.setPages(new ArrayList<Page>(Collections.nCopies(365, null)));
        this.setCurrentPageNumber(1);
    }

    public ArrayList<Page> getPages() {
        return pages;
    }

    public void setPages(ArrayList<Page> pages) {
        this.pages = pages;
    }

    public int getCurrentPageNumber() {
        return currentPageNumber;
    }

    public void setCurrentPageNumber(int currentPageNumber) {
        this.currentPageNumber = currentPageNumber;
    }
}
