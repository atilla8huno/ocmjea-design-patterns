package designpatterns.structural.proxy

class RealImage(private val fileName: String) : Image {
    init {
        loadFromDisk(fileName)
    }

    override fun display() {
        println("Displaying $fileName")
    }

    private fun loadFromDisk(fileName: String) {
        println("Loading $fileName")
    }
}
