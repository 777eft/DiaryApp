package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Diary {
    private ArrayList<Page> entries;

    public Diary() {
        this.setEntries(new ArrayList<Page>());
    }

    public TextEntry createTextEntry() {
        TextEntry textEntry = new TextEntry();
        this.addEntry(textEntry);
        return textEntry;
    }

    public MediaEntry createMediaEntry() {
        MediaEntry mediaEntry = new MediaEntry();
        this.addEntry(mediaEntry);
        return mediaEntry;
    }

    public void addEntry(Page entry) {
        this.entries.add(entry);
    }

    public void removeEntry(Page entry) {
        entries.remove(entry);
    }

    public ArrayList<Page> getEntries() {
        return entries;
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
        for (Page entry : entries) {
            System.out.println(entry.getPageNum());
        }
    }

    public void setEntries(ArrayList<Page> entries) {
        this.entries = entries;
    }


}
