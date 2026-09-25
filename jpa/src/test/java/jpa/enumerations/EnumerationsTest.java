package jpa.enumerations;

import jakarta.persistence.*;
import jpa.support.JpaTestSupport;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Enumerated attributes
 *
 * Persist an enum as a string (@Enumerated(EnumType.STRING)) so renaming
 * ordinals does not break rows. ORDINAL stores the index and is brittle.
 *
 * This test saves a status and checks the column round-trips as text.
 */
class EnumerationsTest {
    @Test
    void storesEnumByName() {
        try (var support = new JpaTestSupport(Ticket.class)) {
            Ticket ticket = new Ticket(Status.OPEN);
            support.transaction(em -> em.persist(ticket));
            try (var em = support.em()) {
                assertEquals(Status.OPEN, em.find(Ticket.class, ticket.id).status);
            }
        }
    }
}

enum Status { OPEN, CLOSED }

@Entity
class Ticket {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    @Enumerated(EnumType.STRING) Status status;
    protected Ticket() {}
    Ticket(Status status) { this.status = status; }
}
