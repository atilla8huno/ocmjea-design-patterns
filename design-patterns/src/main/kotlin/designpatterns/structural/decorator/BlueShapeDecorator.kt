package designpatterns.structural.decorator

class BlueShapeDecorator(decoratedShape: Shape) : ShapeDecorator(decoratedShape) {
    override fun draw() {
        super.draw()
        setBlueColour()
    }

    private fun setBlueColour() {
        println("Painting the shape blue...")
    }
}
