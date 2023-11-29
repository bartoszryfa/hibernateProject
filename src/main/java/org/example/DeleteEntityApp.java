package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteEntityApp {
    public static void main(String[] args) {

        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");

        conf.addAnnotatedClass(Employee.class);
        conf.addPackage("pl.bartoszryfa.hibernate.entity");
        conf.addPackage("pl.bartoszryfa.hibernateApp");

        SessionFactory factory = conf.buildSessionFactory();
        Session currentSession = factory.getCurrentSession();

        currentSession.beginTransaction();

        // Delete a row from the table
        Employee employee = currentSession.get(Employee.class, 4);
        currentSession.remove(employee);


        currentSession.getTransaction().commit();
        factory.close();


    }
}
