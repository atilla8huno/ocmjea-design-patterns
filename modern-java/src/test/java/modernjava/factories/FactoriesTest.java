package modernjava.factories;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * List.of and Map.of
 *
 * Factory methods for small unmodifiable collections. No add/put after
 * creation; nulls are rejected. Prefer them for fixed catalogues instead
 * of a mutable ArrayList or HashMap.
 *
 * This test checks the language list and the Java version entry.
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
