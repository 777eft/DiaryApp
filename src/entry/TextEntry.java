package src.entry;

public class TextEntry extends Entry {

    public TextEntry() {
    }

    @Override
    public String toString() {
        return this.getContent() + "\n";
    }
}