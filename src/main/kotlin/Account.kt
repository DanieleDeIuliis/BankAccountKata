import java.io.PrintStream
import java.time.LocalDate

class Account(private val statements: Statements) {

    private var balance = 0

    fun deposit(amount: Int, date: LocalDate) {
        statements.add(Transaction(date, amount), balance)
        balance += amount
    }

    fun printStatements(printer: PrintStream) {
        printer.println("date || amount || balance")
        statements.all().forEach { statement ->
            printer.println("${statement.transaction.date} || ${statement.transaction.amount} || ${statement.balanceAfter()}")
        }
    }

}