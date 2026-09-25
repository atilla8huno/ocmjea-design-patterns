package modernjava.sealed;

import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * Sealed types
 *
 * Restrict which types may implement an interface. Shape permits only
 * Circle and Square, so a switch on Shape can be exhaustive and a new
 * implementer is a compile error until you allow it.
 *
 * This test computes area for one Circle and one Square.
 */
public class SealedTest {

	@Test
	void demonstratesSample() {
		List<Shape> shapes = List.of(new Circle(1), new Square(2));
		shapes.forEach(shape -> System.out.printf("%.2f%n", shape.area()));
	}
}
