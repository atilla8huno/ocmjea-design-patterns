package designpatterns.creational.prototype

class EmployeeDAO(employees: List<String> = emptyList()) : Cloneable {
    private val employees: MutableList<String> = employees.toMutableList()

    fun loadData() {
        employees.addAll(listOf("Atilla", "John", "Joseph", "Mary", "Peter"))
    }

    fun getEmployees(): MutableList<String> = employees

    public override fun clone(): EmployeeDAO {
        return EmployeeDAO(employees.toList())
    }
}
