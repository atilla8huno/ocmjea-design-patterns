package collections.primitive_arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Problem: answer repeated range-sum queries over a fixed numeric series.
 *
 * int[] fits because it stores unboxed values in contiguous memory, so building the prefix-sum
 * table and querying it costs no allocation per element.
 */
class PrimitiveArraysTest {
    private int[] prefixSums(int[] values) {
        int[] sums = new int[values.length + 1];
        for (int index = 0; index < values.length; index++) {
            sums[index + 1] = sums[index] + values[index];
        }
        return sums;
    }

    @Test
    void answersRangeSumsFromAPrefixTable() {
        int[] sums = prefixSums(new int[] { 3, 1, 4, 1, 5, 9 });

        assertEquals(5, sums[3] - sums[1]);
        assertEquals(19, sums[6] - sums[2]);
        assertEquals(23, sums[sums.length - 1]);
    }

    @Test
    void createsAndTransformsPrimitiveValues() {
        int[] squares = new int[4];
        for (int index = 0; index < squares.length; index++) {
            squares[index] = index * index;
        }

        assertArrayEquals(new int[] { 0, 1, 4, 9 }, squares);
        assertEquals(14, java.util.Arrays.stream(squares).sum());
    }
}
