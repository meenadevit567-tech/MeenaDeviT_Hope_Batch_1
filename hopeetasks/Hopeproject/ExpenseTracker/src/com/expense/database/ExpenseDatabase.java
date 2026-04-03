package com.expense.database;

import java.util.ArrayList;
import com.expense.model.Expense;

public class ExpenseDatabase {

    private ArrayList<Expense> expenseList = new ArrayList<>();

    public void addExpense(Expense expense) {
        expenseList.add(expense);
    }

    public ArrayList<Expense> getAllExpenses() {
        return expenseList;
    }

    public boolean deleteExpense(int id) {
        for (Expense e : expenseList) {
            if (e.getId() == id) {
                expenseList.remove(e);
                return true;
            }
        }
        return false;
    }
}