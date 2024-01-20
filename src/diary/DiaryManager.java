package src.diary;

import java.util.ArrayList;
import java.util.Scanner;

import src.entry.Entry;

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
        Scanner scanner = new Scanner(System.in);
        System.out.println("How are you feeling today?");
        String input = scanner.nextLine();
        String feeling = input.substring(0, 1).toUpperCase()
                        + input.substring(1); // This ensures that the first letter of the word is Uppercase.

        Page page = new Page(diary.getCurrentPageNumber(), feeling);

        return page;
        
    }

    public void deletePage(Diary diary, int indexToRemove) {
        diary.getPages().remove(indexToRemove - 1);
    }

    public Page searchPage(Diary diary, int pageNum) {
        return diary.getPages().get(pageNum - 1);
    }

    public void savePage(Diary diary, Page page) {
        diary.getPages().set(page.getPageNum() - 1, page);
        this.updatePageNumber(diary);
    }

    public void readPage(Diary diary, int entryNum) {
        Page pageToRead = diary.getPages().get(entryNum - 1);
        String content = "";

        for (Entry entry : pageToRead.getEntriesOnPage()) {
            content = content + entry.getContent() + "\n";
        }

        System.out.println(pageToRead.getDate() + "\n");
        System.out.println(pageToRead.getUserFeeling() + "\n");
        System.out.println("Dear Diary,");
        System.out.println(content + "\n");
        System.out.println("Page " + pageToRead.getPageNum());
    }

    public void updatePageNumber(Diary diary) {
        diary.setCurrentPageNumber(diary.getCurrentPageNumber() + 1);
    }

    public ArrayList<Page> sortPages(Diary diary) {
        ArrayList<Page> sortedPages = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Feeling to sort by: ");

        String input = scanner.nextLine();
        
        for (Page page : diary.getPages()) {
            if (page.getUserFeeling().equalsIgnoreCase(input)) {
                sortedPages.add(page);
            }
        }

        return sortedPages;
    }
}
