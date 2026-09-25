package concurrency.future;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * CompletableFuture
 *
 * Compose asynchronous steps. thenApply maps a successful value; join()
 * unwraps the final result and throws unchecked if the future failed
 * (get() throws checked ExecutionException instead).
 *
 * This test doubles 21, adds 1, and expects 43.
 */
public class FutureTest {

	@Test
	void demonstratesSample() {
		AsyncCalculator calculator = new AsyncCalculator();
		int result = calculator.doubleValues(21).thenApply(number -> number + 1).join(); // unwraps; unchecked on failure
		assertEquals(43, result);
		System.out.println("Result: " + result);
	}
}
