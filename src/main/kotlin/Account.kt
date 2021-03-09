import java.io.PrintStream
import java.time.LocalDate

class Account(private val statements: Statements) {

    fun deposit(amount: Int, date: LocalDate) {
        statements.add(Transaction(date, amount), currentBalance())
    }

    private fun currentBalance(): Int {
        return 0
    }

    fun printStatements(printer: PrintStream) {
        TODO("Not yet implemented")
    }

}