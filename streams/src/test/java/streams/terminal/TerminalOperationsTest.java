package streams.terminal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * Terminal Stream operation samples showing traversal, aggregation, selection,
 * matching, and immutable result materialisation.
 */
class TerminalOperationsTest {

    @Test
    void traversesReducesCountsAndSelectsValues() {
        var visited = new ArrayList<Integer>();
        List.of(3, 1, 2).stream().forEach(visited::add);

        assertEquals(List.of(3, 1, 2), visited);
        assertEquals(6, List.of(1, 2, 3).stream().reduce(0, Integer::sum));
        assertEquals(3, List.of(1, 2, 3).stream().count());
        assertEquals(1, List.of(3, 1, 2).stream().min(Integer::compareTo).orElseThrow());
        assertEquals(3, List.of(3, 1, 2).stream().max(Integer::compareTo).orElseThrow());
        assertEquals(3, List.of(3, 1, 2).stream().findFirst().orElseThrow());
        assertTrue(List.of(3, 1, 2).stream().findAny().isPresent());
    }

    @Test
    void matchesAndMaterialisesResults() {
        assertTrue(List.of(1, 2, 3).stream().anyMatch(value -> value % 2 == 0));
        assertTrue(List.of(1, 2, 3).stream().allMatch(value -> value > 0));
        assertFalse(List.of(1, 2, 3).stream().noneMatch(value -> value == 2));
        assertEquals(List.of(2, 4), List.of(1, 2, 3, 4).stream().filter(value -> value % 2 == 0).toList());
    }
}
