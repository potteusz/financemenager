package org.example.expense;

import org.example.DbConnection;
import org.example.category.Category;
import org.example.category.CategoryRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;


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




}
