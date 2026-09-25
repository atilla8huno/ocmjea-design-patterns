package designpatterns.structural.bridge

abstract class Shape(protected val api: DrawingAPI) {
    abstract fun draw()
}
