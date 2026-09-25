package functional.interfaces;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * java.util.function
 *
 * The JDK names the common function shapes so APIs can take behaviour as
 * a value. Function maps T to R; Predicate is a boolean test; Consumer
 * accepts a value; Supplier produces one; BiFunction takes two arguments.
 *
 * This test uses each shape once, without the Stream API.
 */
class InterfacesTest {

    @Test
    void appliesEachCoreFunctionalInterface() {
        Function<String, Integer> length = text -> text.length();
        Predicate<Integer> even = value -> value % 2 == 0;
        Supplier<String> greeting = () -> "hello";
        BiFunction<Integer, Integer, Integer> sum = (left, right) -> left + right;

        List<String> seen = new ArrayList<>();
        Consumer<String> collect = seen::add;

        assertEquals(4, length.apply("java"));
        assertTrue(even.test(4));
        assertFalse(even.test(5));
        assertEquals("hello", greeting.get());
        assertEquals(7, sum.apply(3, 4));

        collect.accept("one");
        collect.accept("two");
        assertEquals(List.of("one", "two"), seen);
    }
}
