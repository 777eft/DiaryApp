package src;

import java.util.Scanner;

public class TextEntry extends Entry {
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text + "\n";
    }
    
    // Additional methods specific to text entries
    
}