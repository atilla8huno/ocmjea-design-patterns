package modernjava.stream_helpers;

import java.util.List;

public class StreamReport {

	public List<Integer> sortedEvens(List<Integer> numbers) {
		return numbers.stream()
				.filter(number -> number % 2 == 0)
				.sorted()
				.toList();
	}
}
