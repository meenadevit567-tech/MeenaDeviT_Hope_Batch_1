package com.expense.model;

public class Expense {

    private int id;
    private double amount;
    private String category;

    public Expense(int id, double amount, String category) {
        this.id = id;
        this.amount = amount;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Amount: " + amount + " | Category: " + category;
    }
}