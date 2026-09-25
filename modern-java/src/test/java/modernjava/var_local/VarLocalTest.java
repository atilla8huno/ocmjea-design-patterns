package modernjava.var_local;

import org.junit.jupiter.api.Test;

/**
 * Local-variable type inference (var)
 *
 * The compiler infers the type from the initializer. It is still static:
 * you cannot reassign a different type. Use it when the right-hand side
 * already makes the type obvious.
 *
 * This test prints LocalInference's Java 21 description.
 */
public class VarLocalTest {

	@Test
	void demonstratesSample() {
		var example = new LocalInference();
		System.out.println(example.description());
	}
}
