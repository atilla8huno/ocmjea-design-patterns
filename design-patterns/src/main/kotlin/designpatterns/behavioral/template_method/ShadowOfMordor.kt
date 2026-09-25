package designpatterns.behavioral.template_method

class ShadowOfMordor : Game() {
    override fun start() {
        println("[Shadow of Mordor] Loading sound and image files")
    }

    override fun intro() {
        println("[Shadow of Mordor] Mordor, the pink skin of evil!")
    }

    override fun finish() {
        println("[Shadow of Mordor] Clearing console memory")
    }
}
