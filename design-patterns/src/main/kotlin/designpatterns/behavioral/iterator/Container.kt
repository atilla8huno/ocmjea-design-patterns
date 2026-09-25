package designpatterns.behavioral.iterator

interface Container {
    fun getIterator(): CollectionIterator
}
