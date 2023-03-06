package org.example.category;

import org.example.DbConnection;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CategoryRepository {

    public void createCategory(Category category) {
        Session session = DbConnection.getSession();
        Transaction transaction = session.beginTransaction();
        session.persist(category);
        transaction.commit();
        session.close();
    }

}
