import java.io.PrintStream;
import java.util.*;

public class Statement {

    private final List<StatementLine> statementLines = new LinkedList<>();
    public static final String body = "[   date   |  credit  |  debit   | balance ]";

    public void addLineContaining(Transaction transaction, Amount currentBalance) {
        statementLines.add(0, new StatementLine(transaction, currentBalance));
    }

    public void printTo(PrintStream printer) {
        printer.println(body);
        printStatementLines(printer);
    }


    private void printStatementLines(PrintStream printer) {
        for (StatementLine statementLine : statementLines) {
            statementLine.printTo(printer);
        }
    }
}
