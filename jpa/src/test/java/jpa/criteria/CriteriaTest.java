package jpa.criteria;

import jakarta.persistence.*;
import jakarta.persistence.criteria.*;
import jpa.support.JpaTestSupport;
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Exercises portable Criteria API selection, predicates, joins, ordering, aggregation and bulk mutation.
 */
class CriteriaTest {
    @Test
    void performsCriteriaOperations() {
        try (var support = new JpaTestSupport(Team.class, Member.class)) {
            support.transaction(em -> {
                Team team = new Team("Platform");
                team.add(new Member("Ada", 5));
                team.add(new Member("Bob", 2));
                em.persist(team);
            });
            try (var em = support.em()) {
                CriteriaBuilder cb = em.getCriteriaBuilder();
                CriteriaQuery<Member> select = cb.createQuery(Member.class);
                Root<Member> member = select.from(Member.class);
                Join<Member, Team> team = member.join("team");
                select.where(cb.and(cb.equal(team.get("name"), "Platform"), cb.greaterThan(member.get("level"), 2)))
                        .orderBy(cb.desc(member.get("level")));
                assertEquals("Ada", em.createQuery(select).getSingleResult().name);

                CriteriaQuery<Long> count = cb.createQuery(Long.class);
                count.select(cb.count(count.from(Member.class)));
                assertEquals(2L, em.createQuery(count).getSingleResult());
            }
            support.transaction(em -> {
                CriteriaBuilder cb = em.getCriteriaBuilder();
                CriteriaUpdate<Member> update = cb.createCriteriaUpdate(Member.class);
                Root<Member> root = update.from(Member.class);
                update.set("level", 3).where(cb.equal(root.get("name"), "Bob"));
                assertEquals(1, em.createQuery(update).executeUpdate());

                CriteriaDelete<Member> delete = cb.createCriteriaDelete(Member.class);
                Root<Member> deleting = delete.from(Member.class);
                delete.where(cb.lessThan(deleting.get("level"), 4));
                assertEquals(1, em.createQuery(delete).executeUpdate());
                em.persist(new Member("Cara", 4));
            });
        }
    }
}

@Entity
class Team {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    String name;
    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL) List<Member> members = new ArrayList<>();
    protected Team() {}
    Team(String name) { this.name = name; }
    void add(Member member) { members.add(member); member.team = this; }
}

@Entity
class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    String name;
    int level;
    @ManyToOne Team team;
    protected Member() {}
    Member(String name, int level) { this.name = name; this.level = level; }
}
