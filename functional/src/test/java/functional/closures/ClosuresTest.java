package functional.closures;

import org.junit.jupiter.api.Test;

import java.util.function.IntUnaryOperator;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Closures
 *
 * A lambda can read locals from the enclosing scope. Those locals must
 * be final or effectively final — you cannot assign them after capture.
 * The captured value is a copy of the variable, not a live binding.
 *
 * This test builds an adder that closes over a factor of 10.
 */
class ClosuresTest {

    @Test
    void capturesAnEffectivelyFinalLocal() {
        int factor = 10;
        IntUnaryOperator timesFactor = value -> value * factor;

        assertEquals(40, timesFactor.applyAsInt(4));
        assertEquals(0, timesFactor.applyAsInt(0));
    }
}
