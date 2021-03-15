data class Statement(val transaction: Transaction, val currentBalance: Int) {
    fun balanceAfter() = currentBalance + transaction.amount
}