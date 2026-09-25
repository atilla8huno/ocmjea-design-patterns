package streams.optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import org.junit.jupiter.api.Test;

/**
 * Optional samples showing how Stream searches compose with fallback values,
 * transformations, nested optional values, and conditional consumption.
 */
class OptionalTest {

    @Test
    void handlesAStreamSearchWithFallbackAndMapping() {
        Optional<String> first = List.of("ant", "bear").stream()
                .filter(word -> word.length() > 3)
                .findFirst();

        assertEquals("bear", first.orElse("missing"));
        assertEquals(4, first.map(String::length).orElse(0));
        assertEquals("missing", List.<String>of().stream().findFirst().orElse("missing"));
    }

    @Test
    void flattensAndConsumesOptionalValues() {
        Optional<String> nested = Optional.of("42");
        assertEquals(42, nested.flatMap(this::parseInteger).orElseThrow());

        var consumed = new AtomicReference<String>();
        nested.ifPresent(consumed::set);
        assertEquals("42", consumed.get());
    }

    private Optional<Integer> parseInteger(String value) {
        try {
            return Optional.of(Integer.parseInt(value));
        } catch (NumberFormatException exception) {
            return Optional.empty();
        }
    }
}
