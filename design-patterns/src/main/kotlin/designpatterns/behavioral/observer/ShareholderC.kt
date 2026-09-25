package designpatterns.behavioral.observer

class ShareholderC(petrobras: Petrobras) : Shareholder() {
    init {
        this.petrobras = petrobras
        this.petrobras.addShareholder(this)
    }

    override fun analyseValues() {
        if (petrobras.sharePrice < 8.0) {
            println("[Shareholder C] Selling everything because it will get worse...")
        } else {
            println("[Shareholder C] Holding shares for now...")
        }
    }
}
