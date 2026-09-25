package datetime.time;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Covers LocalTime and LocalDateTime for a wall-clock time, with or without a date.
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
