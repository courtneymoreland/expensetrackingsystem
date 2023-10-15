package expensetrackingsystem;

import java.io.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ExpenseTracker {
    private ArrayList<Expense> expenses;
    private static final String FILE_NAME = "expenses.txt";

    public ExpenseTracker() {
        expenses = new ArrayList<>();
    }

    public void addExpense(String category, double amount) {
        Expense expense = new Expense(category, amount);
        expenses.add(expense);
        System.out.println("---------------------------------------Expense added: " + category + " - $" + amount+"---------------------------------------");
    }

    public void viewExpenses() {
        System.out.println("---------------------------------------Expenses---------------------------------------");
        for (Expense expense : expenses) {
            System.out.println("---------------------------------------"+expense.getCategory() + " - $" + expense.getAmount()+"---------------------------------------");
        }
    }

    public double calculateTotalExpenses() {
        double total = 0;
        for (Expense expense : expenses) {
            total += expense.getAmount();
        }
        return total;
    }
 public void loadExpensesFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String category = parts[0];
                    double amount = Double.parseDouble(parts[1]);
                    expenses.add(new Expense(category, amount));
                }
            }
            System.out.println("---------------------------------------Expenses loaded from " + fileName+"---------------------------------------");
        } catch (IOException e) {
            System.err.println("---------------------------------------Error loading expenses from file: " + e.getMessage()+"---------------------------------------");
        }
    }
  public void saveExpensesToFile(String fileName) {
        try (PrintWriter writer = new PrintWriter(fileName)) {
            for (Expense expense : expenses) {
                writer.println(expense.getCategory() + "," + expense.getAmount());
            }
            System.out.println("---------------------------------------Expenses saved to " + fileName+"---------------------------------------");
        } catch (IOException e) {
            System.err.println("---------------------------------------Error saving expenses to file: " + e.getMessage()+"---------------------------------------");
        }
    }
  }