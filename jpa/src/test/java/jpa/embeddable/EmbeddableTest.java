package jpa.embeddable;

import jakarta.persistence.*;
import jpa.support.JpaTestSupport;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Demonstrates storing a value object as columns owned by its containing entity.
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
