package jpa.transaction;

import jakarta.persistence.*;
import jpa.support.JpaTestSupport;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Transactions
 *
 * begin / commit makes writes visible to the next session. rollback
 * discards them. Without a transaction, persist may not flush as you
 * expect on some setups.
 *
 * This test commits one row and rolls another back, then checks visibility.
 */
class TransactionTest {
    @Test
    void commitsAndRollsBack() {
        try (var support = new JpaTestSupport(Account.class)) {
            support.transaction(em -> em.persist(new Account("committed")));
            try (var em = support.em()) {
                em.getTransaction().begin();
                em.persist(new Account("rolled back"));
                em.getTransaction().rollback();
            }
            try (var em = support.em()) {
                assertEquals(1L, em.createQuery("select count(a) from Account a", Long.class).getSingleResult());
            }
        }
    }
}

@Entity
class Account {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    String name;
    protected Account() {}
    Account(String name) { this.name = name; }
}
