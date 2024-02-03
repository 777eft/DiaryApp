package src.page;

import org.junit.jupiter.api.Test;

import src.diary.Diary;
import src.diary.DiaryManager;
import src.entry.MediaEntry;
import src.entry.TextEntry;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PageManagerTest {

    @Test
    void testAddMediaEntryToPage() {
        Diary diary = new Diary();
        PageManager pageManager = PageManager.getInstance();
        Page page = DiaryManager.getInstance().createPage(diary);
        MediaEntry mediaEntry = pageManager.addMediaEntryToPage(page);
        assertTrue(page.getEntriesOnPage().contains(mediaEntry));
    }

    @Test
    void testAddTextEntryToPage() {
        Diary diary = new Diary();
        PageManager pageManager = PageManager.getInstance();
        Page page = DiaryManager.getInstance().createPage(diary);
        TextEntry textEntry = pageManager.addTextEntryToPage(page);
        assertTrue(page.getEntriesOnPage().contains(textEntry));
    }

    @Test
    void testFormatEntry() {
        Diary diary = new Diary();
        PageManager pageManager = PageManager.getInstance();
        Page page = DiaryManager.getInstance().createPage(diary);
        TextEntry textEntry = pageManager.addTextEntryToPage(page);
        textEntry.setContent("Sample text content");
        String formattedEntry = pageManager.formatEntry(page);
        assertTrue(formattedEntry.contains("Sample text content"));
    }

    @Test
    void testGetInstance() {
        PageManager pageManager1 = PageManager.getInstance();
        PageManager pageManager2 = PageManager.getInstance();
        assertEquals(pageManager1, pageManager2);
    }
}
