package modernjava.stream_helpers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

/**
 * Stream.toList()
 *
 * Collect a stream to an unmodifiable List in one call. Unlike
 * collect(Collectors.toList()), the result cannot be mutated. Combined
 * here with filter and sorted.
 *
 * This test keeps the even numbers [2, 4] from [5, 2, 4, 1].
 */
public class StreamHelpersTest {

	@Test
	void demonstratesSample() {
		StreamReport report = new StreamReport();
		assertEquals(List.of(2, 4), report.sortedEvens(List.of(5, 2, 4, 1)));
		System.out.println(report.sortedEvens(List.of(5, 2, 4, 1)));
	}
}
