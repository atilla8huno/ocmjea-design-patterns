package designpatterns.structural.bridge

class BlueCircle : DrawingAPI {
    override fun drawCircle(radius: Int, x: Int, y: Int) {
        println("Drawing blue circle [radius: $radius]")
    }

    fun doSomethingWithoutAffectingAnyone() {}
}
