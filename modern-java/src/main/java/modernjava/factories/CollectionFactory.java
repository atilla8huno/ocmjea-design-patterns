package modernjava.factories;

import java.util.List;
import java.util.Map;

public class CollectionFactory {

	public List<String> languages() {
		return List.of("Java", "Kotlin");
	}

	public Map<String, Integer> versions() {
		return Map.of("Java", 21, "Kotlin", 2);
	}
}
