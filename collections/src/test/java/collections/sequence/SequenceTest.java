package collections.sequence;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Problem: find the first prime above a threshold in a potentially endless range.
 *
 * Stream fits because elements flow through the pipeline one at a time, so the search stops at the
 * first match instead of materialising intermediate collections. iterate /
 * generate plus findFirst is the usual "first that matches" search.
 */
class SequenceTest {
    private boolean isPrime(int value) {
        if (value <= 1) {
            return false;
        }
        for (int divisor = 2; divisor <= value / 2; divisor++) {
            if (value % divisor == 0) {
                return false;
            }
        }
        return true;
    }

    @Test
    void stopsEvaluatingAtTheFirstMatch() {
        AtomicInteger inspected = new AtomicInteger();
        int firstPrime = Stream.iterate(1_000, value -> value + 1)
                .peek(value -> inspected.incrementAndGet())
                .filter(this::isPrime)
                .findFirst()
                .orElseThrow();

        assertEquals(1009, firstPrime);
        assertEquals(10, inspected.get());
    }

    @Test
    void aStreamCanBeConsumedOnlyOnce() {
        Stream<Integer> values = Stream.of(1, 2);
        values.toList();

        assertThrows(IllegalStateException.class, values::toList);
    }
}
