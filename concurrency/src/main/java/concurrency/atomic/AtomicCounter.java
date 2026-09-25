package concurrency.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter {

	private final AtomicInteger value = new AtomicInteger();

	public int increment() {
		return value.incrementAndGet();
	}

	public int value() {
		return value.get();
	}
}
