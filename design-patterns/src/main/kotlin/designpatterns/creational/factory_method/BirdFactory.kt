package designpatterns.creational.factory_method

object BirdFactory {
    fun getBird(species: String): Bird? = when (species) {
        "Hawk" -> Hawk()
        "Parrot" -> Parrot()
        "Eagle" -> Eagle()
        else -> null
    }
}
