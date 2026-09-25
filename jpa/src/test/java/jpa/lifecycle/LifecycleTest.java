package jpa.lifecycle;

import jakarta.persistence.*;
import jpa.support.JpaTestSupport;
import org.junit.jupiter.api.Test;
import java.time.Instant;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Lifecycle callbacks
 *
 * @PrePersist and @PreUpdate run just before insert and update. Use them
 * for audit timestamps so the application does not set those fields by
 * hand on every save.
 *
 * This test persists, then updates, and checks createdAt / updatedAt.
 */
class LifecycleTest {
    @Test
    void invokesPersistAndUpdateCallbacks() {
        try (var support = new JpaTestSupport(Document.class)) {
            Document document = new Document("draft");
            support.transaction(em -> em.persist(document));
            Instant created = document.createdAt;
            support.transaction(em -> em.find(Document.class, document.id).title = "final");
            try (var em = support.em()) {
                Document loaded = em.find(Document.class, document.id);
                assertEquals(created, loaded.createdAt);
                assertNotNull(loaded.updatedAt);
            }
        }
    }
}

@Entity
class Document {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    String title;
    Instant createdAt;
    Instant updatedAt;
    protected Document() {}
    Document(String title) { this.title = title; }
    @PrePersist void created() { createdAt = Instant.now(); }
    @PreUpdate void updated() { updatedAt = Instant.now(); }
}
