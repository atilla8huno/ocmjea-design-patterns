package designpatterns.behavioral.memento

class Person {
    var name: String? = null

    fun saveStateToMemento(): PersonMemento = PersonMemento(name ?: "")

    fun restoreNameFromMemento(memento: PersonMemento) {
        name = memento.name
    }
}
