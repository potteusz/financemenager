package org.example.income;

import org.example.DbConnection;
import org.example.expense.Expense;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class IncomeRepository {

    public void insertIncome(Income income) {
        Session session = DbConnection.getSession();
        Transaction transaction = session.beginTransaction();
        session.persist(income);
        transaction.commit();
        session.close();
    }

    public List<Income> getAllIncomes() {
        Session session = DbConnection.getSession();
        Query<Income> query = session.createQuery("select i from Income i", Income.class);
        List<Income> incomes = query.list();
        session.close();
        return incomes;
    }

    public void removeIncome(Integer id) {
        Session session = DbConnection.getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("delete from Income where id = :id").setParameter("id", id);
        query.executeUpdate();
        transaction.commit();
        session.close();
    }

}
