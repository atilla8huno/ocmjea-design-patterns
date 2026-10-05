package algorithms.linked_list.merge;

import algorithms.linked_list.ListNode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Merge two sorted lists
 *
 * Both lists are already ordered. A dummy head lets you splice nodes
 * without a special case for the first one. At each step attach the
 * smaller head, then advance that list. Append whatever remains.
 *
 * You reuse the existing nodes; you do not allocate a new chain.
 * This test merges 1 → 3 → 5 with 2 → 4 → 6.
 */
class MergeTest {

    @Test
    void splicesNodesIntoOneSortedList() {
        ListNode merged = merge(ListNode.of(1, 3, 5), ListNode.of(2, 4, 6));

        assertEquals(List.of(1, 2, 3, 4, 5, 6), merged.values());
        assertEquals(List.of(1, 2), merge(ListNode.of(1), ListNode.of(2)).values());
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (left != null && right != null) {
            if (left.value <= right.value) {
                tail.next = left;
                left = left.next;
            } else {
                tail.next = right;
                right = right.next;
            }
            tail = tail.next;
        }
        tail.next = left != null ? left : right;
        return dummy.next;
    }
}
