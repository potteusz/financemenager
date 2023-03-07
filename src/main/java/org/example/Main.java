package org.example;

import org.example.category.Category;
import org.example.category.CategoryRepository;
import org.example.expense.Expense;
import org.example.expense.ExpenseRepository;
import org.example.income.Income;
import org.example.income.IncomeRepository;
import org.example.service.CategoryService;
import org.example.service.ExpenseService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final CategoryRepository categoryRepository = new CategoryRepository();
    private static final CategoryService categoryService = new CategoryService(categoryRepository);

    private static final ExpenseRepository expenseRepository = new ExpenseRepository();

    private static final ExpenseService expenseService = new ExpenseService(expenseRepository);

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
                    List<String> categories = categoryService.findAllCategories();
                    System.out.println(String.join(",", categories));
                    String name = scanner.next();
                    Category name1 = new Category();
                    for(int i = 0; i <= categories.size(); i++) {
                        if(name.equals(categories.get(i))) {
                            name1 = new Category(name);
                            break;
                        }
                    }
                    expenseService.createExpense(b, name1, LocalDate.now(), "komentarz");


                    break;
                case 2:
                    Income income = new Income(2452.12d, LocalDate.now(), "komentarz");
                    IncomeRepository incomeRepository = new IncomeRepository();
                    incomeRepository.insertIncome(income);
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