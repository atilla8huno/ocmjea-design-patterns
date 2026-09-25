package collections.concurrent_hash_map;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Problem: initialise a shared cache once, even when several threads miss the same key together.
 *
 * ConcurrentHashMap fits because computeIfAbsent and merge update a bucket atomically.
 */
class ConcurrentHashMapTest {
    @Test
    void loadsACacheEntryOnce() {
        ConcurrentHashMap<String, String> cache = new ConcurrentHashMap<>();
        AtomicInteger loads = new AtomicInteger();

        for (int i = 0; i < 3; i++) {
            cache.computeIfAbsent("user-1", key -> {
                loads.incrementAndGet();
                return "value-of-" + key;
            });
        }

        assertEquals("value-of-user-1", cache.get("user-1"));
        assertEquals(1, loads.get());
    }

    @Test
    void countsHitsWithMerge() {
        ConcurrentHashMap<String, Integer> hits = new ConcurrentHashMap<>();
        hits.merge("home", 1, Integer::sum);
        hits.merge("home", 1, Integer::sum);

        assertEquals(2, hits.get("home"));
    }

    @Test
    void nullValuesAreRejected() {
        ConcurrentHashMap<String, String> values = new ConcurrentHashMap<>();

        assertThrows(NullPointerException.class, () -> values.put("key", null));
    }
}
