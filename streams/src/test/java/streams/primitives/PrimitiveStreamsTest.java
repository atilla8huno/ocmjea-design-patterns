package streams.primitives;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import org.junit.jupiter.api.Test;

/**
 * Primitive Stream samples showing ranges, specialised numeric operations,
 * boxing, and summary statistics without object-stream arithmetic.
 */
class PrimitiveStreamsTest {

    @Test
    void usesIntLongAndDoubleStreams() {
        assertEquals(10, IntStream.range(1, 5).sum());
        assertEquals(6L, LongStream.of(1, 2, 3).sum());
        assertEquals(2.0, DoubleStream.of(1.0, 2.0, 3.0).average().orElseThrow());
    }

    @Test
    void boxesValuesAndCalculatesStatistics() {
        assertEquals(List.of(1, 2, 3), IntStream.rangeClosed(1, 3).boxed().toList());

        IntSummaryStatistics statistics = IntStream.of(2, 4, 6).summaryStatistics();
        assertEquals(3, statistics.getCount());
        assertEquals(12, statistics.getSum());
        assertEquals(2, statistics.getMin());
        assertEquals(6, statistics.getMax());
        assertEquals(4.0, statistics.getAverage());
    }
}
