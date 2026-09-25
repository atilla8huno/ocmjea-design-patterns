package streams.creation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

/**
 * Creating streams
 *
 * A Stream is a pipeline, not a collection. Build one from a collection
 * (stream()), an array (Arrays.stream), factories (of, empty), or
 * generate / iterate for lazy sequences. Nothing runs until a terminal
 * operation.
 *
 * This test builds streams those ways and checks a few values.
 */
class StreamCreationTest {

    @Test
    void createsStreamsFromValuesCollectionsAndArrays() {
        assertEquals(List.of("one", "two"), Stream.of("one", "two").toList());
        assertEquals(List.of(1, 2, 3), List.of(1, 2, 3).stream().toList());
        assertEquals(6, Arrays.stream(new int[] {1, 2, 3}).sum());
    }

    @Test
    void createsBoundedGeneratedAndIteratedStreams() {
        assertEquals(List.of(1, 2, 4, 8), Stream.iterate(1, value -> value * 2).limit(4).toList());
        assertEquals(List.of("sample", "sample"), Stream.generate(() -> "sample").limit(2).toList());
        assertTrue(Stream.empty().findAny().isEmpty());
    }
}
