package jpa.in_loop;

import jakarta.persistence.*;
import jpa.support.JpaTestSupport;
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Uses Hibernate statistics to contrast repeated lookup and insert loops with bulk lookup and JDBC batching.
 */
class InLoopTest {
    @Test
    void replacesRepeatedLookupAndFlushWithBulkWork() {
        try (var support = new JpaTestSupport(InventoryItem.class)) {
            support.transaction(em -> {
                for (int i = 0; i < 5; i++) em.persist(new InventoryItem("sku-" + i));
            });
            var statistics = support.statistics();
            statistics.clear();
            try (var em = support.em()) {
                for (long id = 1; id <= 5; id++) em.find(InventoryItem.class, id);
            }
            long repeatedFinds = statistics.getPrepareStatementCount();
            statistics.clear();
            try (var em = support.em()) {
                em.createQuery("select i from InventoryItem i where i.id in :ids", InventoryItem.class)
                        .setParameter("ids", List.of(1L, 2L, 3L, 4L, 5L)).getResultList();
            }
            long bulkFind = statistics.getPrepareStatementCount();
            assertTrue(repeatedFinds > bulkFind);

            support.transaction(em -> {
                for (int i = 5; i < 25; i++) {
                    em.persist(new InventoryItem("sku-" + i));
                    if (i % 10 == 0) { em.flush(); em.clear(); }
                }
            });
        }
    }
}

@Entity
class InventoryItem {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    String sku;
    protected InventoryItem() {}
    InventoryItem(String sku) { this.sku = sku; }
}
