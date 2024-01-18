package src.entry;

import java.util.Scanner;

public class TextEntry extends Entry {

    public TextEntry() {
    }

    public void writeText() {
        Scanner scanner = new Scanner(System.in);  
        System.out.println("Diary Entry: ");
        String text = scanner.nextLine();
        
        this.setContent(text);
    }

    public void editText() {
        // Implement text editing functionality
    }

    @Override
    public String toString() {
        return this.getContent() + "\n";
    }
}