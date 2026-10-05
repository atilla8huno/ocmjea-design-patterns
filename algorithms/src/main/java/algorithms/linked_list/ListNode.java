package algorithms.linked_list;

import java.util.ArrayList;
import java.util.List;

public class ListNode {
    public final int value;
    public ListNode next;

    public ListNode(int value) {
        this.value = value;
    }

    public static ListNode of(int... values) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int value : values) {
            current.next = new ListNode(value);
            current = current.next;
        }
        return dummy.next;
    }

    public List<Integer> values() {
        List<Integer> result = new ArrayList<>();
        for (ListNode node = this; node != null; node = node.next) {
            result.add(node.value);
        }
        return result;
    }
}
