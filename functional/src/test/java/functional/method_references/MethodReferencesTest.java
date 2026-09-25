package functional.method_references;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Method references
 *
 * A shorter lambda when the body is already a method.
 * Class::staticMethod, instance::method, Class::instanceMethod
 * (on the lambda argument) and Class::new for a constructor.
 *
 * This test maps names through those four forms.
 */
class MethodReferencesTest {

    @Test
    void bindsStaticInstanceAndConstructorReferences() {
        Function<String, String> boxed = String::valueOf;
        Function<String, String> upper = String::toUpperCase;
        String prefix = "hi ";
        Function<String, String> greet = prefix::concat;
        Supplier<List<String>> list = ArrayList::new;

        assertEquals("42", boxed.apply("42"));
        assertEquals("JAVA", upper.apply("java"));
        assertEquals("hi Ada", greet.apply("Ada"));

        List<String> names = list.get();
        names.add("Ada");
        assertEquals(List.of("Ada"), names);
    }
}
