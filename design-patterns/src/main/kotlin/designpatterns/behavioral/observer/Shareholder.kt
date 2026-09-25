package designpatterns.behavioral.observer

abstract class Shareholder {
    protected lateinit var petrobras: Petrobras
    abstract fun analyseValues()
}
