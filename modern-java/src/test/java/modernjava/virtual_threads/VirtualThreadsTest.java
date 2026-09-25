package modernjava.virtual_threads;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

/**
 * Demonstrates the Java 21 virtual threads feature with JUnit 5.
 */
public class VirtualThreadsTest {

	@Test
	void demonstratesSample() throws Exception  {
		VirtualProcessor processor = new VirtualProcessor();
		assertEquals(List.of(2, 4, 6), processor.doubleValues(List.of(1, 2, 3)));
		System.out.println(processor.doubleValues(List.of(1, 2, 3)));
	}
}
