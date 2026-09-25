package modernjava.pattern_matching;

public class Formatter {

	public String format(Object value) {
		if (value instanceof String text) {
			return text.toUpperCase();
		}
		if (value instanceof Integer number) {
			return "Number: " + number;
		}
		return "Unknown";
	}
}
