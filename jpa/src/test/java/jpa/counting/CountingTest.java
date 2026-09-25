package jpa.counting;

import jakarta.persistence.*;
import jpa.support.JpaTestSupport;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Contrasts materialising every entity to obtain a size with a database count projection.
 */
class CountingTest {
    @Test
    void countsWithoutMaterialisingEntities() {
        try (var support = new JpaTestSupport(Event.class)) {
            support.transaction(em -> {
                for (int i = 0; i < 4; i++) em.persist(new Event("event-" + i));
            });
            var statistics = support.statistics();
            statistics.clear();
            try (var em = support.em()) {
                int materialised = em.createQuery("select e from Event e", Event.class).getResultList().size();
                assertTrue(statistics.getEntityLoadCount() > 0);
                statistics.clear();
                long counted = em.createQuery("select count(e) from Event e", Long.class).getSingleResult();
                assertEquals(materialised, counted);
                assertEquals(0, statistics.getEntityLoadCount());
            }
        }
    }
}

@Entity
class Event {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    String name;
    protected Event() {}
    Event(String name) { this.name = name; }
}
