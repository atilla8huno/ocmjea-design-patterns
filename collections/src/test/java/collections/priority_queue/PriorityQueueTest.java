package collections.priority_queue;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * Problem: keep the three largest values of a stream and always serve the most urgent task first.
 *
 * PriorityQueue fits because the smallest element is always at the head, so a bounded min-heap
 * solves top-k in O(n log k) without sorting the whole input. The head is
 * the least element by the comparator, not the insertion order.
 */
class PriorityQueueTest {
    private List<Integer> topThree(List<Integer> values) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int value : values) {
            heap.add(value);
            if (heap.size() > 3) {
                heap.poll();
            }
        }
        List<Integer> ranked = new ArrayList<>(heap);
        ranked.sort(Comparator.reverseOrder());
        return ranked;
    }

    @Test
    void keepsTheThreeLargestValuesOfAStream() {
        assertEquals(List.of(9, 8, 7), topThree(List.of(5, 9, 1, 8, 3, 7, 2)));
        assertEquals(List.of(2, 1), topThree(List.of(1, 2)));
    }

    @Test
    void servesTasksByUrgency() {
        record Task(int urgency, String name) {}
        PriorityQueue<Task> tasks = new PriorityQueue<>(Comparator.comparingInt(Task::urgency));
        tasks.add(new Task(3, "cleanup"));
        tasks.add(new Task(1, "page oncall"));
        tasks.add(new Task(2, "retry"));

        assertEquals("page oncall", tasks.poll().name());
        assertEquals("retry", tasks.poll().name());
        assertEquals("cleanup", tasks.poll().name());
    }

    @Test
    void iterationIsNotASortedTraversal() {
        PriorityQueue<Integer> queue = new PriorityQueue<>(List.of(10, 1, 9, 2, 8, 3));

        assertEquals(1, queue.peek());
        assertNotEquals(List.of(1, 2, 3, 8, 9, 10), List.copyOf(queue));
    }
}
