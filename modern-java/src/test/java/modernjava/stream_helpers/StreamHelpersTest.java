package modernjava.stream_helpers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

/**
 * Demonstrates the Java 21 stream helpers feature with JUnit 5.
 */
public class StreamHelpersTest {

	@Test
	void demonstratesSample() {
		StreamReport report = new StreamReport();
		assertEquals(List.of(2, 4), report.sortedEvens(List.of(5, 2, 4, 1)));
		System.out.println(report.sortedEvens(List.of(5, 2, 4, 1)));
	}
}
