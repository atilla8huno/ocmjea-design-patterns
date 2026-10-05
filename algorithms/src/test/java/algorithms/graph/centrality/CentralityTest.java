package algorithms.graph.centrality;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Degree and PageRank
 *
 * Degree is how many edges touch a node: the cheap "who is in the
 * middle?" score. PageRank spreads that idea. Each node starts equal.
 * Each step, a node keeps a damping share (0.85) of the rank flowing
 * in along edges, split by the sender's out-degree, plus a small
 * equal share so a node with no inbound edges is not stuck at zero.
 *
 * On this star, b is the hub: highest degree and highest rank after
 * a few iterations. Analysts use the same scores for influence.
 */
class CentralityTest {
    private static final Map<String, List<String>> STAR = Map.of(
            "a", List.of("b"),
            "b", List.of("a", "c", "d"),
            "c", List.of("b"),
            "d", List.of("b"));

    @Test
    void ranksTheHubHighestByDegreeAndByPageRank() {
        assertEquals("b", highestDegree(STAR));
        assertEquals("b", highestRank(STAR, 20));
    }

    private String highestDegree(Map<String, List<String>> graph) {
        String hub = "";
        int best = -1;
        for (Map.Entry<String, List<String>> entry : graph.entrySet()) {
            if (entry.getValue().size() > best) {
                best = entry.getValue().size();
                hub = entry.getKey();
            }
        }
        return hub;
    }

    private String highestRank(Map<String, List<String>> graph, int steps) {
        double damping = 0.85;
        int count = graph.size();
        Map<String, Double> rank = new HashMap<>();
        for (String node : graph.keySet()) {
            rank.put(node, 1.0 / count);
        }
        for (int step = 0; step < steps; step++) {
            Map<String, Double> next = new HashMap<>();
            for (String node : graph.keySet()) {
                next.put(node, (1 - damping) / count);
            }
            for (Map.Entry<String, List<String>> entry : graph.entrySet()) {
                double share = damping * rank.get(entry.getKey()) / entry.getValue().size();
                for (String neighbour : entry.getValue()) {
                    next.merge(neighbour, share, Double::sum);
                }
            }
            rank = next;
        }
        String hub = "";
        double best = -1;
        for (Map.Entry<String, Double> entry : rank.entrySet()) {
            if (entry.getValue() > best) {
                best = entry.getValue();
                hub = entry.getKey();
            }
        }
        return hub;
    }
}
