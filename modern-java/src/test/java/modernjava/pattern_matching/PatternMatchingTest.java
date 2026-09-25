package modernjava.pattern_matching;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Demonstrates the Java 21 pattern matching feature with JUnit 5.
 */
public class PatternMatchingTest {

	@Test
	void demonstratesSample() {
		Formatter formatter = new Formatter();
		assertEquals("JAVA", formatter.format("java"));
		assertEquals("Number: 21", formatter.format(21));
		System.out.println(formatter.format("java"));
		System.out.println(formatter.format(21));
	}
}
