package functional.pure;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Pure functions
 *
 * Same input, same output, no shared mutable state. A pure map builds a
 * new list; an impure one mutates the argument. Interviews often ask
 * you to spot the side effect.
 *
 * This test doubles a list both ways and checks only the copy changes.
 */
class PureTest {

    @Test
    void prefersANewListOverMutatingTheInput() {
        List<Integer> original = List.of(1, 2, 3);

        assertEquals(List.of(2, 4, 6), doubled(original));
        assertEquals(List.of(1, 2, 3), original);

        List<Integer> mutable = new ArrayList<>(original);
        doubleInPlace(mutable);
        assertEquals(List.of(2, 4, 6), mutable);
    }

    private static List<Integer> doubled(List<Integer> values) {
        List<Integer> result = new ArrayList<>();
        for (Integer value : values) {
            result.add(value * 2);
        }
        return List.copyOf(result);
    }

    private static void doubleInPlace(List<Integer> values) {
        for (int index = 0; index < values.size(); index++) {
            values.set(index, values.get(index) * 2);
        }
    }
}
