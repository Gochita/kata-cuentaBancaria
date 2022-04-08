import Utils.DateConverter;

public class Main {

    public static void main(String[] args) {

        Account account = new Account(new Statement());

        account.withdrawal(Amount.amountOf(500), DateConverter.date("14/01/2021"));
        account.deposit(Amount.amountOf(2000), DateConverter.date("13/01/2021"));
        account.deposit(Amount.amountOf(1000), DateConverter.date("10/01/2021"));

        account.printStatement(System.out);
    }
}
