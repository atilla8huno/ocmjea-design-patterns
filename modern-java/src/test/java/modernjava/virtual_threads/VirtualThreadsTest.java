package modernjava.virtual_threads;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

/**
 * Virtual threads (Java 21)
 *
 * Run one task per item without a platform thread each time.
 * newVirtualThreadPerTaskExecutor parks cheaply on blocking calls, so
 * thousands of tasks can wait without exhausting the OS thread pool.
 *
 * This test doubles each number on its own virtual thread.
 */
public class VirtualThreadsTest {

	@Test
	void demonstratesSample() throws Exception  {
		VirtualProcessor processor = new VirtualProcessor();
		assertEquals(List.of(2, 4, 6), processor.doubleValues(List.of(1, 2, 3)));
		System.out.println(processor.doubleValues(List.of(1, 2, 3)));
	}
}
