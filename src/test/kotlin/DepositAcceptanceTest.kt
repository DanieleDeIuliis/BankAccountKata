import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

class DepositAcceptanceTest {

    private val statements: Statements = mockk(relaxed = true)

    @Test
    fun `deposit an amount`() {
//        `given an account just created with a balance of`(0)
//        `when deposit an amount of`(1000)
//        `then the balance is`(1000)

        val date = LocalDateTime.parse("2021-01-01T00:00:00")
        val account = Account(statements = statements)
        account.deposit(amount = 1000, date)
        verify { statements.add(Transaction(date = date, amount = 1000), balance = 1000) }
    }
}

class Account(private val statements: Statements) {

    fun deposit(amount: Int, date: LocalDateTime) {
        statements.add(Transaction(date, amount), currentBalance(amount))
    }

    private fun currentBalance(amount: Int): Int {
        return 0 + amount
    }

}

data class Transaction(val date: LocalDateTime, val amount: Int)

interface Statements {
    fun add(transaction: Transaction, balance: Int)

}
