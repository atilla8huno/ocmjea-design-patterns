package algorithms.linked_list.reverse;

import algorithms.linked_list.ListNode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Reverse a linked list
 *
 * Walk the nodes once and flip each next pointer to the previous node.
 * Keep the node that used to follow, or you lose the rest of the list.
 * The old head becomes the tail (next is null); the last node you saw
 * is the new head.
 *
 * Recursion does the same flip on the way back. This test reverses
 * 1 → 2 → 3 both ways.
 */
class ReverseTest {

    @Test
    void flipsPointersIterativelyAndRecursively() {
        assertEquals(List.of(3, 2, 1), reverse(ListNode.of(1, 2, 3)).values());
        assertEquals(List.of(3, 2, 1), reverseRecursive(ListNode.of(1, 2, 3)).values());
        assertNull(reverse(null));
    }

    private ListNode reverse(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    private ListNode reverseRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
