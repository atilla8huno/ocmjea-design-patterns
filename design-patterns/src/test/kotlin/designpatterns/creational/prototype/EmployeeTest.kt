package designpatterns.creational.prototype

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Test

/**
 * Prototype (Creational)
 *
 * Copy an existing object instead of building it from scratch. The prototype
 * implements clone so the expensive load runs once; each copy gets its own
 * data and can be mutated independently.
 *
 * Applicable when creating a new instance is costly or shares mutable state.
 * This test clones EmployeeDAO twice, edits both copies, and checks the original.
 */
class EmployeeTest {
    @Test
    fun `clones employee lists without sharing mutations`() {
        val emp0 = EmployeeDAO()
        emp0.loadData()

        val emp1 = emp0.clone()
        val emp2 = emp0.clone()

        val list1 = emp1.getEmployees()
        list1.add("John")

        val list2 = emp2.getEmployees()
        list2.remove("Peter")

        assertEquals(listOf("Atilla", "John", "Joseph", "Mary", "Peter"), emp0.getEmployees())
        assertEquals(listOf("Atilla", "John", "Joseph", "Mary", "Peter", "John"), list1)
        assertEquals(listOf("Atilla", "John", "Joseph", "Mary"), list2)
        assertFalse(emp0.getEmployees() === list1)
    }
}
