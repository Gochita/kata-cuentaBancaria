import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.*;
import static org.apache.commons.lang3.StringUtils.rightPad;
import static Utils.DateConverter.format;

public class Transaction {

    private static final String espacio= "          ";


    private SimpleDateFormat formato = new SimpleDateFormat(format);

    private Amount valor;
    private Date fecha;


    public Transaction(Amount valor, Date fecha) {
        this.valor = valor;
        this.fecha = fecha;
    }
    public Amount balanceAfterTransaction(Amount currentBalance) {
        return currentBalance.addTheValue(valor);
    }

    private void addCurrentBalanceTo(StringBuilder builder, Amount currentBalance) {
        builder.append("| ")
                .append(currentBalance.moneyRepresentation());
    }
    private void addDateTo(StringBuilder builder) {
        builder.append(formato.format(fecha));
        builder.append(" |");
    }

    private void addValueTo(StringBuilder builder) {
        if (valor.isGreaterThan(Amount.amountOf(0))) {
            addCreditTo(builder);
            return;
        }
        addDebitTo(builder);
    }

    private void addDebitTo(StringBuilder builder) {
        builder.append(espacio)
                .append("|")
                .append(valueToString());
    }

    private void addCreditTo(StringBuilder builder) {
        builder.append(valueToString())
                .append("|")
                .append(espacio);
    }
    public void printTo(PrintStream printer, Amount currentBalance) {
        StringBuilder builder = new StringBuilder();
        addDateTo(builder);
        addValueTo(builder);
        addCurrentBalanceTo(builder, currentBalance);
        printer.println(builder);
    }

    private String valueToString() {
        String stringValue = " " + valor.absoluteValue().moneyRepresentation();
        return rightPad(stringValue, 10);
    }



}
