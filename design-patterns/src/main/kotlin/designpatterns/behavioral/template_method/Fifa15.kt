package designpatterns.behavioral.template_method

class Fifa15 : Game() {
    override fun start() {
        println("[Fifa 15] Loading sound and image files")
    }

    override fun intro() {
        println("[Fifa 15] EA Sports: It's in the game!")
    }

    override fun finish() {
        println("[Fifa 15] Clearing console memory")
    }
}
