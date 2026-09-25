package modernjava.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Text blocks
 *
 * A multi-line string literal (three quotes) keeps line breaks as written.
 * formatted() fills placeholders; strip() trims incidental leading and
 * trailing whitespace from the block.
 *
 * This test checks the greeting for Maria.
 */
public class StringsTest {

	@Test
	void demonstratesSample() {
		ModernText text = new ModernText();
		assertEquals("Hello, Maria!\nWelcome.", text.message("Maria"));
		System.out.println(text.message("Maria"));
	}
}
