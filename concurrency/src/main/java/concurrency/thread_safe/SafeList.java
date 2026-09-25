package concurrency.thread_safe;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class SafeList {

	private final List<String> items = new CopyOnWriteArrayList<>();

	public void add(String item) {
		items.add(item);
	}

	public List<String> sortedItems() {
		return items.stream().sorted().toList();
	}
}
