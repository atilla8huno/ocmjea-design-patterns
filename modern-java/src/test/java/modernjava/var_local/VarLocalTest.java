package modernjava.var_local;

import org.junit.jupiter.api.Test;

/**
 * Demonstrates the Java 21 var local feature with JUnit 5.
 */
public class VarLocalTest {

	@Test
	void demonstratesSample() {
		var example = new LocalInference();
		System.out.println(example.description());
	}
}
