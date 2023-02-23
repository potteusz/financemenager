package org.example.expense;

import org.example.MainConnection;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class ExpenseRepository {

    public void createExpense(Expense expense) {
        Session session = MainConnection.getSession();
        Transaction transaction = session.beginTransaction();
        session.persist(expense);
        transaction.commit();
        session.close();
    }


}
