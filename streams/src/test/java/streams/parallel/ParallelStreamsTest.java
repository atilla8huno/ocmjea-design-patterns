package streams.parallel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

/**
 * Parallel Stream samples comparing parallel and sequential results while
 * avoiding assumptions about encounter order for unordered selection.
 */
class ParallelStreamsTest {

    @Test
    void producesTheSameContentsAsASequentialStream() {
        var values = List.of(1, 2, 3, 4, 5);
        var sequential = values.stream().map(value -> value * 2).collect(Collectors.toSet());
        var parallel = values.parallelStream().map(value -> value * 2).collect(Collectors.toSet());

        assertEquals(sequential, parallel);
        assertTrue(values.parallelStream().isParallel());
    }

    @Test
    void treatsParallelFindAnyAsUnordered() {
        var values = Set.of(1, 2, 3, 4);
        int selected = values.parallelStream().findAny().orElseThrow();

        assertTrue(values.contains(selected));
    }
}
