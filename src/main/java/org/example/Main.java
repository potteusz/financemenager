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
            System.out.println("Podaj co chcesz zrobic:");

            Scanner scanner = new Scanner(System.in);
            int a = scanner.nextInt();



            switch (a) {
                case 1:
                    System.out.println("Kwota:");
                    double b = scanner.nextDouble();
                    System.out.println("Wybierz kategorię:");
                    List<String> categories = categoryRepository.findAllCategories();
                    System.out.println(String.join(",", categories));
                    String name = scanner.next();
                    System.out.println("Komentarz:");
                    String comment = scanner.next();
                    expenseService.createExpense(b, name, LocalDate.now(), comment);
                    break;
                case 2:
                    System.out.println("Kwota:");
                    double c = scanner.nextDouble();
                    System.out.println("Komentarz");
                    String comment1 = scanner.next();
                    incomeService.createIncome(c, LocalDate.now(), comment1);
                    break;

                case 3:
                    System.out.println("Wybierz wydatek to be removed:");
                    List<Expense> expenses2 = expenseRepository.getAllExpenses();
                    expenses2.forEach(e -> System.out.println(e.toString()));
                    Integer f = scanner.nextInt();
                    expenseRepository.removeExpense(f);
                    break;

                case 4:
                    System.out.println("Select income to be removed:");
                    List<Income> incomes4 = incomeRepository.getAllIncomes();
                    incomes4.forEach(e -> System.out.println(e.toString()));
                    Integer z = scanner.nextInt();
                    incomeRepository.removeIncome(z);
                    break;


                case 5:
                    System.out.println("Wydatki:");
                    List<Expense> expenses1 = expenseRepository.getAllExpenses();
                    expenses1.forEach(e -> System.out.println(e.toString()));
                    System.out.println("Przychody:");
                    List<Income> incomes = incomeRepository.getAllIncomes();
                    incomes.forEach(e -> System.out.println(e.toString()));
                    break;

                case 6:
                    List<Expense> expenses = expenseRepository.getAllExpenses();
                    expenses.forEach(e -> System.out.println(e.toString()));
                    break;

                case 8:
                    System.out.println("Podaj kategorie:");
                    String catName = scanner.next();
                    List<Expense> expenses3 = expenseRepository.getExpenseByCategory(catName);
                    expenses3.forEach(e -> System.out.println(e.toString()));
                    break;

                case 10:
                    System.out.println("Wszystkie przychody:");
                    List<Income> incomes1 = incomeRepository.getAllIncomes();
                    incomes1.forEach(e -> System.out.println(e.toString()));
                    break;

                case 12:
                    System.out.println("Podaj nazwę kategorii:");
                    scanner.nextLine();
                    String categoryName = scanner.nextLine();
                    categoryService.createCategory(categoryName);
                    break;



            }

        }
    }
}