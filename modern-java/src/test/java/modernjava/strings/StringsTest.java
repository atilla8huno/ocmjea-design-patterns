package modernjava.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Demonstrates the Java 21 strings feature with JUnit 5.
 */
public class StringsTest {

	@Test
	void demonstratesSample() {
		ModernText text = new ModernText();
		assertEquals("Hello, Maria!\nWelcome.", text.message("Maria"));
		System.out.println(text.message("Maria"));
	}
}
