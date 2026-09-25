package datetime.timezone;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Covers ZoneId, ZonedDateTime and OffsetDateTime for the same instant in different zones.
 */
class TimezoneTest {
    @Test
    void convertsALocalDateTimeBetweenZones() {
        ZoneId london = ZoneId.of("Europe/London");
        ZoneId newYork = ZoneId.of("America/New_York");
        ZonedDateTime meeting = ZonedDateTime.of(LocalDateTime.parse("2026-09-25T09:30"), london);
        ZonedDateTime inNewYork = meeting.withZoneSameInstant(newYork);

        assertEquals("2026-09-25T04:30-04:00[America/New_York]", inNewYork.toString());
        assertEquals(meeting.toInstant(), inNewYork.toInstant());
    }

    @Test
    void storesAFixedOffsetWithoutZoneRules() {
        OffsetDateTime stamp = OffsetDateTime.parse("2026-09-25T09:30:00+01:00");

        assertEquals(ZoneOffset.ofHours(1), stamp.getOffset());
        assertEquals(8, stamp.withOffsetSameInstant(ZoneOffset.UTC).getHour());
    }
}
