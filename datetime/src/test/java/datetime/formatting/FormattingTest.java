package datetime.formatting;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Covers DateTimeFormatter for the usual parse and format patterns.
 */
class FormattingTest {
    @Test
    void formatsAndParsesADateTimePattern() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse("2026-09-25T09:30");

        assertEquals("25/09/2026 09:30", dateTime.format(formatter));
        assertEquals(dateTime, LocalDateTime.parse("25/09/2026 09:30", formatter));
    }
}
