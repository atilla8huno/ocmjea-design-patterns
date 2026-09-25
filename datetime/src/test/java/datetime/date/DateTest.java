package datetime.date;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Covers LocalDate for calendar dates without a time of day: parse, arithmetic and Period.
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
