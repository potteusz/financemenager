package org.example.service;

import org.example.category.Category;
import org.example.expense.Expense;
import org.example.expense.ExpenseRepository;

import java.time.LocalDate;

public class ExpenseService {

    private ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public void createExpense(double amount, Category category, LocalDate date, String comment) {
        Expense expense = new Expense(amount, category, date, comment);
        expenseRepository.insertExpense(expense);
    }

}
