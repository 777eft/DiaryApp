package src;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TextEntry extends Page {
    private String text;

    public TextEntry() {
    }

    public void writeText() {
        Scanner scanner = new Scanner(System.in);  
        System.out.println("Diary Entry: ");
        String content = scanner.nextLine();
        
        this.setText(content);
    }

    public void editText() {
        // Implement text editing functionality
    }

    @Override
    public void saveEntryToFile() {
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
                this.getText() +
                "\n\nPage " + this.getPageNum()
                );
            writeToFile.close();
            System.out.println("Successfully saved!");
        } catch (IOException e) {
            System.out.println("An error has occurred");
            e.printStackTrace();
        }
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    // Additional methods specific to text entries
}