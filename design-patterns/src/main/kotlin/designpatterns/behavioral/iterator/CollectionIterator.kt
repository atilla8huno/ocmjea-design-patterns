package designpatterns.behavioral.iterator

interface CollectionIterator {
    fun hasNext(): Boolean
    fun next(): Any?
}
