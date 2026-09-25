package collections.map;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Problem: convert a Roman numeral to a number using a fixed symbol table.
 *
 * Map fits because the read-only table gives constant-time lookups for every symbol and cannot be
 * modified while the conversion runs.
 */
class MapTest {
    private static final Map<Character, Integer> SYMBOLS = Map.of(
            'I', 1, 'V', 5, 'X', 10, 'L', 50, 'C', 100, 'D', 500, 'M', 1000);

    private int toArabic(String numeral) {
        int total = 0;
        for (int index = 0; index < numeral.length(); index++) {
            int value = SYMBOLS.get(numeral.charAt(index));
            int next = index + 1 < numeral.length() ? SYMBOLS.get(numeral.charAt(index + 1)) : 0;
            total += value < next ? -value : value;
        }
        return total;
    }

    @Test
    void convertsNumeralsThroughTheSymbolTable() {
        assertEquals(9, toArabic("IX"));
        assertEquals(1994, toArabic("MCMXCIV"));
    }

    @Test
    void lookupReportsAMissingKey() {
        assertNull(SYMBOLS.get('A'));
        assertEquals(0, SYMBOLS.getOrDefault('A', 0));
    }
}
