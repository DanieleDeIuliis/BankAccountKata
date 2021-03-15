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

    @Test
    fun `add two statements in reversed order`() {
        val statements = InMemoryStatements()

        statements.add(Transaction(parse("2021-01-01"), 100), 100)
        statements.add(Transaction(parse("2021-06-03"), 300), 400)

        assertThat(statements.all()).containsExactly(
            Statement(Transaction(parse("2021-06-03"), 300), 400),
            Statement(Transaction(parse("2021-01-01"), 100), 100)
            )
    }
}