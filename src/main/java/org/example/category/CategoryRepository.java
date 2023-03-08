package org.example.category;

import org.example.DbConnection;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class CategoryRepository {

    public void insertCategory(Category category) {
        Session session = DbConnection.getSession();
        Transaction transaction = session.beginTransaction();
        session.persist(category);
        transaction.commit();
        session.close();
    }


    public Category findByName(String name) {
        Session session = DbConnection.getSession();
        Query<Category> query = session.createQuery("select c from Category c where c.categoryName = :categoryName", Category.class);
        query.setParameter("categoryName", name);
        Category category = query.uniqueResult();
        session.close();
        return category;
    }

    public List<String> findAllCategories() {
        Session session = DbConnection.getSession();
        Query<String> query = session.createQuery("select c.categoryName from Category c", String.class);
        List<String> categories = query.list();
        session.close();
        return categories;
    }
}
