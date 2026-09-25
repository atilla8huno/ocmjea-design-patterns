package jpa.hibernate_fetch;

import jakarta.persistence.*;
import jpa.support.JpaTestSupport;
import org.hibernate.Hibernate;
import org.hibernate.annotations.BatchSize;
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Demonstrates Hibernate fetch plans using join fetch, entity graphs and batched lazy collections.
 */
class HibernateFetchTest {
    @Test
    void appliesThreeFetchStrategies() {
        try (var support = new JpaTestSupport(Author.class, Article.class)) {
            support.transaction(em -> {
                Author author = new Author("Ada");
                author.add(new Article("JPA"));
                em.persist(author);
            });
            try (var em = support.em()) {
                Author joined = em.createQuery("select distinct a from Author a join fetch a.articles", Author.class).getSingleResult();
                assertTrue(Hibernate.isInitialized(joined.articles));

                EntityGraph<Author> graph = em.createEntityGraph(Author.class);
                graph.addAttributeNodes("articles");
                Author graphed = em.find(Author.class, joined.id, Map.of("jakarta.persistence.fetchgraph", graph));
                assertTrue(Hibernate.isInitialized(graphed.articles));

                em.clear();
                List<Author> authors = em.createQuery("select a from Author a", Author.class).getResultList();
                assertEquals(1, authors.getFirst().articles.size());
            }
        }
    }
}

@Entity
class Author {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    String name;
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    @BatchSize(size = 10)
    List<Article> articles = new ArrayList<>();
    protected Author() {}
    Author(String name) { this.name = name; }
    void add(Article article) { articles.add(article); article.author = this; }
}

@Entity
class Article {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    String title;
    @ManyToOne Author author;
    protected Article() {}
    Article(String title) { this.title = title; }
}
