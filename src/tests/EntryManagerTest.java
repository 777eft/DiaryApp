package src.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import src.diary.Diary;
import src.diary.DiaryManager;
import src.entry.EntryManager;
import src.entry.MediaEntry;
import src.entry.TextEntry;
import src.page.Page;
import src.page.PageManager;

public class EntryManagerTest {
    
    @Test
    void testGetInstance() {
        EntryManager instance1 = EntryManager.getInstance();
        assertNotNull(instance1);
        
        EntryManager instance2 = EntryManager.getInstance();
        assertNotNull(instance2);
        
        assertSame(instance1, instance2);
    }
    
    @Test
    void testAddMedia() {
        EntryManager entryManager = EntryManager.getInstance();

        Diary diary = new Diary();
        Page page = DiaryManager.getInstance().createPage(diary);
        MediaEntry mediaEntry = PageManager.getInstance().addMediaEntryToPage(page);

        // Simulate user input
        entryManager.addMedia(mediaEntry);

        // Verify that content is set
        assertNotNull(mediaEntry.getContent());
        assertTrue(mediaEntry.getContent().length() > 0);
    }
    
    @Test
    void testWriteText() {
        EntryManager entryManager = EntryManager.getInstance();

        Diary diary = new Diary();
        Page page = DiaryManager.getInstance().createPage(diary);
        TextEntry textEntry = PageManager.getInstance().addTextEntryToPage(page);
        
        // Simulate user input
        entryManager.writeText(textEntry);
        
        // Verify that content is set
        assertNotNull(textEntry.getContent());
        assertTrue(textEntry.getContent().length() > 0);
        
        // Verify that the first letter of the content is uppercase
        assertEquals(Character.toUpperCase(textEntry.getContent().charAt(0)), textEntry.getContent().charAt(0));
    }
}
