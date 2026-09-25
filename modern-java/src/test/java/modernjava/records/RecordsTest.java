package modernjava.records;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Records
 *
 * A compact immutable value type. The compiler generates the constructor,
 * accessors, equals, hashCode and toString from the components. Add methods
 * (here introduction()) when the type needs behaviour.
 *
 * This test checks the greeting and that two Person("Ana", 30) values are equal.
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
