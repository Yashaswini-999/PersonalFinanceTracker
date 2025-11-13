import java.util.ArrayList;
import java.util.Scanner;

public class FinanceTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Transaction> transactions = new ArrayList<>();
        System.out.println("💰 Welcome to Personal Finance Tracker 💰");

        while (true) {
            System.out.println("\n1. Add Income");
            System.out.println("2. Add Expense");
            System.out.println("3. View Dashboard");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter income description: ");
                    String incomeDesc = sc.nextLine();
                    System.out.print("Enter income amount: ");
                    double incomeAmount = sc.nextDouble();
                    transactions.add(new Transaction("Income", incomeDesc, incomeAmount));
                    System.out.println("Income added!");
                    break;
                case 2:
                    System.out.print("Enter expense description: ");
                    String expenseDesc = sc.nextLine();
                    System.out.print("Enter expense amount: ");
                    double expenseAmount = sc.nextDouble();
                    transactions.add(new Transaction("Expense", expenseDesc, expenseAmount));
                    System.out.println("Expense added!");
                    break;
                case 3:
                    showDashboard(transactions);
                    break;
                case 4:
                    System.out.println("Exiting... Thank you!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    public static void showDashboard(ArrayList<Transaction> transactions) {
        double totalIncome = 0, totalExpense = 0;
        System.out.println("\n📊 Dashboard 📊");
        System.out.printf("%-10s %-20s %-10s\n", "Type", "Description", "Amount");

        for (Transaction t : transactions) {
            System.out.printf("%-10s %-20s ₹%-10.2f\n", t.getType(), t.getDescription(), t.getAmount());
            if (t.getType().equals("Income")) totalIncome += t.getAmount();
            else totalExpense += t.getAmount();
        }

        double savings = totalIncome - totalExpense;
        System.out.println("=======================");
        System.out.println("Total Income : ₹" + totalIncome);
        System.out.println("Total Expense: ₹" + totalExpense);
        System.out.println("Savings      : ₹" + savings);
    }
}
