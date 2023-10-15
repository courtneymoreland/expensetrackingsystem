package expensetrackingsystem;

import java.io.IOException;
import java.util.Scanner;


public class Main{
    public static void main(String[] args) throws IOException {
        ExpenseTracker tracker = new ExpenseTracker();
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;

        while (!exit) {
            System.out.println("---------------------------------------Expense Tracker Menu---------------------------------------");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Calculate Total Expenses");
            System.out.println("4. Save Expenses to File");
            System.out.println("5. Load Expenses from File");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter category: ");
                    String category = scanner.next();
                    System.out.print("Enter amount: ");
                    double amount = scanner.nextDouble();
                    tracker.addExpense(category, amount);
                }
                case 2 -> tracker.viewExpenses();
                case 3 -> {
                    double totalExpenses = tracker.calculateTotalExpenses();
                    System.out.println("---------------------------------------Total Expenses: $" + totalExpenses+"---------------------------------------");
                }
                case 4 -> {
                    System.out.print("Enter file name to save expenses: ");
                    String saveFileName = scanner.next();
                    tracker.saveExpensesToFile(saveFileName);
                }
                case 5 -> {
                    System.out.print("Enter file name to load expenses from: ");
                    String loadFileName = scanner.next();
                    tracker.loadExpensesFromFile(loadFileName);
                }
                case 6 -> exit = true;
                default -> System.out.println("---------------------------------------Invalid choice. Please try again.---------------------------------------");
            }
        }
    }
}