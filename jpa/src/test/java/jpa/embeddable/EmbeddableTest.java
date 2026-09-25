package jpa.embeddable;

import jakarta.persistence.*;
import jpa.support.JpaTestSupport;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Embeddable
 *
 * A value object stored as columns on the owning table, not as its own
 * entity. @Embeddable on the type and @Embedded on the field. Address
 * has no id of its own.
 *
 * This test persists a person with an embedded address and reads it back.
 */
class EmbeddableTest {
    @Test
    void persistsEmbeddedAddress() {
        try (var support = new JpaTestSupport(Person.class)) {
            Person person = new Person("Grace", new Address("London", "SW1"));
            support.transaction(em -> em.persist(person));
            try (var em = support.em()) {
                assertEquals("SW1", em.find(Person.class, person.id).address.postcode);
            }
        }
    }
}

@Embeddable
class Address {
    String city;
    String postcode;
    protected Address() {}
    Address(String city, String postcode) { this.city = city; this.postcode = postcode; }
}

@Entity
class Person {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    String name;
    @Embedded Address address;
    protected Person() {}
    Person(String name, Address address) { this.name = name; this.address = address; }
}
