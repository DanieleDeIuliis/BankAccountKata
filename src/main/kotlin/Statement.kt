import java.io.PrintStream

data class Statement(val transaction: Transaction, val balanceBefore: Int) {
    fun printTo(printer: PrintStream) {
        printer.println("${transaction.date} || ${transaction.amount} || ${balanceAfter()}")
    }
    private fun balanceAfter() = balanceBefore + transaction.amount
}