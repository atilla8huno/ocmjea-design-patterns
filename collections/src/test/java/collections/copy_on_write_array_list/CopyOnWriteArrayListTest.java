package collections.copy_on_write_array_list;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Problem: notify every registered listener even if another thread adds one during the broadcast.
 *
 * CopyOnWriteArrayList fits because each iterator is a snapshot. Cheap reads,
 * expensive writes — typical for a listener list.
 */
class CopyOnWriteArrayListTest {
    @Test
    void broadcastUsesTheListenerSnapshotTakenAtIterationStart() {
        CopyOnWriteArrayList<String> listeners = new CopyOnWriteArrayList<>(List.of("mail", "sms"));
        List<String> notified = new ArrayList<>();
        Iterator<String> iterator = listeners.iterator();

        listeners.add("push");
        iterator.forEachRemaining(notified::add);

        assertEquals(List.of("mail", "sms"), notified);
        assertEquals(List.of("mail", "sms", "push"), listeners);
    }

    @Test
    void iteratorRemovalIsUnsupported() {
        Iterator<String> iterator = new CopyOnWriteArrayList<>(List.of("a")).iterator();
        iterator.next();

        assertThrows(UnsupportedOperationException.class, iterator::remove);
    }
}
