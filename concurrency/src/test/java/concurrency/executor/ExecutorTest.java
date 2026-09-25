package concurrency.executor;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ExecutorService
 *
 * Hand work to a pool instead of creating raw Threads. submit(Callable)
 * returns a Future; get() blocks until the worker finishes and unwraps
 * the result (checked ExecutionException on failure).
 *
 * try-with-resources shuts the pool down. This test submits SumTask(20, 22).
 */
public class ExecutorTest {

	@Test
	void demonstratesSample() throws Exception  {
		try (ExecutorService executor = Executors.newFixedThreadPool(2)) {
			int result = executor.submit(new SumTask(20, 22)).get(); // waits for the worker
			System.out.println("Result: " + result);
		}
	}
}
