package designpatterns.structural.flyweight

class Circle(private val colour: String) : Shape {
    var x: Int = 0
    var y: Int = 0
    var radius: Int = 0

    override fun draw() {
        println("Circle: draw() [Colour : $colour, x : $x, y :$y, radius :$radius\n")
    }
}
