package datetime.date;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * LocalDate
 *
 * A calendar date with no time of day and no zone (2026-09-25). Parse it,
 * add weeks or months, and measure a Period between two dates. Use
 * LocalDateTime when you also need the clock time.
 *
 * This test parses a date, shifts it and checks the Period.
 */
class DateTest {
    @Test
    void parsesAndShiftsACalendarDate() {
        LocalDate start = LocalDate.parse("2026-09-25");

        assertEquals(2026, start.getYear());
        assertEquals(Month.SEPTEMBER, start.getMonth());
        assertEquals(LocalDate.of(2026, 10, 2), start.plusDays(7));
        assertEquals(Period.ofDays(7), Period.between(start, start.plusWeeks(1)));
    }
}
