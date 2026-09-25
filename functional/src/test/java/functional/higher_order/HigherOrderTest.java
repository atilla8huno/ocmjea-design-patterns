package functional.higher_order;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Higher-order functions
 *
 * A function that takes or returns another function. applyTwice takes
 * a Function; filter takes a Predicate. The algorithm stays in one
 * place; the caller supplies the behaviour.
 *
 * This test doubles twice and keeps names that start with A.
 */
class HigherOrderTest {

    @Test
    void passesAndReturnsFunctions() {
        Function<Integer, Integer> increment = value -> value + 1;
        Function<Integer, Integer> twice = applyTwice(increment);

        assertEquals(5, twice.apply(3));
        assertEquals(List.of(4, 6), filter(List.of(3, 4, 5, 6), value -> value % 2 == 0));
        assertEquals(List.of("Ada", "Alan"), filter(List.of("Ada", "Grace", "Alan"), name -> name.startsWith("A")));
    }

    private static <T> Function<T, T> applyTwice(Function<T, T> function) {
        return value -> function.apply(function.apply(value));
    }

    private static <T> List<T> filter(List<T> values, Predicate<T> keep) {
        List<T> result = new ArrayList<>();
        for (T value : values) {
            if (keep.test(value)) {
                result.add(value);
            }
        }
        return List.copyOf(result);
    }
}
