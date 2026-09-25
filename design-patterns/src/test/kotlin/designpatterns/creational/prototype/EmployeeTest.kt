package designpatterns.creational.prototype

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Test

/** Covers Prototype by cloning EmployeeDAO and mutating independent copies. */
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
