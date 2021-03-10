import java.io.PrintStream
import java.time.LocalDate

class Account(private val statements: Statements) {

    private var balance = 0

    fun deposit(amount: Int, date: LocalDate) {
        balance += amount
        statements.add(Transaction(date, amount), balance)
    }

    fun printStatements(printer: PrintStream) {
        TODO("Not yet implemented")
    }

}