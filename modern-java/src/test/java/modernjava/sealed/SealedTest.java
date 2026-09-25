package modernjava.sealed;

import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * Demonstrates the Java 21 sealed feature with JUnit 5.
 */
public class SealedTest {

	@Test
	void demonstratesSample() {
		List<Shape> shapes = List.of(new Circle(1), new Square(2));
		shapes.forEach(shape -> System.out.printf("%.2f%n", shape.area()));
	}
}
