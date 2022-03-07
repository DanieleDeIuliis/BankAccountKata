import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import java.time.LocalDate.parse

class InMemoryStatementsTest {

    private val outputStream = ByteArrayOutputStream()

    @Test
    fun `add a new statement`() {
        val statements = InMemoryStatements()

        statements.add(Transaction(parse("2021-01-01"), 100), 100)

        statements.printTo(PrintStream(outputStream))

        assertThat(String(outputStream.toByteArray())).isEqualTo("2021-01-01 || 100 || 200\n")
    }

    @Test
    fun `add two statements in reversed order`() {
        val statements = InMemoryStatements()

        statements.add(Transaction(parse("2021-01-01"), 100), 100)
        statements.add(Transaction(parse("2021-06-03"), 300), 200)

        statements.printTo(PrintStream(outputStream))

        assertThat(String(outputStream.toByteArray())).isEqualTo("2021-06-03 || 300 || 500\n2021-01-01 || 100 || 200\n")
    }
}