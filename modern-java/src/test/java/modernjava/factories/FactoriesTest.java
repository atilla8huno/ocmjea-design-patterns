package modernjava.factories;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Demonstrates the Java 21 factories feature with JUnit 5.
 */
public class FactoriesTest {

	@Test
	void demonstratesSample() {
		CollectionFactory factory = new CollectionFactory();
		assertEquals(java.util.List.of("Java", "Kotlin"), factory.languages());
		assertEquals(21, factory.versions().get("Java"));
		System.out.println(factory.languages());
		System.out.println(factory.versions());
	}
}
