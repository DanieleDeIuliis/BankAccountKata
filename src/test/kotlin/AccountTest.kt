import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test
import java.time.LocalDate
import java.time.LocalDateTime

class AccountTest {

    private val statements: Statements = mockk(relaxed = true)

    @Test
    fun `deposit an amount`() {
        val date = LocalDate.parse("2021-01-01")
        val account = Account(statements = statements)
        account.deposit(amount = 1000, date)
        verify { statements.add(Transaction(date = date, amount = 1000), startingBalance = 0) }
    }
}

