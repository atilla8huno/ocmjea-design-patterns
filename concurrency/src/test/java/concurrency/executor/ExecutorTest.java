package concurrency.executor;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Demonstrates Java concurrency with executor and JUnit 5.
 */
public class ExecutorTest {

	@Test
	void demonstratesSample() throws Exception  {
		try (ExecutorService executor = Executors.newFixedThreadPool(2)) {
			int result = executor.submit(new SumTask(20, 22)).get();
			System.out.println("Result: " + result);
		}
	}
}
