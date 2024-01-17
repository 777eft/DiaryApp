package src;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MediaEntry extends TextEntry {
    private ArrayList<Media> mediaFiles;
    
    public MediaEntry() {
        mediaFiles = new ArrayList<Media>();
    }

    public void addMedia() {
        Scanner scanner = new Scanner(System.in);  
        System.out.println("Insert the image or media path: ");
        String content = scanner.nextLine();

        Media media = this.createMedia(content);

        mediaFiles.add(media);
    }

    public Media createMedia(String content) {
        Media newMedia = new Media(content);
        return newMedia;
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
                this.getText() + "\n\n" + 
                this.showMedia() + "\n" +
                "Page " + this.getPageNum()
                );
            writeToFile.close();
            System.out.println("Successfully saved!");
        } catch (IOException e) {
            System.out.println("An error has occurred");
            e.printStackTrace();
        }
    }
    // Additional methods specific to media entries

    public String showMedia() {
        StringBuilder mediaString = new StringBuilder();
        for (Media media : mediaFiles) {
            mediaString.append(media).append("\n");
        }
        return mediaString.toString();
    }

    public ArrayList<Media> getMediaFiles() {
        return mediaFiles;
    }
}