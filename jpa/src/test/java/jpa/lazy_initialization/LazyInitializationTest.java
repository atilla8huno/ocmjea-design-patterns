package jpa.lazy_initialization;

import jakarta.persistence.*;
import jpa.support.JpaTestSupport;
import org.hibernate.LazyInitializationException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * LazyInitializationException
 *
 * A lazy collection is a proxy. After the persistence context closes, the
 * session is gone; touching the collection throws
 * LazyInitializationException. Fix it with join fetch, an open session,
 * or mapping the collection EAGER (rarely).
 *
 * This test loads a cart, closes the session, then reads lines.
 */
class LazyInitializationTest {
    @Test
    void accessingLazyCollectionOnDetachedEntityFails() {
        try (var support = new JpaTestSupport(Cart.class, Line.class)) {
            support.transaction(em -> {
                Cart cart = new Cart("open");
                cart.add(new Line("book"));
                em.persist(cart);
            });

            Cart detached;
            try (var em = support.em()) {
                detached = em.createQuery("select c from Cart c", Cart.class).getSingleResult();
                assertEquals("open", detached.name);
            }

            assertThrows(LazyInitializationException.class, () -> detached.lines.size()); // session already closed
        }
    }

    @Test
    void accessingLazyCollectionWhileManagedSucceeds() {
        try (var support = new JpaTestSupport(Cart.class, Line.class)) {
            support.transaction(em -> {
                Cart cart = new Cart("open");
                cart.add(new Line("book"));
                em.persist(cart);
            });
            try (var em = support.em()) {
                Cart managed = em.createQuery("select c from Cart c", Cart.class).getSingleResult();
                assertEquals(1, managed.lines.size());
            }
        }
    }
}

@Entity
class Cart {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    String name;
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Line> lines = new ArrayList<>();
    protected Cart() {}
    Cart(String name) { this.name = name; }
    void add(Line line) { lines.add(line); line.cart = this; }
}

@Entity
class Line {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    String sku;
    @ManyToOne(fetch = FetchType.LAZY) Cart cart;
    protected Line() {}
    Line(String sku) { this.sku = sku; }
}
