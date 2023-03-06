package org.example;

import org.example.category.Category;
import org.example.category.CategoryRepository;
import org.example.expense.Expense;
import org.example.expense.ExpenseRepository;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {


        Category category = new Category("spozywcze");
        CategoryRepository categoryRepository = new CategoryRepository();
        categoryRepository.createCategory(category);
        Expense expense = new Expense(202.1d, category, LocalDate.now(), "aaaaa" );
        ExpenseRepository expenseRepository = new ExpenseRepository();
        expenseRepository.createExpense(expense);


    }
}