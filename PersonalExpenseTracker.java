import java.util.*;

class Transaction {
    String type; // Income or Expense
    String category;
    double amount;
    String date;

    Transaction(String type, String category, double amount, String date) {
        this.type = type;
        this.category = category;
        this.amount = amount;
        this.date = date;
    }

    public String toString() {
        return type + " | " + category + " | $" + amount + " | " + date;
    }
}

public class PersonalExpenseTracker {
    static List<Transaction> transactions = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Personal Expense Tracker ---");
            System.out.println("1. Add Income");
            System.out.println("2. Add Expense");
            System.out.println("3. View Summary");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addTransaction("Income", sc);
                case 2 -> addTransaction("Expense", sc);
                case 3 -> viewSummary();
                case 4 -> System.out.println("Exiting... Goodbye!");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 4);
    }

    static void addTransaction(String type, Scanner sc) {
        System.out.print("Enter category: ");
        String category = sc.nextLine();
        System.out.print("Enter amount: ");
        double amount = sc.nextDouble();
        sc.nextLine();
        System.out.print("Enter date (YYYY-MM-DD): ");
        String date = sc.nextLine();

        transactions.add(new Transaction(type, category, amount, date));
        System.out.println(type + " added successfully!");
    }

    static void viewSummary() {
        double totalIncome = 0, totalExpense = 0;
        System.out.println("\n--- Transaction History ---");
        for (Transaction t : transactions) {
            System.out.println(t);
            if (t.type.equals("Income")) totalIncome += t.amount;
            else totalExpense += t.amount;
        }
        System.out.println("\nTotal Income: $" + totalIncome);
        System.out.println("Total Expense: $" + totalExpense);
        System.out.println("Balance: $" + (totalIncome - totalExpense));
    }
}
