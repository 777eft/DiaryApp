package src.entry;

/**
 * Represents a text entry in a diary page.
 */
public class TextEntry extends Entry {

    /**
     * Constructor for TextEntry class.
     */
    public TextEntry() {
    }

    /**
     * Returns a string representation of the text entry content.
     * @return String representation of the text entry content.
     */
    @Override
    public String toString() {
        return this.getContent() + "\n";
    }
}
