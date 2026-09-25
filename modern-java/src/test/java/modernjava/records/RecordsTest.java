package modernjava.records;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Demonstrates the Java 21 records feature with JUnit 5.
 */
public class RecordsTest {

	@Test
	void demonstratesSample() {
		Person person = new Person("Ana", 30);
		assertEquals("Ana is 30 years old", person.introduction());
		assertEquals(new Person("Ana", 30), person);
		System.out.println(person.introduction());
		System.out.println(person.equals(new Person("Ana", 30)));
	}
}
