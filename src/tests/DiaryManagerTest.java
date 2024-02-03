package src.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

import src.diary.Diary;
import src.diary.DiaryManager;
import src.page.Page;

import java.util.ArrayList;

public class DiaryManagerTest {

    @Test
    public void testGetInstance() {
        DiaryManager instance1 = DiaryManager.getInstance();
        DiaryManager instance2 = DiaryManager.getInstance();
        assertNotNull(instance1);
        assertNotNull(instance2);
        assertEquals(instance1, instance2);
    }

    @Test
    public void testCreatePage() {
        Diary diary = new Diary();
        Page page = DiaryManager.getInstance().createPage(diary);
        assertNotNull(page);
        assertEquals(1, page.getPageNum());
    }

    @Test
    public void testDeletePage() {
        Diary diary = new Diary();
        Page page = DiaryManager.getInstance().createPage(diary);
        DiaryManager.getInstance().savePage(diary, page);
        int initialSize = diary.getPages().size();
        DiaryManager.getInstance().deletePage(diary, 1);
        assertEquals(initialSize - 1, diary.getPages().size());
    }

    @Test
    public void testSearchPage() {
        Diary diary = new Diary();
        Page page = DiaryManager.getInstance().createPage(diary);
        DiaryManager.getInstance().savePage(diary, page);
        Page foundPage = DiaryManager.getInstance().searchPage(diary, 1);
        assertNotNull(foundPage);
        assertEquals(page, foundPage);
    }

    @Test
    public void testSavePage() {
        Diary diary = new Diary();
        Page page = DiaryManager.getInstance().createPage(diary);
        page.setUserFeeling("Happy");
        DiaryManager.getInstance().savePage(diary, page);
        Page savedPage = diary.getPages().get(0);
        assertEquals("Happy", savedPage.getUserFeeling());
    }

    @Test
    public void testUpdatePageNumber() {
        Diary diary = new Diary();
        DiaryManager.getInstance().updatePageNumber(diary);
        assertEquals(2, diary.getCurrentPageNumber());
    }

    @Test
    public void testSortPages() {
        Diary diary = new Diary();
        Page page1 = new Page(1, "Happy", 2024, 1, 1);
        Page page2 = new Page(2, "Sad", 2024, 1, 2);
        DiaryManager.getInstance().savePage(diary, page1);
        DiaryManager.getInstance().savePage(diary, page2);

        ArrayList<Page> sortedPages = DiaryManager.getInstance().sortPages(diary);
        assertNotNull(sortedPages);
        assertEquals(1, sortedPages.size());
        assertEquals("Happy", sortedPages.get(0).getUserFeeling());
    }
}
