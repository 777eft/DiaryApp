package src.entry;

public class EntryManager {
    private static EntryManager instance = null;

    private EntryManager() {

    }
    
    public static EntryManager getInstance() {
        if (instance == null) {
            instance = new EntryManager();
        }
        return instance;
    }
}
