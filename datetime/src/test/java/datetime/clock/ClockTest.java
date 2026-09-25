package datetime.clock;

import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Clock
 *
 * Inject "now" instead of calling the system clock. Clock.fixed pins
 * Instant.now(clock) and LocalDate.now(clock) to one instant, so tests
 * do not depend on the wall clock.
 *
 * This test reads today from a clock fixed at 2026-09-25T12:00Z.
 */
class ClockTest {
    @Test
    void readsTodayFromAFixedClock() {
        Clock clock = Clock.fixed(Instant.parse("2026-09-25T12:00:00Z"), ZoneOffset.UTC); // Instant.now(clock) stays on this instant

        assertEquals(Instant.parse("2026-09-25T12:00:00Z"), Instant.now(clock));
        assertEquals(LocalDate.of(2026, 9, 25), LocalDate.now(clock));
        assertEquals(ZoneOffset.UTC, clock.getZone());
    }
}
