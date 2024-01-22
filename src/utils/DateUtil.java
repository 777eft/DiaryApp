package src.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import src.diary.Diary;

public class DateUtil {

    public static String formatDate(int year, int month, int day) {

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, day);

        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE dd MMM yyyy");
        Date date = calendar.getTime();
        return dateFormat.format(date);
    }

    public static int getDayOfYear(int month, int day) {
        int[] daysInMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int dayOfYear = 0;

        if ((Diary.getYear() % 4 == 0 && Diary.getYear() % 100 != 0) || (Diary.getYear() % 400 == 0)) {
            daysInMonth[2] = 29;
        }
        
        for (int i = 1; i < month; i++) {
            dayOfYear += daysInMonth[i];
        }
        dayOfYear += day;
        
        return dayOfYear;
    }
}
