package org.example;

import org.example.category.Category;
import org.example.category.CategoryRepository;
import org.example.expense.Expense;
import org.example.expense.ExpenseRepository;
import org.example.income.Income;
import org.example.income.IncomeRepository;
import org.example.service.CategoryService;
import org.example.service.ExpenseService;
import org.example.service.IncomeService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final CategoryRepository categoryRepository = new CategoryRepository();
    private static final CategoryService categoryService = new CategoryService(categoryRepository);

    private static final ExpenseRepository expenseRepository = new ExpenseRepository();

    private static final ExpenseService expenseService = new ExpenseService(expenseRepository, categoryRepository);
    private static final IncomeRepository incomeRepository = new IncomeRepository();

    private static final IncomeService incomeService = new IncomeService(incomeRepository);


    public static void main(String[] args) {

        while (true) {
            System.out.println("What would you like to do:");
            System.out.println("1 - add new expense");
            System.out.println("2 - add new income");
            System.out.println("3 - remove expense");
            System.out.println("4 - remove income");
            System.out.println("5 - display all expenses and incomes");
            System.out.println("6 - display all expenses");
            System.out.println("8 - display expenses based on category");
            System.out.println("10 - display all incomes");
            System.out.println("12 - add new category");

            Scanner scanner = new Scanner(System.in);
            int a = scanner.nextInt();



            switch (a) {
                case 1:
                    System.out.println("Type amount:");
                    double expAmount = scanner.nextDouble();
                    System.out.println("Select category:");
                    List<String> categories = categoryRepository.findAllCategories();
                    System.out.println(String.join(",", categories));
                    String name = scanner.next();
                    System.out.println("Type comment:");
                    String expComment = scanner.next();
                    expenseService.createExpense(expAmount, name, LocalDate.now(), expComment);
                    break;

                case 2:
                    System.out.println("Type amount:");
                    double incAmount = scanner.nextDouble();
                    System.out.println("Type comment:");
                    String incComment = scanner.next();
                    incomeService.createIncome(incAmount, LocalDate.now(), incComment);
                    break;

                case 3:
                    System.out.println("Select expense to be removed:");
                    List<Expense> expenses = expenseRepository.getAllExpenses();
                    expenses.forEach(e -> System.out.println(e.toString()));
                    Integer remExp = scanner.nextInt();
                    expenseRepository.removeExpense(remExp);
                    break;

                case 4:
                    System.out.println("Select income to be removed:");
                    List<Income> incomes = incomeRepository.getAllIncomes();
                    incomes.forEach(e -> System.out.println(e.toString()));
                    Integer remInc = scanner.nextInt();
                    incomeRepository.removeIncome(remInc);
                    break;

                case 5:
                    System.out.println("Expenses:");
                    List<Expense> expenses1 = expenseRepository.getAllExpenses();
                    expenses1.forEach(e -> System.out.println(e.toString()));
                    System.out.println("Incomes:");
                    List<Income> incomes1 = incomeRepository.getAllIncomes();
                    incomes1.forEach(e -> System.out.println(e.toString()));
                    break;

                case 6:
                    System.out.println("All expenses:");
                    List<Expense> allExpenses = expenseRepository.getAllExpenses();
                    allExpenses.forEach(e -> System.out.println(e.toString()));
                    break;

                case 8:
                    System.out.println("Select category:");
                    String categoryName = scanner.next();
                    List<Expense> expenseByCategory = expenseRepository.getExpenseByCategory(categoryName);
                    expenseByCategory.forEach(e -> System.out.println(e.toString()));
                    break;

                case 10:
                    System.out.println("All incomes:");
                    List<Income> allIncomes = incomeRepository.getAllIncomes();
                    allIncomes.forEach(e -> System.out.println(e.toString()));
                    break;

                case 12:
                    System.out.println("Type new category name:");
                    scanner.nextLine();
                    String newCategory = scanner.nextLine();
                    categoryService.createCategory(newCategory);
                    break;



            }

        }
    }
}