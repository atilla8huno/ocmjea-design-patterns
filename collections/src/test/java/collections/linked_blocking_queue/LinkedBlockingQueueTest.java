package collections.linked_blocking_queue;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Problem: stream tasks to a worker thread and shut it down with a poison pill.
 *
 * LinkedBlockingQueue fits because take blocks until work arrives. Capacity
 * is optional; a poison pill is the usual way to stop the worker.
 */
class LinkedBlockingQueueTest {
    private static final String POISON_PILL = "STOP";

    @Test
    void theWorkerDrainsTasksUntilItReceivesThePoisonPill() throws InterruptedException {
        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>(4);
        List<String> processed = new ArrayList<>();
        Thread worker = new Thread(() -> {
            try {
                while (true) {
                    String task = queue.take(); // parks until a task or the poison pill arrives
                    if (POISON_PILL.equals(task)) {
                        break;
                    }
                    processed.add(task);
                }
            } catch (InterruptedException exception) {
                Thread.currentThread().interrupt();
            }
        });
        worker.start();
        queue.put("a");
        queue.put("b");
        queue.put("c");
        queue.put(POISON_PILL);
        worker.join(); // wait until the worker saw the poison pill

        assertEquals(List.of("a", "b", "c"), processed);
        assertTrue(queue.isEmpty());
    }

    @Test
    void aConfiguredCapacityLimitsOffers() throws InterruptedException {
        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>(2);
        queue.put(1);
        queue.put(2);

        assertFalse(queue.offer(3, 10, TimeUnit.MILLISECONDS)); // full: offer fails after the timeout
        assertEquals(0, queue.remainingCapacity());
    }
}
