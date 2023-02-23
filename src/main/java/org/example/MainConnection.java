package org.example;

import org.example.category.Category;
import org.example.expense.Expense;
import org.example.income.Income;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class MainConnection {
    private final static Configuration configuration = new Configuration();
    static {
        configuration.addAnnotatedClass(Category.class);
        configuration.addAnnotatedClass(Expense.class);
        configuration.addAnnotatedClass(Income.class);
    }
    private final static ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().build();
    private final static SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

    public static Session getSession() {
        return sessionFactory.openSession();
    }

}
