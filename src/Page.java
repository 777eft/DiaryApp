package src;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Page {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("EEE dd MMM yyyy");
    private String date;
    private int pageNum = 1;
    private File file;

    public Page() {
        this.date = sdf.format(new Date());
        this.setPageNum(pageNum);
    }

    public void saveEntryToFile() {
        System.out.println("Save entry to file");
    }

    public void deleteEntryfromFile() {
        System.out.println("Delete entry from file");
    }

    public void updatePageNum() {
        this.setPageNum(this.pageNum += 1);
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

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
