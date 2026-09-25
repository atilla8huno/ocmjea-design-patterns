package designpatterns.behavioral.observer

class ShareholderA(petrobras: Petrobras) : Shareholder() {
    init {
        this.petrobras = petrobras
        this.petrobras.addShareholder(this)
    }

    override fun analyseValues() {
        when {
            petrobras.sharePrice < 8.0 -> println("[Shareholder A] Buying more shares while they are cheap...")
            petrobras.sharePrice < 12.0 -> println("[Shareholder A] Holding shares...")
            else -> println("[Shareholder A] Selling shares...")
        }
    }
}
