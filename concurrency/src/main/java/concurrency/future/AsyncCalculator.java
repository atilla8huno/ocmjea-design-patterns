package concurrency.future;

import java.util.concurrent.CompletableFuture;

public class AsyncCalculator {

	public CompletableFuture<Integer> doubleValues(int number) {
		return CompletableFuture.completedFuture(number * 2);
	}
}
