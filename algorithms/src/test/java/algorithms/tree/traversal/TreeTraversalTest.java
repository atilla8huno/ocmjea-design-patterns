package algorithms.tree.traversal;

import algorithms.tree.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Binary tree traversal
 *
 * A tree is a graph with one parent and no cycles. DFS (here, max
 * depth and invert) follows left then right via recursion. BFS level
 * order uses a queue and processes one whole level before the next,
 * which is the same idea as graph BFS.
 *
 * This test uses a tree 1 with children 2 and 3, and 2 with children 4 and 5.
 */
class TreeTraversalTest {

    @Test
    void measuresDepthInvertsAndListsLevels() {
        assertEquals(3, maxDepth(sample()));
        assertEquals(List.of(List.of(1), List.of(3, 2), List.of(5, 4)), levels(invert(sample())));
        assertEquals(List.of(List.of(1), List.of(2, 3), List.of(4, 5)), levels(sample()));
    }

    private TreeNode sample() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        return root;
    }

    private int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(node.left), maxDepth(node.right));
    }

    private TreeNode invert(TreeNode node) {
        if (node == null) {
            return null;
        }
        TreeNode left = node.left;
        node.left = invert(node.right);
        node.right = invert(left);
        return node;
    }

    private List<List<Integer>> levels(TreeNode root) {
        if (root == null) {
            return List.of();
        }
        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> pending = new ArrayDeque<>();
        pending.addLast(root);
        while (!pending.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int width = pending.size();
            for (int index = 0; index < width; index++) {
                TreeNode node = pending.removeFirst();
                level.add(node.value);
                if (node.left != null) {
                    pending.addLast(node.left);
                }
                if (node.right != null) {
                    pending.addLast(node.right);
                }
            }
            result.add(level);
        }
        return result;
    }
}
