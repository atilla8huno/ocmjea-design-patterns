package algorithms.graph.cycle;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Directed cycle
 *
 * Colour each node while you DFS: white (unseen), grey (on the current
 * path), black (finished). An edge into a grey node is a back edge, so
 * the directed graph has a cycle. Black nodes can be skipped.
 *
 * This is the check you need before a topological order. This test
 * accepts a chain and rejects a loop back to an ancestor.
 */
class CycleTest {
    private static final int WHITE = 0;
    private static final int GREY = 1;
    private static final int BLACK = 2;

    @Test
    void detectsABackEdgeOnTheCurrentPath() {
        assertFalse(hasCycle(Map.of(
                0, List.of(1),
                1, List.of(2),
                2, List.of())));
        assertTrue(hasCycle(Map.of(
                0, List.of(1),
                1, List.of(2),
                2, List.of(0))));
    }

    private boolean hasCycle(Map<Integer, List<Integer>> graph) {
        Map<Integer, Integer> colour = new HashMap<>();
        for (int node : graph.keySet()) {
            if (colour.getOrDefault(node, WHITE) == WHITE && visit(node, graph, colour)) {
                return true;
            }
        }
        return false;
    }

    private boolean visit(int node, Map<Integer, List<Integer>> graph, Map<Integer, Integer> colour) {
        colour.put(node, GREY);
        for (int next : graph.getOrDefault(node, List.of())) {
            int state = colour.getOrDefault(next, WHITE);
            if (state == GREY || (state == WHITE && visit(next, graph, colour))) {
                return true;
            }
        }
        colour.put(node, BLACK);
        return false;
    }
}
