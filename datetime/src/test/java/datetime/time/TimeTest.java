package datetime.time;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * LocalTime and LocalDateTime
 *
 * LocalTime is a wall-clock time of day (09:30) with no date. Combine it
 * with a LocalDate to get LocalDateTime. Neither type knows a time zone;
 * attach a ZoneId when you need an instant.
 *
 * This test combines a date with a time of day.
 */
class TimeTest {
    @Test
    void combinesADateWithATimeOfDay() {
        LocalTime time = LocalTime.parse("09:30");
        LocalDateTime dateTime = LocalDateTime.of(LocalDate.parse("2026-09-25"), time);

        assertEquals(9, time.getHour());
        assertEquals(30, time.getMinute());
        assertEquals(LocalTime.of(11, 0), time.plusMinutes(90));
        assertEquals(LocalDateTime.parse("2026-09-25T09:30"), dateTime);
    }
}
