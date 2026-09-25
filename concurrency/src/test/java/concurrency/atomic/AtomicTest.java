package concurrency.atomic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.IntStream;

/**
 * Demonstrates Java concurrency with atomic and JUnit 5.
 */
public class AtomicTest {

	@Test
	void demonstratesSample() {
		AtomicCounter counter = new AtomicCounter();
		IntStream.range(0, 1_000).parallel().forEach(number -> counter.increment());
		assertEquals(1_000, counter.value());
		System.out.println("Count: " + counter.value());
	}
}
