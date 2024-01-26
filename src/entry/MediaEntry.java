package src.entry;

/**
 * Represents a media entry in a diary page.
 */
public class MediaEntry extends Entry {
    
    /**
     * Constructor for MediaEntry class.
     */
    public MediaEntry() {
    }

    /**
     * Returns a string representation of the media entry content.
     * @return String representation of the media entry content.
     */
    @Override
    public String toString() {
        return this.getContent() + "\n";
    }
}
