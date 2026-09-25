package jpa.query;

import jakarta.persistence.*;
import jpa.support.JpaTestSupport;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Queries
 *
 * Three ways to load: find() by primary key, an ad-hoc JPQL createQuery,
 * and a @NamedQuery reused by name. JPQL works with entities, not tables.
 *
 * This test loads the same row those three ways.
 */
class QueryTest {
    @Test
    void usesFindJpqlAndNamedQuery() {
        try (var support = new JpaTestSupport(Book.class)) {
            Book book = new Book("Persistence", "Ada");
            support.transaction(em -> em.persist(book));
            try (var em = support.em()) {
                assertEquals("Persistence", em.find(Book.class, book.id).title);
                assertEquals(1, em.createQuery("select b from Book b where b.author = :author", Book.class)
                        .setParameter("author", "Ada").getResultList().size());
                assertEquals(book.id, em.createNamedQuery("Book.byTitle", Book.class)
                        .setParameter("title", "Persistence").getSingleResult().id);
            }
        }
    }
}

@Entity
@NamedQuery(name = "Book.byTitle", query = "select b from Book b where b.title = :title")
class Book {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    String title;
    String author;
    protected Book() {}
    Book(String title, String author) { this.title = title; this.author = author; }
}
