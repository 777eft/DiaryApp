package src.diary;

import java.util.ArrayList;
import src.page.Page;

public class Diary {
    private ArrayList<Page> pages;
    private int currentPageNumber;

    public Diary() {
        this.setPages(new ArrayList<Page>());
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
