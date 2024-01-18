package src.diary;

import java.util.ArrayList;
import src.page.Page;

public class Diary {
    private ArrayList<Page> pages;

    public Diary() {
        this.setPages(new ArrayList<Page>());
    }

    public ArrayList<Page> getPages() {
        return pages;
    }

    public void setPages(ArrayList<Page> pages) {
        this.pages = pages;
    }
}
