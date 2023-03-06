package org.example.expense;

import org.example.DbConnection;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class ExpenseRepository {

    public void createExpense(Expense expense) {
        Session session = DbConnection.getSession();
        Transaction transaction = session.beginTransaction();
        session.merge(expense);
        transaction.commit();
        session.close();
    }


}
