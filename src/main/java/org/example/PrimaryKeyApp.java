package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyApp {
    public static void main(String[] args) {

        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");

        conf.addAnnotatedClass(Employee.class);
        conf.addPackage("pl.bartoszryfa.hibernate.entity");
        conf.addPackage("pl.bartoszryfa.hibernateApp");

        SessionFactory factory = conf.buildSessionFactory();
        Session currentSession = factory.getCurrentSession();

        // Create three employee objects
        Employee employee = new Employee();
        employee.setFirstname("Anna");
        employee.setLastName("Mazurek");
        employee.setSalary(10000);

        Employee employee1 = new Employee();
        employee1.setFirstname("Dominik");
        employee1.setLastName("Król");
        employee1.setSalary(8500);

        Employee employee2 = new Employee();
        employee2.setFirstname("Kamil");
        employee2.setLastName("Ordon");
        employee2.setSalary(3500);

        currentSession.beginTransaction();

        // Save employees to the database
        currentSession.persist(employee);
        currentSession.persist(employee1);
        currentSession.persist(employee2);

        currentSession.getTransaction().commit();
        factory.close();
    }
}
