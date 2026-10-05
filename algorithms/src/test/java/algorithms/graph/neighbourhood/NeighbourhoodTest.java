package algorithms.graph.neighbourhood;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * k-hop neighbourhood
 *
 * Retrieval next to a language model starts at one entity and expands
 * a few hops, not the whole graph. Breadth-first search does that:
 * a queue walks level by level and stops when the depth limit is hit.
 * The result is the set of nodes reached, not a distance.
 *
 * This test takes the direct neighbours of a at depth 1, and adds the
 * next ring at depth 2. The node beyond that stays out.
 */
class NeighbourhoodTest {
    private static final Map<String, List<String>> LINKS = Map.of(
            "a", List.of("b", "c"),
            "b", List.of("d"),
            "c", List.of("e"),
            "d", List.of("f"),
            "e", List.of(),
            "f", List.of());

    @Test
    void expandsOneHopThenTwo() {
        assertEquals(Set.of("b", "c"), within("a", 1));
        assertEquals(Set.of("b", "c", "d", "e"), within("a", 2));
    }

    private Set<String> within(String start, int depth) {
        Set<String> reached = new HashSet<>();
        Map<String, Integer> distance = new HashMap<>();
        Deque<String> pending = new ArrayDeque<>();
        distance.put(start, 0);
        pending.addLast(start);
        while (!pending.isEmpty()) {
            String node = pending.removeFirst();
            int hops = distance.get(node);
            if (hops == depth) {
                continue;
            }
            for (String next : LINKS.getOrDefault(node, List.of())) {
                if (distance.containsKey(next)) {
                    continue;
                }
                distance.put(next, hops + 1);
                reached.add(next);
                pending.addLast(next);
            }
        }
        return reached;
    }
}
