# JPA

JPA and Hibernate against Zonky embedded PostgreSQL. Run `mvn test`.

## Mappings

Entities, embeddables, enums, one-to-many, many-to-many, inheritance, lifecycle callbacks, cascades and transactions.

## Queries

JPQL, projections, JPA Criteria (select, predicates, joins, count, update, delete). Hibernate Criteria also shows insert.

## Pitfalls

- **n_plus_one** — lazy collections vs `join fetch`.
- **counting** — `findAll().size()` vs `count`.
- **projection** — load one field instead of the whole entity.
- **in_loop** — a query inside a loop.
- **lazy_initialization** — touching a lazy collection after the session is closed.
