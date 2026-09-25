package concurrency.atomic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.IntStream;

/**
 * Atomic variables
 *
 * Increment a shared counter from many threads without a lock and without
 * lost updates. AtomicInteger.incrementAndGet uses compare-and-set: it
 * retries until the write lands, so parallel increments stay correct.
 *
 * This test runs 1_000 increments on a parallel stream and expects 1_000.
 */
public class AtomicTest {

	@Test
	void demonstratesSample() {
		AtomicCounter counter = new AtomicCounter();
		// incrementAndGet is a compare-and-set, safe under parallel()
		IntStream.range(0, 1_000).parallel().forEach(number -> counter.increment());
		assertEquals(1_000, counter.value());
		System.out.println("Count: " + counter.value());
	}
}
