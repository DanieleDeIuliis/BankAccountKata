import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.time.LocalDate.parse

class InMemoryStatementsTest {
    @Test
    fun `add a new statement`() {
        val statements = InMemoryStatements()

        statements.add(Transaction(parse("2021-01-01"), 100), 100)

        assertThat(statements.all().size).isEqualTo(1)
    }
}