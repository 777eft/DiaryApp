package src;


public class Application {
    public static void main(String[] args) {
        Diary diary = new Diary();

        // TextEntry textEntry = diary.createTextEntry();
        // textEntry.writeText();
        // textEntry.saveEntryToFile();

        MediaEntry mediaEntry = diary.createMediaEntry();
        mediaEntry.writeText();
        mediaEntry.addMedia();
        mediaEntry.addMedia();
        mediaEntry.saveEntryToFile();

        // int selection;

        // do {
        //     selection = UserInput.startChoices();
        //     switch (selection) {
        //         case 1:
        //             TextEntry textEntry = entry.createTextEntry();
        //             diary.addEntry(textEntry);
        //             System.out.println("Placeholder for text only entry");
        //             break;
        //         case 2:
        //             MediaEntry mediaEntry = entry.createMediaEntry();
        //             diary.addEntry(mediaEntry);
        //             System.out.println("Placeholder for text and media entry");
        //             break;
        //         case 3:
        //             ReminderEntry reminderEntry = entry.createReminderEntry();
        //             diary.addEntry(reminderEntry);
        //             System.out.println("Placeholder for set a reminder to write entry");
        //             break;
        //     }
        // } while (selection != 4);
    }
}