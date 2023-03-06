package org.example.category;

import org.example.DbConnection;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CategoryRepository {

    public void insertCategory(Category category) {
        Session session = DbConnection.getSession();
        Transaction transaction = session.beginTransaction();
        session.persist(category);
        transaction.commit();
        session.close();
    }

    public static Category createCategory(String categoryName) {
        return new Category(categoryName);
    }



}
