package designpatterns.behavioral.template_method

abstract class Game {
    abstract fun start()
    abstract fun intro()
    abstract fun finish()

    fun play() {
        try {
            start()
            intro()
        } finally {
            finish()
        }
    }
}
