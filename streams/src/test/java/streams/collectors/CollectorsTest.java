package streams.collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

/**
 * Collector samples showing collection creation, indexing, grouping,
 * partitioning, joining, downstream mapping, and numeric summaries.
 */
class CollectorsTest {

    @Test
    void collectsToListsSetsAndMaps() {
        var words = List.of("pear", "apple", "pear");

        assertEquals(words, words.stream().collect(Collectors.toList()));
        assertEquals(Set.of("pear", "apple"), words.stream().collect(Collectors.toSet()));
        assertEquals(
                Map.of("pear", 4, "apple", 5),
                words.stream().distinct().collect(Collectors.toMap(Function.identity(), String::length)));
    }

    @Test
    void groupsPartitionsJoinsAndMapsDownstream() {
        var words = List.of("ant", "bear", "cat", "dog");

        assertEquals(
                Map.of(3, List.of("ant", "cat", "dog"), 4, List.of("bear")),
                words.stream().collect(Collectors.groupingBy(String::length)));
        assertEquals(
                Map.of(true, List.of("bear"), false, List.of("ant", "cat", "dog")),
                words.stream().collect(Collectors.partitioningBy(word -> word.length() > 3)));
        assertEquals("ant, bear, cat, dog", words.stream().collect(Collectors.joining(", ")));
        assertEquals(
                Map.of(3, Set.of("ANT", "CAT", "DOG"), 4, Set.of("BEAR")),
                words.stream().collect(Collectors.groupingBy(
                        String::length,
                        Collectors.mapping(String::toUpperCase, Collectors.toSet()))));
    }

    @Test
    void summarisesIntegerValues() {
        IntSummaryStatistics statistics =
                List.of("ant", "bear", "cat").stream().collect(Collectors.summarizingInt(String::length));

        assertEquals(3, statistics.getCount());
        assertEquals(10, statistics.getSum());
        assertEquals(3, statistics.getMin());
        assertEquals(4, statistics.getMax());
    }
}
