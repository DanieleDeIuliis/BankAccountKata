import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import io.mockk.verifyOrder
import org.junit.jupiter.api.Test
import java.io.PrintStream
import java.time.LocalDate

class AccountTest {

    private val statements: Statements = mockk(relaxed = true)
    private val printStream: PrintStream = mockk(relaxed = true)

    @Test
    fun `deposit an amount`() {
        val date = LocalDate.parse("2021-01-01")
        val account = Account(statements = statements)
        account.deposit(amount = 1000, date)
        verify { statements.add(Transaction(date = date, amount = 1000), balanceBefore = 0) }
    }

    @Test
    fun `deposit an amount twice`() {
        val firstDate = LocalDate.parse("2021-02-01")
        val secondDate = LocalDate.parse("2021-03-02")
        val account = Account(statements = statements)
        account.deposit(amount = 900, firstDate)
        account.deposit(amount = 500, secondDate)
        verifyOrder {
            statements.add(Transaction(date = firstDate, amount = 900), balanceBefore = 0)
            statements.add(Transaction(date = secondDate, amount = 500), balanceBefore = 900)
        }
    }

    @Test
    fun `prints all statements info from most recent to oldest`() {
        val firstDate = LocalDate.parse("2021-02-01")
        val secondDate = LocalDate.parse("2021-03-02")
        val account = Account(statements = statements)
        account.deposit(amount = 900, firstDate)
        account.deposit(amount = 500, secondDate)


        account.printStatements(printStream)

        verify { statements.printTo(printStream) }
    }
}