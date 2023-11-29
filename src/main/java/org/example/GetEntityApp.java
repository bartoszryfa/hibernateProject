package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetEntityApp {

    public static void main(String[] args) {

        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");

        conf.addAnnotatedClass(Employee.class);
        conf.addPackage("pl.bartoszryfa.hibernate.entity");
        conf.addPackage("pl.bartoszryfa.hibernateApp");

        SessionFactory factory = conf.buildSessionFactory();
        Session currentSession = factory.getCurrentSession();

        currentSession.beginTransaction();

        // Retrieve employee (id - 1)
        Employee recivedEmployee = currentSession.get(Employee.class, 1);

        currentSession.getTransaction().commit();
        factory.close();

        // Display retrieved employee
        System.out.println("Pracownik: " + recivedEmployee);

    }
}
