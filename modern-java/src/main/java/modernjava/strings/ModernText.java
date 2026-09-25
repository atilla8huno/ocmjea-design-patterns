package modernjava.strings;

public class ModernText {

	public String message(String name) {
		String template = """
				Hello, %s!
				Welcome.
				""";
		return template.formatted(name).strip();
	}
}
