package collections.array_deque;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Problem: count the fewest hops between two nodes of a graph, and check a word from both ends.
 *
 * ArrayDeque fits because breadth-first search needs amortised constant-time removal from the front
 * while a palindrome check consumes both ends of the same buffer.
 */
class ArrayDequeTest {
    private static final Map<String, List<String>> ROUTES = Map.of(
            "a", List.of("b", "c"),
            "b", List.of("d"),
            "c", List.of("d"),
            "d", List.of("e"),
            "e", List.of());

    private int hops(String from, String to) {
        record Node(String name, int distance) {}
        Deque<Node> pending = new ArrayDeque<>();
        pending.addLast(new Node(from, 0));
        Set<String> visited = new java.util.HashSet<>();
        visited.add(from);
        while (!pending.isEmpty()) {
            Node current = pending.removeFirst();
            if (current.name().equals(to)) {
                return current.distance();
            }
            for (String next : ROUTES.get(current.name())) {
                if (visited.add(next)) {
                    pending.addLast(new Node(next, current.distance() + 1));
                }
            }
        }
        return -1;
    }

    private boolean isPalindrome(String text) {
        Deque<Character> letters = new ArrayDeque<>();
        for (char letter : text.toCharArray()) {
            letters.addLast(letter);
        }
        while (letters.size() > 1) {
            if (!letters.removeFirst().equals(letters.removeLast())) {
                return false;
            }
        }
        return true;
    }

    @Test
    void findsTheShortestHopCountWithBreadthFirstSearch() {
        assertEquals(3, hops("a", "e"));
        assertEquals(0, hops("a", "a"));
        assertEquals(-1, hops("e", "a"));
    }

    @Test
    void checksAWordFromBothEnds() {
        assertTrue(isPalindrome("racecar"));
        assertFalse(isPalindrome("kotlin"));
    }

    @Test
    void removeFirstRejectsAnEmptyDeque() {
        assertThrows(NoSuchElementException.class, () -> new ArrayDeque<String>().removeFirst());
    }
}
