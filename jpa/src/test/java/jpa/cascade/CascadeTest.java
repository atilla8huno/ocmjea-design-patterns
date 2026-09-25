package jpa.cascade;

import jakarta.persistence.*;
import jpa.support.JpaTestSupport;
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Demonstrates cascading persistence and orphan removal for an aggregate's children.
 */
class CascadeTest {
    @Test
    void cascadesPersistAndRemovesOrphan() {
        try (var support = new JpaTestSupport(Order.class, LineItem.class)) {
            Order order = new Order();
            order.add(new LineItem("keyboard"));
            order.add(new LineItem("mouse"));
            support.transaction(em -> em.persist(order));
            support.transaction(em -> em.find(Order.class, order.id).items.remove(0));
            try (var em = support.em()) {
                assertEquals(1L, em.createQuery("select count(i) from LineItem i", Long.class).getSingleResult());
            }
        }
    }
}

@Entity(name = "PurchaseOrder")
@Table(name = "purchase_orders")
class Order {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true) List<LineItem> items = new ArrayList<>();
    void add(LineItem item) { items.add(item); item.order = this; }
}

@Entity
class LineItem {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    String product;
    @ManyToOne Order order;
    protected LineItem() {}
    LineItem(String product) { this.product = product; }
}
