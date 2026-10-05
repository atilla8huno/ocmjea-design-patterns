package algorithms.graph.dfs;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Depth-first search
 *
 * DFS follows one branch as far as it goes, then backtracks. Recursion
 * is the call stack; an explicit Deque used as a stack does the same
 * walk without recursion. A visited set is still required, or a cycle
 * never ends.
 *
 * Unlike BFS, the first hit is not a shortest path. This test only
 * checks which nodes are reachable from a.
 */
class DepthFirstSearchTest {
    private static final Map<String, List<String>> ROUTES = Map.of(
            "a", List.of("b", "c"),
            "b", List.of("d"),
            "c", List.of(),
            "d", List.of(),
            "z", List.of());

    @Test
    void findsTheSameReachableSetRecursivelyAndWithAStack() {
        assertEquals(Set.of("a", "b", "c", "d"), reachableRecursive("a"));
        assertEquals(Set.of("a", "b", "c", "d"), reachableStack("a"));
        assertEquals(Set.of("z"), reachableRecursive("z"));
    }

    private Set<String> reachableRecursive(String start) {
        Set<String> seen = new HashSet<>();
        walk(start, seen);
        return seen;
    }

    private void walk(String node, Set<String> seen) {
        if (!seen.add(node)) {
            return;
        }
        for (String next : ROUTES.getOrDefault(node, List.of())) {
            walk(next, seen);
        }
    }

    private Set<String> reachableStack(String start) {
        Set<String> seen = new HashSet<>();
        Deque<String> pending = new ArrayDeque<>();
        pending.push(start);
        while (!pending.isEmpty()) {
            String node = pending.pop();
            if (!seen.add(node)) {
                continue;
            }
            for (String next : ROUTES.getOrDefault(node, List.of())) {
                pending.push(next);
            }
        }
        return seen;
    }
}
