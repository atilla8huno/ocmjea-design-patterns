package jpa.support;

import io.zonky.test.db.postgres.embedded.EmbeddedPostgres;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.stat.Statistics;

import java.io.IOException;
import java.util.function.Consumer;

public final class JpaTestSupport implements AutoCloseable {
    private static final EmbeddedPostgres POSTGRES = startPostgres();
    private final StandardServiceRegistry registry;
    private final SessionFactory sessionFactory;

    public JpaTestSupport(Class<?>... entities) {
        registry = new StandardServiceRegistryBuilder()
                .applySetting(AvailableSettings.JAKARTA_NON_JTA_DATASOURCE, POSTGRES.getPostgresDatabase())
                .applySetting(AvailableSettings.HBM2DDL_AUTO, "create-drop")
                .applySetting(AvailableSettings.SHOW_SQL, false)
                .applySetting(AvailableSettings.FORMAT_SQL, true)
                .applySetting(AvailableSettings.GENERATE_STATISTICS, true)
                .applySetting(AvailableSettings.STATEMENT_BATCH_SIZE, 20)
                .build();
        MetadataSources sources = new MetadataSources(registry);
        for (Class<?> entity : entities) {
            sources.addAnnotatedClass(entity);
        }
        sessionFactory = sources.buildMetadata().buildSessionFactory();
    }

    private static EmbeddedPostgres startPostgres() {
        try {
            return EmbeddedPostgres.builder().start();
        } catch (IOException exception) {
            throw new ExceptionInInitializerError(exception);
        }
    }

    public EntityManagerFactory emf() {
        return sessionFactory;
    }

    public EntityManager em() {
        return sessionFactory.createEntityManager();
    }

    public void transaction(Consumer<EntityManager> work) {
        EntityManager em = em();
        try {
            em.getTransaction().begin();
            work.accept(em);
            em.getTransaction().commit();
        } catch (RuntimeException exception) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw exception;
        } finally {
            em.close();
        }
    }

    public Statistics statistics() {
        return sessionFactory.getStatistics();
    }

    @Override
    public void close() {
        sessionFactory.close();
        StandardServiceRegistryBuilder.destroy(registry);
    }
}
