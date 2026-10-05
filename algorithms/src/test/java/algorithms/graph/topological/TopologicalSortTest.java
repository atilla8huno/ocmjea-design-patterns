package algorithms.graph.topological;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Topological order (Kahn)
 *
 * A DAG has an order where every edge goes forward. Count indegrees,
 * queue every node with indegree 0, then pop one and decrement its
 * neighbours. A neighbour that hits 0 joins the queue.
 *
 * If the result is shorter than the node count, a cycle ate the rest
 * and there is no order. This test orders a small course graph and
 * rejects a loop.
 */
class TopologicalSortTest {

    @Test
    void ordersADagAndRejectsACycle() {
        List<Integer> order = order(3, new int[][]{{0, 1}, {0, 2}, {1, 2}});

        assertEquals(3, order.size());
        assertTrue(order.indexOf(0) < order.indexOf(1));
        assertTrue(order.indexOf(0) < order.indexOf(2));
        assertTrue(order.indexOf(1) < order.indexOf(2));
        assertEquals(List.of(), order(2, new int[][]{{0, 1}, {1, 0}}));
    }

    private List<Integer> order(int nodes, int[][] edges) {
        List<List<Integer>> outgoing = new ArrayList<>();
        int[] indegree = new int[nodes];
        for (int node = 0; node < nodes; node++) {
            outgoing.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            outgoing.get(edge[0]).add(edge[1]);
            indegree[edge[1]]++;
        }
        Deque<Integer> ready = new ArrayDeque<>();
        for (int node = 0; node < nodes; node++) {
            if (indegree[node] == 0) {
                ready.addLast(node);
            }
        }
        List<Integer> sorted = new ArrayList<>();
        while (!ready.isEmpty()) {
            int node = ready.removeFirst();
            sorted.add(node);
            for (int next : outgoing.get(node)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    ready.addLast(next);
                }
            }
        }
        return sorted.size() == nodes ? sorted : List.of();
    }
}
