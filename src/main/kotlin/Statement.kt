data class Statement(val transaction: Transaction, val balanceBefore: Int) {
    fun balanceAfter() = balanceBefore + transaction.amount
}