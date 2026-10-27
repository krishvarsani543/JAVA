import java.util.regex.Pattern;

class Validator {

    private static final Pattern mobile = Pattern.compile("^[6-9][0-9]{9}$");
    private static final Pattern email = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    private static final Pattern pan = Pattern.compile("^[A-Z]{5}[0-9]{4}[A-Z]$");
    private static final Pattern ifsc = Pattern.compile("^[A-Z]{4}0[A-Z0-9]{6}$");

    public static boolean isValidMobile(String s) {
        return mobile.matcher(s).matches();
    }

    public static boolean isValidEmail(String s) {
        return email.matcher(s).matches();
    }

    public static boolean isValidPan(String s) {
        return pan.matcher(s).matches();
    }

    public static boolean isValidIfsc(String s) {
        return ifsc.matcher(s).matches();
    }
}

enum TransactionType {
    DEPOSIT, WITHDRAW, TRANSFER
}

record Command(TransactionType type, String accountNumber, long amount) {
}

class CommandParser {

     static Command parse(String line) {
        String[] parts = line.split(" ");

        TransactionType type = TransactionType.valueOf(parts[0]);
        String accountNumber = parts[1];
        long amount = Long.parseLong(parts[2]);

        return new Command(type, accountNumber, amount);
    }
}
class Account {
    private String accountNumber;
    private String name;
    private long balance;

    Account(String accountNumber, String name, long balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }

    public long getBalance() {
        return balance;
    }
}

class StatementFormatter {

    static String buildStatement(Account account) {
        StringBuilder sb = new StringBuilder();

        sb.append("Account Number: ").append(account.getAccountNumber()).append("\n");
        sb.append("Name: ").append(account.getName()).append("\n");
        sb.append("Balance: ").append(account.getBalance()).append("\n");

        return sb.toString();
    }
}

public class prac4 {

    public static void main(String[] args) {

        System.out.println("Mobile:");
        System.out.println(Validator.isValidMobile("9876543210"));
        System.out.println(Validator.isValidMobile("12345"));

        System.out.println("\nEmail:");
        System.out.println(Validator.isValidEmail("abc@gmail.com"));
        System.out.println(Validator.isValidEmail("abc@gmail"));

        System.out.println("\nPAN:");
        System.out.println(Validator.isValidPan("ABCDE1234F"));
        System.out.println(Validator.isValidPan("ABC123"));

        System.out.println("\nIFSC:");
        System.out.println(Validator.isValidIfsc("SBIN0001234"));
        System.out.println(Validator.isValidIfsc("SB123"));

        Command c = CommandParser.parse("DEPOSIT AC0001 500");

        System.out.println("\nCommand:");
        System.out.println("Type: " + c.type());
        System.out.println("Account Number: " + c.accountNumber());
        System.out.println("Amount: " + c.amount());
    }
}