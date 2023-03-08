package org.example.service;

import org.example.category.Category;
import org.example.category.CategoryRepository;
import org.example.expense.Expense;
import org.example.expense.ExpenseRepository;

import java.time.LocalDate;

public class ExpenseService {

    private ExpenseRepository expenseRepository;
    private CategoryRepository categoryRepository;

    public ExpenseService(ExpenseRepository expenseRepository, CategoryRepository categoryRepository) {
        this.expenseRepository = expenseRepository;
        this.categoryRepository = categoryRepository;
    }

    public void createExpense(double amount, String name, LocalDate date, String comment) {
        Category category = categoryRepository.findByName(name);
        Expense expense = new Expense(amount, category, date, comment);
        expenseRepository.insertExpense(expense);
    }



}
