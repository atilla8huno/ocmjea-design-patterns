package designpatterns.structural.facade

class ShapeFacade {
    private val circle: Shape = Circle()
    private val square: Shape = Square()
    private val rectangle: Shape = Rectangle()

    fun drawCircle() = circle.draw()
    fun drawSquare() = square.draw()
    fun drawRectangle() = rectangle.draw()
}
