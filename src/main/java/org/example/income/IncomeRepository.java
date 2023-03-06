package org.example.income;

import org.example.DbConnection;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class IncomeRepository {

    public void createIncome(Income income) {
        Session session = DbConnection.getSession();
        Transaction transaction = session.beginTransaction();
        session.persist(income);
        transaction.commit();
        session.close();
    }

}
