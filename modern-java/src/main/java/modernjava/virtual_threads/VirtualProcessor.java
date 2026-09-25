package modernjava.virtual_threads;

import java.util.List;
import java.util.concurrent.Executors;

public class VirtualProcessor {

	public List<Integer> doubleValues(List<Integer> numbers) throws Exception {
		try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
			var tasks = numbers.stream()
					.map(number -> executor.submit(() -> number * 2))
					.toList();
			return tasks.stream().map(task -> {
				try {
					return task.get();
				} catch (Exception exception) {
					throw new IllegalStateException(exception);
				}
			}).toList();
		}
	}
}
