package concurrency.thread_safe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.IntStream;

/**
 * Demonstrates Java concurrency with thread safe and JUnit 5.
 */
public class ThreadSafeTest {

	@Test
	void demonstratesSample() {
		SafeList list = new SafeList();
		IntStream.rangeClosed(1, 3).parallel().forEach(number -> list.add("item-" + number));
		assertEquals(java.util.List.of("item-1", "item-2", "item-3"), list.sortedItems());
		System.out.println(list.sortedItems());
	}
}
