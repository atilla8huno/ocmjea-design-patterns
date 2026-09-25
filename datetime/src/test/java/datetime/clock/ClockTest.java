package datetime.clock;

import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Covers Clock so "now" can be fixed in tests instead of calling the system clock.
 */
class ClockTest {
    @Test
    void readsTodayFromAFixedClock() {
        Clock clock = Clock.fixed(Instant.parse("2026-09-25T12:00:00Z"), ZoneOffset.UTC);

        assertEquals(Instant.parse("2026-09-25T12:00:00Z"), Instant.now(clock));
        assertEquals(LocalDate.of(2026, 9, 25), LocalDate.now(clock));
        assertEquals(ZoneOffset.UTC, clock.getZone());
    }
}
