package src;

import src.diary.Diary;
import src.diary.DiaryManager;
import src.entry.EntryManager;
import src.entry.MediaEntry;
import src.entry.TextEntry;
import src.entry.Entry;
import src.page.Page;
import src.page.PageManager;

public class Application {
    public static void main(String[] args) {
        Diary diary = new Diary();
        System.out.println(diary.getCurrentPageNumber());

        DiaryManager diaryManager = DiaryManager.getInstance();
        PageManager pageManager = PageManager.getInstance();
        EntryManager entryManager = EntryManager.getInstance();
        
        Page page = diaryManager.createPage(diary);
        TextEntry textEntry = pageManager.addTextEntryToPage(page);
        entryManager.writeText(textEntry);
        MediaEntry mediaEntry = pageManager.addMediaEntryToPage(page);
        entryManager.addMedia(mediaEntry);
        diaryManager.savePage(diary, page);

        System.out.println(diaryManager.sortPages(diary));

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