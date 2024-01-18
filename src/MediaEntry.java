package src;

import java.util.ArrayList;
import java.util.Scanner;

public class MediaEntry extends Entry {
    private ArrayList<String> mediaFiles;
    
    public MediaEntry() {
        mediaFiles = new ArrayList<String>();
    }

    public void addMedia() {
        Scanner scanner = new Scanner(System.in);  
        System.out.println("Insert the image or media path: ");
        String content = scanner.nextLine();

        mediaFiles.add(content);
    }

    public ArrayList<String> getMediaFiles() {
        return mediaFiles;
    }

    public void setMediaFiles(ArrayList<String> mediaFiles) {
        this.mediaFiles = mediaFiles;
    }

    @Override
    public String toString() {
        return mediaFiles + "\n";
    }
}