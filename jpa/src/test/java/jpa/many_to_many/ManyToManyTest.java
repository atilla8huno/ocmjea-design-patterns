package jpa.many_to_many;

import jakarta.persistence.*;
import jpa.support.JpaTestSupport;
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Demonstrates a many-to-many association represented by a PostgreSQL join table.
 */
class ManyToManyTest {
    @Test
    void persistsSharedCourses() {
        try (var support = new JpaTestSupport(Student.class, Course.class)) {
            Student student = new Student("Ada");
            student.courses.add(new Course("Databases"));
            support.transaction(em -> em.persist(student));
            try (var em = support.em()) {
                assertEquals("Databases", em.find(Student.class, student.id).courses.iterator().next().title);
            }
        }
    }
}

@Entity
class Student {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    String name;
    @ManyToMany(cascade = CascadeType.PERSIST) Set<Course> courses = new HashSet<>();
    protected Student() {}
    Student(String name) { this.name = name; }
}

@Entity
class Course {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    String title;
    protected Course() {}
    Course(String title) { this.title = title; }
}
