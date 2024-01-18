package src;

import src.diary.Diary;
import src.diary.DiaryManager;
import src.entry.MediaEntry;
import src.entry.TextEntry;
import src.page.Page;
import src.page.PageManager;

public class Application {
    public static void main(String[] args) {
        Diary diary = new Diary();

        DiaryManager diaryManager = DiaryManager.getInstance();
        PageManager pageManager = PageManager.getInstance();
        
        Page page = diaryManager.createPage(diary);
        TextEntry textEntry = pageManager.addTextEntryToPage(page);
        textEntry.writeText();
        MediaEntry mediaEntry = pageManager.addMediaEntryToPage(page);
        mediaEntry.addMedia();
        pageManager.savePageToFile(page);

        Page page2 = diaryManager.createPage(diary);
        TextEntry textEntry2 = pageManager.addTextEntryToPage(page2);
        textEntry2.writeText();
        pageManager.savePageToFile(page2);

        // int selection;

        // do {
        //     selection = UserInput.startChoices();
        //     switch (selection) {
        //         case 1:
        //             TextEntry textEntry = entry.createTextEntry();
        //             diary.addEntry(textEntry);
        //             System.out.println("Placeholder for text only entry");
        //             break;
        //         case 2:
        //             MediaEntry mediaEntry = entry.createMediaEntry();
        //             diary.addEntry(mediaEntry);
        //             System.out.println("Placeholder for text and media entry");
        //             break;
        //         case 3:
        //             ReminderEntry reminderEntry = entry.createReminderEntry();
        //             diary.addEntry(reminderEntry);
        //             System.out.println("Placeholder for set a reminder to write entry");
        //             break;
        //     }
        // } while (selection != 4);
    }
}