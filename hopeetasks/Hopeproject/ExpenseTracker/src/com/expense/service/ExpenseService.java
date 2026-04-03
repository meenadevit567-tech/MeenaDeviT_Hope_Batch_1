package com.expense.service;

import com.expense.database.ExpenseDatabase;
import com.expense.model.Expense;
import java.util.List;


public class ExpenseService {
private double budget = 0;
    private ExpenseDatabase database = new ExpenseDatabase();
    public void addExpense(int id, double amount, String category) {
        Expense expense = new Expense(id, amount, category);
        database.addExpense(expense);
        System.out.println("Expense Added Successfully!");
    }

    public void viewExpenses() {
        List<Expense> list = database.getAllExpenses();

        if (list.isEmpty()) {
            System.out.println("No expenses found!");
        } else {
            for (Expense e : list) {
                System.out.println(e);
            }
        }
    }

    public void deleteExpense(int id) {
        boolean result = database.deleteExpense(id);

        if (result) {
            System.out.println("Expense Deleted Successfully!");
        } else {
            System.out.println("Expense not found!");
        }
    }
 public void totalExpense() {
    double total = 0;

    for (Expense e : database.getAllExpenses()) {
        total += e.getAmount();
    }

    System.out.println("Total Expense: " + total);

    if (budget > 0) {
        if (total > budget) {
            System.out.println("ALERT: You exceeded your budget!");
        } else {
            System.out.println("Remaining Budget: " + (budget - total));
        }
    } else {
        System.out.println("Set a budget first!");
    }
}
public void setBudget(double budget) {
    this.budget = budget;
    System.out.println("Budget set successfully!");
}
public void categoryAnalysis() {

    double total = 0;

    java.util.HashMap<String, Double> map = new java.util.HashMap<>();

    for (Expense e : database.getAllExpenses()) {

        total += e.getAmount();

        String cat = e.getCategory().toLowerCase();

        map.put(cat, map.getOrDefault(cat, 0.0) + e.getAmount());
    }

    if (total == 0) {
        System.out.println("No expenses to analyze!");
        return;
    }

    System.out.println("Category Analysis:");

    for (String cat : map.keySet()) {
        double amount = map.get(cat);

        double percent = (amount * 100) / total;
System.out.println(cat.toUpperCase() + ": " + amount + " (" + percent + "%)");
    }
}
}
