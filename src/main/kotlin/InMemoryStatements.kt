class InMemoryStatements : Statements {

    private val statements = mutableListOf<Statement>()

    override fun add(transaction: Transaction, balanceBefore: Int) {
        statements.add(0, Statement(transaction, balanceBefore))
    }

    override fun all(): List<Statement> {
        return statements
    }
}
