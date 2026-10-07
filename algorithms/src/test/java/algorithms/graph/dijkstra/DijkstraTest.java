package algorithms.graph.dijkstra;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Dijkstra
 *
 * Shortest path when edges have different non-negative weights. A
 * priority queue always expands the cheapest known distance next.
 * The first time a node leaves the queue at its best distance, that
 * cost is final. Java's PriorityQueue has no decrease-key, so a
 * better path pushes a new entry and the older one is skipped later.
 *
 * Breadth-first search matches this only when every edge costs 1.
 * Here a to c is cheaper through b (1 + 2) than along the direct edge (4).
 */
class DijkstraTest {
    private record Edge(String to, int weight) {}

    private static final Map<String, List<Edge>> ROUTES = Map.of(
            "a", List.of(new Edge("b", 1), new Edge("c", 4)),
            "b", List.of(new Edge("c", 2), new Edge("d", 6)),
            "c", List.of(new Edge("d", 1)),
            "d", List.of());

    @Test
    void findsTheCheapestPath() {
        assertEquals(0, cost("a", "a"));
        assertEquals(3, cost("a", "c"));
        assertEquals(4, cost("a", "d"));
        assertEquals(-1, cost("d", "a"));
    }

    private int cost(String from, String to) {
        record Step(String name, int distance) {}
        Map<String, Integer> best = new HashMap<>();
        best.put(from, 0);
        PriorityQueue<Step> pending = new PriorityQueue<>(Comparator.comparingInt(Step::distance));
        pending.add(new Step(from, 0));
        while (!pending.isEmpty()) {
            Step current = pending.poll();
            if (current.distance() > best.getOrDefault(current.name(), Integer.MAX_VALUE)) {
                continue; // a cheaper entry for this node is already queued
            }
            if (current.name().equals(to)) {
                return current.distance();
            }
            for (Edge edge : ROUTES.getOrDefault(current.name(), List.of())) {
                int nextDistance = current.distance() + edge.weight();
                if (nextDistance < best.getOrDefault(edge.to(), Integer.MAX_VALUE)) {
                    best.put(edge.to(), nextDistance);
                    pending.add(new Step(edge.to(), nextDistance));
                }
            }
        }
        return -1;
    }
}
