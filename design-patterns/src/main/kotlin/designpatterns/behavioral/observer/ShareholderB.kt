package designpatterns.behavioral.observer

class ShareholderB(petrobras: Petrobras) : Shareholder() {
    init {
        this.petrobras = petrobras
        this.petrobras.addShareholder(this)
    }

    override fun analyseValues() {
        when {
            petrobras.sharePrice < 8.0 -> println("[Shareholder B] Buying more shares while they are cheap...")
            petrobras.sharePrice >= 8.0 && petrobras.sharePrice < 18.0 -> println("[Shareholder B] Holding shares...")
            else -> println("[Shareholder B] Selling shares because they have risen...")
        }
    }
}
