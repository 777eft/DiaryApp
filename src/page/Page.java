package src.page;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import src.entry.Entry;


public class Page {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("EEE dd MMM yyyy");
    private String date;
    private int pageNum;
    private ArrayList<Entry> entriesOnPage;
    private File file;

    public Page(int pageNum) {
        this.date = sdf.format(new Date());
        this.setDate(date);
        this.setPageNum(pageNum);
        this.setEntriesOnPage(new ArrayList<Entry>());
    }

    public void addEntry(Entry entryToAdd) {
        this.entriesOnPage.add(entryToAdd);
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public ArrayList<Entry> getEntriesOnPage() {
        return entriesOnPage;
    }

    public void setEntriesOnPage(ArrayList<Entry> pageContents) {
        this.entriesOnPage = pageContents;
    }    

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
