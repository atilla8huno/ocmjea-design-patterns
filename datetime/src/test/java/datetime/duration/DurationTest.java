package datetime.duration;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Covers Duration for elapsed time on the timeline, independent of calendars and time zones.
 */
class DurationTest {
    @Test
    void measuresElapsedTimeBetweenTwoInstants() {
        Instant start = Instant.parse("2026-09-25T09:00:00Z");
        Instant end = Instant.parse("2026-09-25T10:30:00Z");
        Duration elapsed = Duration.between(start, end);

        assertEquals(90, elapsed.toMinutes());
        assertEquals(end, start.plus(Duration.ofHours(1).plusMinutes(30)));
    }
}
