package jpa.projection;

import jakarta.persistence.*;
import jpa.support.JpaTestSupport;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Contrasts loading a complete entity for one field with a direct scalar projection.
 */
class ProjectionTest {
    @Test
    void selectsOnlyRequestedScalar() {
        try (var support = new JpaTestSupport(UserProfile.class)) {
            support.transaction(em -> em.persist(new UserProfile("ada@example.test", "large biography")));
            try (var em = support.em()) {
                UserProfile entity = em.createQuery("select u from UserProfile u", UserProfile.class).getSingleResult();
                String scalar = em.createQuery("select u.email from UserProfile u", String.class).getSingleResult();
                assertEquals(entity.email, scalar);
                assertTrue(em.contains(entity));
            }
        }
    }
}

@Entity
class UserProfile {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    String email;
    String biography;
    protected UserProfile() {}
    UserProfile(String email, String biography) { this.email = email; this.biography = biography; }
}
