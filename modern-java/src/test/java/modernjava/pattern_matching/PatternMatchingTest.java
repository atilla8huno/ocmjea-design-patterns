package modernjava.pattern_matching;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Pattern matching for instanceof
 *
 * Test the type and bind the narrowed variable in one check
 * (value instanceof String text). No separate cast. The binding is in
 * scope only when the test succeeds.
 *
 * This test formats a String to upper case and an Integer with a prefix.
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
