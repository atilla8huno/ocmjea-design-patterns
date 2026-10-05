package algorithms.graph.components;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * Connected components (Union-Find)
 *
 * Fraud rings are accounts joined by a shared phone, device, or address.
 * Union-Find groups them without walking the whole graph each time.
 * find follows the parent pointer and compresses the path. union links
 * the two roots, attaching the shorter tree under the taller one (rank).
 *
 * This test joins three accounts into one ring and leaves a fourth alone.
 * A directed cycle test only answers "is there a loop?", not "who is together?".
 */
class ComponentsTest {

    @Test
    void groupsAccountsThatShareALink() {
        UnionFind rings = new UnionFind();
        rings.add("a");
        rings.add("b");
        rings.add("c");
        rings.add("d");
        rings.union("a", "b");
        rings.union("b", "c");

        assertEquals(rings.find("a"), rings.find("c"));
        assertNotEquals(rings.find("a"), rings.find("d"));
    }

    private static final class UnionFind {
        private final Map<String, String> parent = new HashMap<>();
        private final Map<String, Integer> rank = new HashMap<>();

        void add(String account) {
            parent.putIfAbsent(account, account);
            rank.putIfAbsent(account, 0);
        }

        String find(String account) {
            String root = parent.get(account);
            if (!root.equals(account)) {
                parent.put(account, find(root));
            }
            return parent.get(account);
        }

        void union(String left, String right) {
            String leftRoot = find(left);
            String rightRoot = find(right);
            if (leftRoot.equals(rightRoot)) {
                return;
            }
            int leftRank = rank.get(leftRoot);
            int rightRank = rank.get(rightRoot);
            if (leftRank < rightRank) {
                parent.put(leftRoot, rightRoot);
            } else if (leftRank > rightRank) {
                parent.put(rightRoot, leftRoot);
            } else {
                parent.put(rightRoot, leftRoot);
                rank.put(leftRoot, leftRank + 1);
            }
        }
    }
}
