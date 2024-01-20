package src.diary;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import src.page.Page;

public class DiaryManager {
    private static DiaryManager instance = null;

    private DiaryManager() {
    }
    
    public static DiaryManager getInstance() {
        if (instance == null) {
            instance = new DiaryManager();
        }
        return instance;
    }

    public Page createPage(Diary diary) {
        Page page = new Page(diary.getCurrentPageNumber());
        return page;
    }

    public void addPage(Diary diary, Page pageToAdd) {
        diary.getPages().add(pageToAdd);
    }

    public void deletePage(Diary diary, int indexToRemove) {
        diary.getPages().remove(indexToRemove - 1);
    }

    public Page searchPage(Diary diary, int pageNum) {
        return diary.getPages().get(pageNum - 1);
    }

    public void savePage(Diary diary, Page page) {
        this.addPage(diary, page);
        this.updatePageNumber(diary);
    }

    public void readPage(Diary diary, int entryNum) {
        File currentFile = new File(
            "D:\\Jaden\\Documents\\jaden\\code\\DiaryApp\\entries\\day_" + 
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

    public void updatePageNumber(Diary diary) {
        diary.setCurrentPageNumber(diary.getCurrentPageNumber() + 1);
    }
}
