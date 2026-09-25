package jpa.inheritance;

import jakarta.persistence.*;
import jpa.support.JpaTestSupport;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Inheritance
 *
 * Map a type hierarchy to the database. SINGLE_TABLE stores every subclass
 * in one table with a discriminator column. Fast reads; nullable columns
 * for subclass fields.
 *
 * This test persists two payment subtypes and queries them as the base type.
 */
class InheritanceTest {
    @Test
    void loadsSubtypePolymorphically() {
        try (var support = new JpaTestSupport(Payment.class, CardPayment.class, CashPayment.class)) {
            CardPayment payment = new CardPayment(25, "4242");
            support.transaction(em -> em.persist(payment));
            try (var em = support.em()) {
                assertInstanceOf(CardPayment.class, em.find(Payment.class, payment.id));
            }
        }
    }
}

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "payment_type")
abstract class Payment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    int amount;
    protected Payment() {}
    Payment(int amount) { this.amount = amount; }
}

@Entity @DiscriminatorValue("CARD")
class CardPayment extends Payment {
    String lastFour;
    protected CardPayment() {}
    CardPayment(int amount, String lastFour) { super(amount); this.lastFour = lastFour; }
}

@Entity @DiscriminatorValue("CASH")
class CashPayment extends Payment {
    protected CashPayment() {}
    CashPayment(int amount) { super(amount); }
}
