package concurrency.executor;

import java.util.concurrent.Callable;

public class SumTask implements Callable<Integer> {

	private final int first;
	private final int second;

	public SumTask(int first, int second) {
		this.first = first;
		this.second = second;
	}

	@Override
	public Integer call() {
		return first + second;
	}
}
