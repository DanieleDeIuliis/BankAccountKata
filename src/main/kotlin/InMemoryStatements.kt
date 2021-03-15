class InMemoryStatements : Statements {

    private val statements = mutableListOf<Statement>()

    override fun add(transaction: Transaction, currentBalance: Int) {
        statements.add(0, Statement(transaction, currentBalance))
    }

    override fun all(): List<Statement> {
        return statements
    }
}
