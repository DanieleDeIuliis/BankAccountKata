import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import java.time.LocalDate

@Disabled
class DepositAcceptanceTest {
    private val outputStream = ByteArrayOutputStream()
    private lateinit var account: Account

    @Test
    fun `deposit an amount`() {
        `given an account just created`()
        `and a deposit amount`(of = 1000, on = "2021-01-01")
        `when the account prints its statements`()
        `then the printed statements are equal to`("""
            |date || amount || balance
            |2021-01-01 || 1000 || 1000
        """.trimMargin())
    }

    private fun `given an account just created`() {
        account = Account(InMemoryStatements())
    }

    private fun `and a deposit amount`(of: Int, on: String) {
        account.deposit(of, LocalDate.parse(on))
    }

    private fun `when the account prints its statements`() {
        account.printStatements(PrintStream(outputStream))
    }

    private fun `then the printed statements are equal to`(text: String) {
        assertThat(String(outputStream.toByteArray())).isEqualTo(text)
    }
}

