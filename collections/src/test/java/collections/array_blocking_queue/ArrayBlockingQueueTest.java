package collections.array_blocking_queue;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * Problem: hand work from a producer thread to a consumer thread through a small fixed buffer.
 *
 * ArrayBlockingQueue fits because its bounded capacity applies backpressure to a fast producer while
 * take parks the consumer until an item is available. Use it for a fixed-size
 * hand-off between threads (classic producer/consumer).
 */
class ArrayBlockingQueueTest {
    @Test
    void aBoundedBufferCarriesEveryItemBetweenTwoThreads() throws InterruptedException {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(2);
        List<Integer> consumed = new ArrayList<>();

        Thread producer = new Thread(() -> {
            try {
                for (int value = 1; value <= 10; value++) {
                    queue.put(value); // blocks while the buffer is full
                }
            } catch (InterruptedException exception) {
                Thread.currentThread().interrupt();
            }
        });
        Thread consumer = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    consumed.add(queue.take()); // blocks while the buffer is empty
                }
            } catch (InterruptedException exception) {
                Thread.currentThread().interrupt();
            }
        });
        producer.start();
        consumer.start();
        producer.join(); // wait until the other thread has finished
        consumer.join();

        assertEquals(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), consumed);
        assertEquals(2, queue.remainingCapacity());
    }

    @Test
    void offerReportsAFullQueueInsteadOfBlocking() throws InterruptedException {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(1);
        queue.put(1);

        assertFalse(queue.offer(2, 10, TimeUnit.MILLISECONDS)); // times out instead of blocking forever
        assertEquals(1, queue.poll());
    }
}
