package collections.linked_map;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Problem: cache a bounded number of entries and evict the least recently used one when it is full.
 *
 * LinkedHashMap fits because access-order mode plus removeEldestEntry implements an LRU policy
 * with constant-time lookups and a predictable iteration order.
 */
class LinkedMapTest {
    private static final class LruCache<K, V> extends LinkedHashMap<K, V> {
        private final int capacity;

        private LruCache(int capacity) {
            super(capacity, 0.75f, true);
            this.capacity = capacity;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            return size() > capacity;
        }
    }

    @Test
    void evictsTheLeastRecentlyUsedEntry() {
        Map<String, Integer> cache = new LruCache<>(2);
        cache.put("a", 1);
        cache.put("b", 2);
        cache.get("a");
        cache.put("c", 3);

        assertEquals(List.of("a", "c"), List.copyOf(cache.keySet()));
        assertNull(cache.get("b"));
    }

    @Test
    void retainsInsertionOrderByDefault() {
        Map<String, Integer> values = new LinkedHashMap<>();
        values.put("b", 2);
        values.put("a", 1);
        values.put("c", 3);

        assertEquals(List.of("b", "a", "c"), List.copyOf(values.keySet()));
    }
}
