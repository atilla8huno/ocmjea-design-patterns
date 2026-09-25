package collections.delay_queue;

import org.junit.jupiter.api.Test;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Problem: release scheduled jobs only after their delay has elapsed, earliest first.
 *
 * DelayQueue fits because poll returns an item only when getDelay is zero or negative.
 */
class DelayQueueTest {
    private record Job(String name, long delayNanos) implements Delayed {
        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(delayNanos, TimeUnit.NANOSECONDS);
        }

        @Override
        public int compareTo(Delayed other) {
            return Long.compare(getDelay(TimeUnit.NANOSECONDS), other.getDelay(TimeUnit.NANOSECONDS));
        }
    }

    @Test
    void dueJobsAreReleasedAndFutureJobsStayQueued() {
        DelayQueue<Job> queue = new DelayQueue<>();
        queue.offer(new Job("send-report", -1));
        queue.offer(new Job("retry-later", TimeUnit.HOURS.toNanos(1)));

        assertEquals("send-report", queue.poll().name());
        assertNull(queue.poll());
        assertEquals(1, queue.size());
    }
}
