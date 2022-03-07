import java.io.PrintStream

interface Statements {
    fun add(transaction: Transaction, balanceBefore: Int)
    fun printTo(printer: PrintStream)

}

