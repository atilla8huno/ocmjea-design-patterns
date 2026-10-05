package algorithms.stack;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Stack
 *
 * A stack is last-in, first-out (Deque push / pop). Parentheses match
 * when each closer pops the opener you just pushed. An empty stack at
 * the end means every opener was closed.
 *
 * A monotonic stack keeps indices in decreasing value order. When a
 * larger value arrives, it is the next greater element for everything
 * you pop. This test checks both.
 */
class StackTest {

    @Test
    void matchesBracketsAndFindsTheNextGreaterValue() {
        assertTrue(valid("()[]{}"));
        assertFalse(valid("(]"));
        assertFalse(valid("("));
        assertArrayEquals(new int[]{4, 2, 4, -1, -1}, nextGreater(new int[]{2, 1, 2, 4, 3}));
    }

    private boolean valid(String text) {
        Map<Character, Character> closers = Map.of(')', '(', ']', '[', '}', '{');
        Deque<Character> open = new ArrayDeque<>();
        for (char letter : text.toCharArray()) {
            if (!closers.containsKey(letter)) {
                open.push(letter);
            } else if (open.isEmpty() || open.pop() != closers.get(letter)) {
                return false;
            }
        }
        return open.isEmpty();
    }

    private int[] nextGreater(int[] values) {
        int[] answer = new int[values.length];
        Arrays.fill(answer, -1);
        Deque<Integer> decreasing = new ArrayDeque<>();
        for (int index = 0; index < values.length; index++) {
            while (!decreasing.isEmpty() && values[decreasing.peek()] < values[index]) {
                answer[decreasing.pop()] = values[index];
            }
            decreasing.push(index);
        }
        return answer;
    }
}
