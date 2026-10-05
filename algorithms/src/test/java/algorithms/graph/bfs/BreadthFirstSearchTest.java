package algorithms.graph.bfs;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Breadth-first search
 *
 * BFS walks a graph level by level. A queue holds the frontier: add
 * neighbours at the back, take the next node from the front (ArrayDeque).
 * A visited set stops you revisiting a node. On an unweighted graph the
 * first time you reach a node is a shortest path in hops.
 *
 * This test counts hops from a to e on a small route map.
 */
class BreadthFirstSearchTest {
    private static final Map<String, List<String>> ROUTES = Map.of(
            "a", List.of("b", "c"),
            "b", List.of("d"),
            "c", List.of("d"),
            "d", List.of("e"),
            "e", List.of());

    @Test
    void countsTheFewestHops() {
        assertEquals(3, hops("a", "e"));
        assertEquals(0, hops("a", "a"));
        assertEquals(-1, hops("e", "a"));
    }

    private int hops(String from, String to) {
        record Step(String name, int distance) {}
        Deque<Step> pending = new ArrayDeque<>();
        pending.addLast(new Step(from, 0));
        Set<String> visited = new HashSet<>();
        visited.add(from);
        while (!pending.isEmpty()) {
            Step current = pending.removeFirst();
            if (current.name().equals(to)) {
                return current.distance();
            }
            for (String next : ROUTES.getOrDefault(current.name(), List.of())) {
                if (visited.add(next)) {
                    pending.addLast(new Step(next, current.distance() + 1));
                }
            }
        }
        return -1;
    }
}
