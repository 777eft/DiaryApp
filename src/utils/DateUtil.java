package src.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import src.diary.Diary;

/**
 * Utility class for date-related operations.
 */
public class DateUtil {

    /**
     * Formats the provided year, month, and day into a string date representation.
     * @param year The year.
     * @param month The month.
     * @param day The day.
     * @return The formatted date string.
     */
    public static String formatDate(int year, int month, int day) {

        Calendar calendar = Calendar.getInstance(); // Get a calendar instance
        calendar.set(Calendar.YEAR, year); // Set the year
        calendar.set(Calendar.MONTH, month - 1); // Set the month (Note: Calendar.MONTH is 0-based)
        calendar.set(Calendar.DAY_OF_MONTH, day); // Set the day

        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE dd MMM yyyy"); // Create a date format
        Date date = calendar.getTime(); // Get the date from calendar
        return dateFormat.format(date);
    }

    /**
     * Calculates the day of year based on the provided month and day.
     * @param month The month.
     * @param day The day.
     * @return The day of year.
     */
    public static int getDayOfYear(int month, int day) {
        int[] daysInMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; // Array to store days in each month
        int dayOfYear = 0;

        // Adjust February days in leap years
        if ((Diary.getYear() % 4 == 0 && Diary.getYear() % 100 != 0) || (Diary.getYear() % 400 == 0)) {
            daysInMonth[2] = 29; // Leap year, February has 29 days
        }
        
        // Calculate day of year
        for (int i = 1; i < month; i++) {
            dayOfYear += daysInMonth[i]; // Add days of each month before the given month
        }
        dayOfYear += day; // Add the given day
        
        return dayOfYear;
    }
}
