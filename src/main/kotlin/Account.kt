import java.io.PrintStream
import java.time.LocalDate

class Account(private val statements: Statements) {

    private var balance = 0

    fun deposit(amount: Int, date: LocalDate) {
        balance += amount
        statements.add(Transaction(date, amount), balance)
    }

    fun printStatements(printer: PrintStream) {
        printer.println("date || amount || balance")
        statements.all().asReversed().forEach { statement ->
            printer.println("${statement.transaction.date} || ${statement.transaction.amount} || ${statement.balanceAfter()}")
        }
    }

}