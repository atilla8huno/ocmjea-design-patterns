package concurrency.future;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Demonstrates Java concurrency with future and JUnit 5.
 */
public class FutureTest {

	@Test
	void demonstratesSample() {
		AsyncCalculator calculator = new AsyncCalculator();
		int result = calculator.doubleValues(21).thenApply(number -> number + 1).join();
		assertEquals(43, result);
		System.out.println("Result: " + result);
	}
}
