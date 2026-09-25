package designpatterns.structural.composite

class Employee(
    private val name: String,
    private val department: String,
    private val salary: Double
) {
    private val subordinates = mutableListOf<Employee>()

    fun add(employee: Employee) {
        subordinates.add(employee)
    }

    fun remove(employee: Employee) {
        subordinates.remove(employee)
    }

    fun getSubordinates(): List<Employee> = subordinates

    override fun toString(): String {
        return "Employee :[ Name : $name, dept : $department, salary :$salary ]"
    }
}
