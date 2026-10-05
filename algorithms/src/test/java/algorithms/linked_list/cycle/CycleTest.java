package algorithms.linked_list.cycle;

import algorithms.linked_list.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Cycle in a linked list (Floyd)
 *
 * Two pointers start together. Slow moves one step, fast moves two.
 * If there is a loop they meet inside it; if fast falls off the end,
 * there is no cycle. You do not need the length or a visited set.
 *
 * This test links 3 back to 2, and checks a straight list is clean.
 */
class CycleTest {

    @Test
    void slowAndFastMeetOnlyWhenThereIsALoop() {
        ListNode cycled = ListNode.of(1, 2, 3);
        cycled.next.next.next = cycled.next;

        assertTrue(hasCycle(cycled));
        assertFalse(hasCycle(ListNode.of(1, 2, 3)));
        assertFalse(hasCycle(null));
    }

    private boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
