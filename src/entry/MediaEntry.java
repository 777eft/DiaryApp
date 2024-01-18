package src.entry;

public class MediaEntry extends Entry {
    
    public MediaEntry() {
    }

    @Override
    public String toString() {
        return this.getContent() + "\n";
    }
}