package src.entry;

import java.util.Scanner;

public class MediaEntry extends Entry {
    
    public MediaEntry() {
    }

    public void addMedia() {
        Scanner scanner = new Scanner(System.in);  
        System.out.println("Insert the image or media path: ");
        String media = scanner.nextLine();

        this.setContent(media);
    }

    @Override
    public String toString() {
        return this.getContent() + "\n";
    }
}