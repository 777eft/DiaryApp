package src.tests;

import org.junit.jupiter.api.Test;

import src.utils.DateUtil;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DateUtilTest {

    @Test
    void testFormatDate() {
        // Test formatting a date
        String formattedDate = DateUtil.formatDate(2024, 2, 3);
        assertEquals("Sat 03 Feb 2024", formattedDate);
    }

    @Test
    void testGetDayOfYear() {
        // Test getting day of year for a non-leap year
        int dayOfYear = DateUtil.getDayOfYear(2, 15); // February 15th
        assertEquals(46, dayOfYear); // 31 (January) + 15

        // Test getting day of year for a leap year
        int leapYearDayOfYear = DateUtil.getDayOfYear(2, 15); // February 15th
        assertEquals(46, leapYearDayOfYear); // 31 (January) + 15
    }
}
