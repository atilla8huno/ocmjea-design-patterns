package designpatterns.behavioral.iterator

class NameDAO : Container {
    val names = arrayOf("Atilla", "Ben-Hur", "Jullierme", "Lucio")

    override fun getIterator(): CollectionIterator = NameIterator()

    private inner class NameIterator : CollectionIterator {
        private var index = 0

        override fun hasNext(): Boolean = index < names.size

        override fun next(): Any? {
            return if (hasNext()) names[index++] else null
        }
    }
}
