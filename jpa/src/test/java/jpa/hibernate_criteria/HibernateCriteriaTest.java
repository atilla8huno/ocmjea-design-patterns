package jpa.hibernate_criteria;

import jakarta.persistence.*;
import jpa.support.JpaTestSupport;
import org.hibernate.query.criteria.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Hibernate Criteria
 *
 * Hibernate's own criteria API (beyond JPA). Typed selection plus
 * criteria insert, update and delete. Useful when you need a Hibernate
 * feature that JPA Criteria does not expose (insert).
 *
 * This test selects a row and applies those mutations.
 */
class HibernateCriteriaTest {
    @Test
    void usesHibernateCriteriaExtensions() {
        try (var support = new JpaTestSupport(Product.class)) {
            support.transaction(em -> em.persist(new Product("old", 1)));
            support.transaction(em -> {
                var session = em.unwrap(org.hibernate.Session.class);
                HibernateCriteriaBuilder cb = session.getCriteriaBuilder();
                JpaCriteriaUpdate<Product> update = cb.createCriteriaUpdate(Product.class);
                var root = update.from(Product.class);
                update.set(root.get("price"), 2).where(cb.equal(root.get("name"), "old"));
                assertEquals(1, em.createQuery(update).executeUpdate());

                JpaCriteriaInsertValues<Product> insert = cb.createCriteriaInsertValues(Product.class);
                var target = insert.getTarget();
                insert.setInsertionTargetPaths(target.get("name"), target.get("price"));
                insert.values(cb.values(cb.literal("new"), cb.literal(3)));
                assertEquals(1, session.createMutationQuery(insert).executeUpdate());
            });
            try (var em = support.em()) {
                HibernateCriteriaBuilder cb = em.unwrap(org.hibernate.Session.class).getCriteriaBuilder();
                JpaCriteriaQuery<Product> query = cb.createQuery(Product.class);
                var root = query.from(Product.class);
                query.select(root).where(cb.gt(root.get("price"), 1));
                assertEquals(2, em.createQuery(query).getResultList().size());
            }
            support.transaction(em -> {
                HibernateCriteriaBuilder cb = em.unwrap(org.hibernate.Session.class).getCriteriaBuilder();
                JpaCriteriaDelete<Product> delete = cb.createCriteriaDelete(Product.class);
                var root = delete.from(Product.class);
                delete.where(cb.equal(root.get("name"), "old"));
                assertEquals(1, em.createQuery(delete).executeUpdate());
            });
        }
    }
}

@Entity
class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    String name;
    int price;
    protected Product() {}
    Product(String name, int price) { this.name = name; this.price = price; }
}
