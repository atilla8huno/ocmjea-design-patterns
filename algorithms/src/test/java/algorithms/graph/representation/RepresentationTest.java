package algorithms.graph.representation;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Graph representation
 *
 * Interviews almost always want an adjacency list: a map (or array of
 * lists) from a node to its neighbours. Sparse graphs stay small, and
 * walking the edges of one node is a loop over that list.
 *
 * A matrix (boolean[n][n]) answers "is there an edge?" in constant time
 * but costs n² space. Use it only when the graph is small and dense.
 * This test stores the same three-node graph both ways.
 */
class RepresentationTest {

    @Test
    void storesTheSameEdgesAsAListAndAsAMatrix() {
        Map<String, List<String>> list = Map.of(
                "a", List.of("b", "c"),
                "b", List.of("c"),
                "c", List.of());

        boolean[][] matrix = {
                {false, true, true},
                {false, false, true},
                {false, false, false}
        };

        assertEquals(List.of("b", "c"), list.get("a"));
        assertTrue(matrix[0][1]);
        assertTrue(matrix[0][2]);
        assertFalse(matrix[1][0]);
    }
}
