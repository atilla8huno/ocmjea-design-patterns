package designpatterns.structural.composite

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * Composite (Structural)
 *
 * Treat a leaf and a group through the same type. Employee can stand alone or
 * hold subordinates, so a manager and a staff member share one interface.
 * Walking the tree does not care which is which.
 *
 * Applicable for part-whole hierarchies (org charts, menus, file trees).
 * This test builds a small org chart and walks it.
 */
class EmployeeTest {
    @Test
    fun `builds a company hierarchy of employees`() {
        val ceo = Employee("Jonathas", "CEO", 35000.0)

        val hrManager = Employee("Raquel", "HR Manager", 8000.0)
        val supportManager = Employee("Gustavo", "Operations Manager", 8000.0)
        val devManager = Employee("Thiago", "Development Manager", 8000.0)

        val hrOper1 = Employee("Simone", "HR", 1000.0)
        val supportOper1 = Employee("Isaias", "Support", 4000.0)
        val supportOper2 = Employee("Maykon", "Support", 1000.0)
        val devOper1 = Employee("Atilla", "Development", 5000.0)
        val devOper2 = Employee("Warley", "Development", 6000.0)
        val devOper3 = Employee("Leo", "Development", 4000.0)

        ceo.add(hrManager)
        ceo.add(supportManager)
        ceo.add(devManager)

        hrManager.add(hrOper1)
        supportManager.add(supportOper1)
        supportManager.add(supportOper2)
        devManager.add(devOper1)
        devManager.add(devOper2)
        devManager.add(devOper3)

        assertEquals(3, ceo.getSubordinates().size)
        assertEquals(1, hrManager.getSubordinates().size)
        assertEquals(2, supportManager.getSubordinates().size)
        assertEquals(3, devManager.getSubordinates().size)
        assertEquals("Employee :[ Name : Jonathas, dept : CEO, salary :35000.0 ]", ceo.toString())
    }
}
