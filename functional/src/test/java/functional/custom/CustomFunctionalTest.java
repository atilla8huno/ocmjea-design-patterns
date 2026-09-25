package functional.custom;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Custom functional interface
 *
 * @FunctionalInterface is a single-abstract-method type you own.
 * Lambdas and method references implement it. Use it when Function
 * or Predicate would hide the domain name (here a Discount).
 *
 * This test applies no discount and ten percent off.
 */
class CustomFunctionalTest {

    @Test
    void appliesNamedDiscountLambdas() {
        Discount none = amount -> amount;
        Discount tenPercent = amount -> amount * 0.9;

        assertEquals(100.0, price(100.0, none));
        assertEquals(90.0, price(100.0, tenPercent));
        assertEquals(80.0, price(100.0, CustomFunctionalTest::twentyPercent));
    }

    private static double price(double amount, Discount discount) {
        return discount.apply(amount);
    }

    private static double twentyPercent(double amount) {
        return amount * 0.8;
    }

    @FunctionalInterface
    interface Discount {
        double apply(double amount);
    }
}
