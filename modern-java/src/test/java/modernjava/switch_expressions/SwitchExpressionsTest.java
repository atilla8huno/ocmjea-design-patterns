package modernjava.switch_expressions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Demonstrates Java 14+ switch expressions with arrow cases and yield.
 */
public class SwitchExpressionsTest {

	@Test
	void demonstratesSample() {
		DayClassifier classifier = new DayClassifier();

		assertEquals("weekday", classifier.kind("Monday"));
		assertEquals("weekend", classifier.kind("Sunday"));
		assertEquals("unknown", classifier.kind("Holiday"));

		assertEquals(8, classifier.workHours("Tuesday"));
		assertEquals(6, classifier.workHours("Friday"));
		assertEquals(0, classifier.workHours("Saturday"));

		System.out.println(classifier.kind("Monday"));
		System.out.println(classifier.workHours("Friday"));
	}
}
