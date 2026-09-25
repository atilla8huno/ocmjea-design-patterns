package streams.intermediate;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * Intermediate operations
 *
 * Lazy steps that return another Stream: map, filter, flatMap, sorted,
 * distinct, peek, limit, skip. They do not run until a terminal
 * operation pulls values. peek is for debugging, not business logic.
 *
 * This test chains those operators and checks the result.
 */
class IntermediateOperationsTest {

    @Test
    void transformsFiltersFlattensSortsAndRemovesDuplicates() {
        var result = List.of("pear", "apple", "pear", "fig")
                .stream()
                .filter(word -> word.length() > 3)
                .map(String::toUpperCase)
                .distinct()
                .sorted()
                .toList();

        assertEquals(List.of("APPLE", "PEAR"), result);
        assertEquals(
                List.of(1, 2, 3, 4),
                List.of(List.of(1, 2), List.of(3, 4)).stream().flatMap(List::stream).toList());
    }

    @Test
    void observesAndSlicesAStream() {
        var observed = new ArrayList<Integer>();
        var result = List.of(1, 2, 3, 4, 5)
                .stream()
                .peek(observed::add)
                .skip(1)
                .limit(3)
                .toList();

        assertEquals(List.of(2, 3, 4), result);
        assertEquals(List.of(1, 2, 3, 4), observed);
    }
}
