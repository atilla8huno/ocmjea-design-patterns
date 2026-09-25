package designpatterns.structural.bridge

class Circle(
    private val x: Int,
    private val y: Int,
    private val radius: Int,
    api: DrawingAPI
) : Shape(api) {
    override fun draw() {
        api.drawCircle(radius, x, y)
    }

    fun doSomethingElseWithoutAffectingAnyone() {}
}
