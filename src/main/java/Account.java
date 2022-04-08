import java.io.PrintStream;
import java.util.Date;

public class Account {

    private Amount balance = Amount.amountOf(0);
    private final Statement statement;
    public Account(Statement statement) {
        this.statement = statement;
    }
    public void deposit(Amount value, Date date) {
        registerTransaction(value, date);
    }
    public void withdrawal(Amount value, Date date) {
        registerTransaction(value.negative(), date);
    }
    public void printStatement(PrintStream imprimir) {
        statement.printTo(imprimir);
    }
    private void registerTransaction(Amount value, Date date) {
        Transaction transaction = new Transaction(value, date);
        Amount balanceAfterTransaction = transaction.balanceAfterTransaction(balance);
        balance = balanceAfterTransaction;
        statement.addLineContaining(transaction, balanceAfterTransaction);
    }
}
