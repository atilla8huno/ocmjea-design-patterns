package designpatterns.structural.flyweight

object ShapeFactory {
    private val circleMap = mutableMapOf<String, Shape>()

    fun getCircle(colour: String): Shape {
        var circle = circleMap[colour] as Circle?

        if (circle == null) {
            circle = Circle(colour)
            circleMap[colour] = circle
            println("Creating a new circle of colour: $colour")
        }

        return circle
    }
}
