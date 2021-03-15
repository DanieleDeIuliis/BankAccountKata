interface Statements {
    fun add(transaction: Transaction, balanceBefore: Int)
    fun all(): List<Statement>

}

