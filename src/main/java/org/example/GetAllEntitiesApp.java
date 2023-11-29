package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class GetAllEntitiesApp {
    public static void main(String[] args) {

        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");

        conf.addAnnotatedClass(Employee.class);
        conf.addPackage("pl.bartoszryfa.hibernate.entity");
        conf.addPackage("pl.bartoszryfa.hibernateApp");

        SessionFactory factory = conf.buildSessionFactory();
        Session currentSession = factory.getCurrentSession();

        currentSession.beginTransaction();

        // Retrieve all employees
        List resultList = currentSession.createQuery("from Employee").getResultList();

        // Display employees
        for(Object employee : resultList) {
            System.out.println(employee);
        }

        currentSession.getTransaction().commit();
        factory.close();

    }
}
