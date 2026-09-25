package jpa.n_plus_one;

import jakarta.persistence.*;
import jpa.support.JpaTestSupport;
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * N+1 selects
 *
 * Loading parents then touching each lazy collection fires one query per
 * parent (N+1). join fetch loads the association in the same select;
 * distinct drops the cartesian duplicate parents.
 *
 * This test compares prepareStatementCount for both approaches.
 */
class NPlusOneTest {
    @Test
    void joinFetchUsesFewerStatements() {
        try (var support = new JpaTestSupport(Blog.class, Post.class)) {
            support.transaction(em -> {
                for (int i = 0; i < 3; i++) {
                    Blog blog = new Blog("blog-" + i);
                    blog.add(new Post("post-" + i));
                    em.persist(blog);
                }
            });
            var statistics = support.statistics();
            statistics.clear();
            try (var em = support.em()) {
                em.createQuery("select b from Blog b", Blog.class).getResultList()
                        .forEach(blog -> blog.posts.size());
            }
            long bad = statistics.getPrepareStatementCount(); // 1 select + 1 per blog
            statistics.clear();
            try (var em = support.em()) {
                // join fetch loads posts in one query; distinct drops cartesian duplicates
                em.createQuery("select distinct b from Blog b join fetch b.posts", Blog.class).getResultList()
                        .forEach(blog -> blog.posts.size());
            }
            long better = statistics.getPrepareStatementCount();
            assertTrue(bad > better, () -> "Expected N+1 statements " + bad + " > " + better);
        }
    }
}

@Entity
class Blog {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    String name;
    @OneToMany(mappedBy = "blog", cascade = CascadeType.ALL) List<Post> posts = new ArrayList<>();
    protected Blog() {}
    Blog(String name) { this.name = name; }
    void add(Post post) { posts.add(post); post.blog = this; }
}

@Entity
class Post {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    String title;
    @ManyToOne Blog blog;
    protected Post() {}
    Post(String title) { this.title = title; }
}
