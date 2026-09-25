package collections.concurrent_linked_queue;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Problem: collect work from several producer threads without locking the queue.
 *
 * ConcurrentLinkedQueue fits because offer and poll are lock-free FIFO operations.
 */
class ConcurrentLinkedQueueTest {
    @Test
    void manyProducersEnqueueWorkForOneConsumer() throws InterruptedException {
        ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<>();
        Thread[] producers = new Thread[4];
        for (int start = 0; start < 4; start++) {
            int offset = start;
            producers[start] = new Thread(() -> {
                for (int value = offset; value < 20; value += 4) {
                    queue.offer(value);
                }
            });
            producers[start].start();
        }
        for (Thread producer : producers) {
            producer.join();
        }

        Set<Integer> drained = new HashSet<>();
        Integer next;
        while ((next = queue.poll()) != null) {
            drained.add(next);
        }

        assertEquals(20, drained.size());
    }

    @Test
    void nullElementsAreRejected() {
        ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();

        assertThrows(NullPointerException.class, () -> queue.offer(null));
    }
}
