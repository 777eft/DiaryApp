package src;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Page {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("EEE dd MMM yyyy");
    private String date;
    private int pageNum = 1;
    private ArrayList<Entry> entriesOnPage;
    private File file;

    public Page() {
        this.date = sdf.format(new Date());
        this.setPageNum(pageNum);
        this.setEntriesOnPage(new ArrayList<Entry>());
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

    public void addEntry(Entry entryToAdd) {
        this.entriesOnPage.add(entryToAdd);
    }

    public void updatePageNum() {
        this.setPageNum(this.pageNum += 1);
    }

    public void savePageToFile() {
        String entryDisplay = this.formatEntry();
        this.setFile(new File(
            "D:\\Jaden\\Documents\\jaden\\code\\DiaryApp\\entries\\day_" + 
            this.getPageNum() + ".txt"
            ));
        try {
            FileWriter writeToFile = new FileWriter(
                "D:\\Jaden\\Documents\\jaden\\code\\DiaryApp\\entries\\day_" + 
                this.getPageNum() + ".txt"
                );
            writeToFile.write(
                this.getDate() + "\n\nDear Diary,\n" +
                entryDisplay +
                "\n\nPage " + this.getPageNum()
                );
            writeToFile.close();
            System.out.println("Successfully saved!");
        } catch (IOException e) {
            System.out.println("An error has occurred");
            e.printStackTrace();
        }
    }

    public String formatEntry() {
        String formattedOutput = "";
        for (Entry entry : entriesOnPage) {
            formattedOutput += entry;
        }

        return formattedOutput;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public ArrayList<Entry> getEntriesOnPage() {
        return entriesOnPage;
    }

    public void setEntriesOnPage(ArrayList<Entry> pageContents) {
        this.entriesOnPage = pageContents;
    }    

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
