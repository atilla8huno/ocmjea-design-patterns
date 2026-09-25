package jpa.entity;

import jakarta.persistence.*;
import jpa.support.JpaTestSupport;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Entity and generated id
 *
 * A JPA entity is a class mapped to a table. @Id plus GenerationType.IDENTITY
 * lets PostgreSQL assign the primary key on insert. persist() makes the
 * instance managed; the id is filled after flush.
 *
 * This test persists a row and reads it back by id.
 */
class EntityTest {
    @Test
    void persistsAndFindsEntity() {
        try (var support = new JpaTestSupport(Customer.class)) {
            Customer customer = new Customer("Ada");
            support.transaction(em -> em.persist(customer));
            try (var em = support.em()) {
                assertEquals("Ada", em.find(Customer.class, customer.id).name);
            }
        }
    }
}

@Entity
class Customer {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    protected Customer() {}
    Customer(String name) { this.name = name; }
}
