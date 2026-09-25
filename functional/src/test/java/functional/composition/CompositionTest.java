package functional.composition;

import org.junit.jupiter.api.Test;

import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Function composition
 *
 * Combine small functions instead of writing one large lambda.
 * andThen runs this function first, then the next. compose is the
 * opposite order. Predicate.and / or / not combine tests.
 *
 * This test trims and uppercases a name, and filters even positives.
 */
class CompositionTest {

    @Test
    void composesFunctionsAndPredicates() {
        Function<String, String> trim = String::strip;
        Function<String, String> upper = String::toUpperCase;
        Function<String, String> normalise = trim.andThen(upper);
        Function<String, String> alsoNormalise = upper.compose(trim);

        assertEquals("JAVA", normalise.apply("  java  "));
        assertEquals("JAVA", alsoNormalise.apply("  java  "));

        Predicate<Integer> positive = value -> value > 0;
        Predicate<Integer> even = value -> value % 2 == 0;
        Predicate<Integer> evenPositive = positive.and(even);

        assertTrue(evenPositive.test(4));
        assertFalse(evenPositive.test(-2));
        assertFalse(evenPositive.test(3));
        assertTrue(Predicate.not(even).test(3));
    }
}
