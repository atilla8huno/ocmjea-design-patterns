package modernjava.switch_expressions;

public class DayClassifier {

	public String kind(String day) {
		return switch (day) {
			case "Saturday", "Sunday" -> "weekend";
			case "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" -> "weekday";
			default -> "unknown";
		};
	}

	public int workHours(String day) {
		return switch (day) {
			case "Saturday", "Sunday" -> {
				yield 0;
			}
			case "Friday" -> {
				yield 6;
			}
			default -> {
				yield 8;
			}
		};
	}
}
