package designpatterns.structural.bridge

class GreenCircle : DrawingAPI {
    override fun drawCircle(radius: Int, x: Int, y: Int) {
        println("Drawing green circle [radius: $radius]")
    }
}
