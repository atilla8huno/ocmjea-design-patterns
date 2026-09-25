package designpatterns.behavioral.memento

class PersonStates {
    private val personStates = mutableListOf<PersonMemento>()

    fun add(state: PersonMemento) {
        personStates.add(state)
    }

    fun get(index: Int): PersonMemento = personStates[index]
}
