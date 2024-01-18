package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import src.page.Page;

public class Diary {
    private ArrayList<Page> pages;

    public Diary() {
        this.setPages(new ArrayList<Page>());
    }

    public Page createPage() {
        Page page = new Page();
        this.addPage(page);
        return page;
    }

    public void addPage(Page pageToAdd) {
        this.pages.add(pageToAdd);
    }

    public void readPage(int entryNum) {
        File currentFile = new File(
            "D:\\Jaden\\Documents\\jaden\\code\\DiaryApp\\entries\\day" + 
            entryNum + ".txt"
            );
        try {
            Scanner reader = new Scanner(currentFile);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                System.out.println(data);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Entry for this number does not exist. Please try again");
        }
    }

    public void showAvailableEntries() {
        System.out.println("Available Diary Entries: ");
        for (Page entry : pages) {
            System.out.println(entry.getPageNum());
        }
    }

    public ArrayList<Page> getPages() {
        return pages;
    }

    public void setPages(ArrayList<Page> pages) {
        this.pages = pages;
    }

    
}
