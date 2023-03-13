package org.example.expense;

import org.example.DbConnection;
import org.example.category.Category;
import org.example.category.CategoryRepository;
import org.example.income.Income;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;


public class ExpenseRepository {


    public void insertExpense(Expense expense) {
        Session session = DbConnection.getSession();
        Transaction transaction = session.beginTransaction();
        session.persist(expense);
        transaction.commit();
        session.close();
    }

    public List<Expense> getAllExpenses() {
        Session session = DbConnection.getSession();
        Query<Expense> query = session.createQuery("select e from Expense e", Expense.class);
        List<Expense> expenses = query.list();
        session.close();
        return expenses;
    }

    public List<Expense> getExpenseByCategory(String category) {
        Session session = DbConnection.getSession();
        Query<Expense> query = session.createQuery("select e from Expense e where e.category.categoryName = :category", Expense.class).setParameter("category", category);
        List<Expense> expenses = query.list();
        session.close();
        return expenses;
    }

    public void removeExpense(Integer id) {
        Session session = DbConnection.getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("delete from Expense where expenseId = :expenseId").setParameter("expenseId", id);
        query.executeUpdate();
        transaction.commit();
        session.close();
    }

    public List<Expense> getExpenseByDate(LocalDate startDate, LocalDate endDate) {
        Session session = DbConnection.getSession();
        List<Expense> expenses = session.createQuery("select e from Expense e where e.date>=?1 and e.date<=?2").setParameter(1, startDate).setParameter(2, endDate).getResultList();
        session.close();
        return expenses;
    }

    public List<Expense> getSumExpenseByCategory(String category) {
        Session session = DbConnection.getSession();
        Query<Expense> query = session.createQuery("select e from Expense e where e.category.categoryName = :category", Expense.class).setParameter("category", category);
        List<Expense> expenses = query.list();
        double sum = expenses.stream().map(Expense::getAmount).reduce(0d, Double::sum);
        int a = expenses.size();
        System.out.println(sum);
        System.out.println(expenses);
        System.out.println(a);
        session.close();
        return expenses;
    }

    public double getSumExpense() {
        Session session = DbConnection.getSession();
        Query query = session.createQuery("select e from Expense e");
        List<Expense> expenses = query.list();
        double sumIncome = expenses.stream().map(Expense::getAmount).reduce(0d, Double::sum);
        System.out.println(sumIncome);
        return sumIncome;
    }




}
