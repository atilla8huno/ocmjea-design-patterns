package jpa.one_to_many;

import jakarta.persistence.*;
import jpa.support.JpaTestSupport;
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * One-to-many
 *
 * One parent, many children. The many side usually owns the foreign key
 * (@ManyToOne); the one side is mappedBy that field. Keep both sides in
 * sync when you add a child.
 *
 * This test persists a parent with children and navigates both ways.
 */
class OneToManyTest {
    @Test
    void persistsParentAndChildren() {
        try (var support = new JpaTestSupport(Department.class, Employee.class)) {
            Department department = new Department("Engineering");
            department.add(new Employee("Ada"));
            department.add(new Employee("Linus"));
            support.transaction(em -> em.persist(department));
            try (var em = support.em()) {
                assertEquals(2, em.find(Department.class, department.id).employees.size());
            }
        }
    }
}

@Entity
class Department {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    String name;
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL) List<Employee> employees = new ArrayList<>();
    protected Department() {}
    Department(String name) { this.name = name; }
    void add(Employee employee) { employees.add(employee); employee.department = this; }
}

@Entity
class Employee {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    String name;
    @ManyToOne(fetch = FetchType.LAZY) Department department;
    protected Employee() {}
    Employee(String name) { this.name = name; }
}
