interface Statements {
    fun add(transaction: Transaction, currentBalance: Int)
    fun all(): List<Statement>

}

