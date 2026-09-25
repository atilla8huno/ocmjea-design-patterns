package collections.operations;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Problem: turn a stream of words into the three most frequent ones, ties broken alphabetically.
 *
 * Collection operators fit because grouping, counting and sorting compose into one readable pipeline
 * instead of manual loops and bookkeeping.
 */
class OperationsTest {
    @Test
    void reportsTheThreeMostFrequentWords() {
        List<String> words = List.of("the", "quick", "fox", "the", "lazy", "dog", "the", "fox", "jumps");

        List<Map.Entry<String, Long>> ranking = words.stream()
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed()
                        .thenComparing(Map.Entry::getKey))
                .limit(3)
                .toList();

        assertEquals("the", ranking.get(0).getKey());
        assertEquals(3L, ranking.get(0).getValue());
        assertEquals("fox", ranking.get(1).getKey());
        assertEquals(2L, ranking.get(1).getValue());
    }

    @Test
    void splitsAndFoldsValuesInOnePass() {
        Map<Boolean, List<Integer>> split = java.util.stream.IntStream.rangeClosed(1, 10)
                .boxed()
                .collect(Collectors.partitioningBy(value -> value % 2 == 0));

        assertEquals(30, split.get(true).stream().mapToInt(Integer::intValue).sum());
        assertEquals(25, split.get(false).stream().mapToInt(Integer::intValue).sum());
    }
}
