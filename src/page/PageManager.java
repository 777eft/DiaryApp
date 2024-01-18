package src.page;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import src.entry.Entry;
import src.entry.MediaEntry;
import src.entry.TextEntry;

public class PageManager {
    private static PageManager instance = null;

    private PageManager() {
    }
    
    public static PageManager getInstance() {
        if (instance == null) {
            instance = new PageManager();
        }
        return instance;
    }

    public TextEntry addTextEntryToPage(Page page) {
        TextEntry textEntry = new TextEntry();
        page.addEntry(textEntry);
        return textEntry;
    }

    public MediaEntry addMediaEntryToPage(Page page) {
        MediaEntry mediaEntry = new MediaEntry();
        page.addEntry(mediaEntry);
        return mediaEntry;
    }

    public void savePageToFile(Page page) {
        String entryDisplay = this.formatEntry(page);
        page.setFile(new File(
            "D:\\Jaden\\Documents\\jaden\\code\\DiaryApp\\entries\\day_" + 
            (page.getPageNum() + 1) + ".txt"
            ));
        try {
            FileWriter writeToFile = new FileWriter(
                "D:\\Jaden\\Documents\\jaden\\code\\DiaryApp\\entries\\day_" + 
                (page.getPageNum() + 1) + ".txt"
                );
            writeToFile.write(
                page.getDate() + "\n\nDear Diary,\n" +
                entryDisplay +
                "\n\nPage " + (page.getPageNum() + 1)
                );
            writeToFile.close();
            System.out.println("Successfully saved!");
        } catch (IOException e) {
            System.out.println("An error has occurred");
            e.printStackTrace();
        }
    }

    public String formatEntry(Page page) {
        String formattedOutput = "";
        for (Entry entry : page.getEntriesOnPage()) {
            formattedOutput += entry;
        }

        return formattedOutput;
    }
}
