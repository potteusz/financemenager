package org.example;

import org.example.category.Category;
import org.example.category.CategoryRepository;
import org.example.expense.Expense;
import org.example.expense.ExpenseRepository;
import org.example.income.Income;
import org.example.income.IncomeRepository;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Podaj co chcesz zrobic:");

        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();

        switch (a) {
            case 1:
                Category category = new Category("spozywcze");
                CategoryRepository categoryRepository = new CategoryRepository();
                categoryRepository.createCategory(category);

                Expense expense = new Expense(202.1d, category, LocalDate.now(), "aaaaa");
                ExpenseRepository expenseRepository = new ExpenseRepository();
                expenseRepository.createExpense(expense);
            break;
                case 2:
                Income income = new Income(2452.12d, LocalDate.now(), "komentarz");
                IncomeRepository incomeRepository = new IncomeRepository();
                incomeRepository.createIncome(income);
            break;
        }
    }
}