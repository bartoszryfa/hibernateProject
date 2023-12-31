package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        // 1. Create a configuration object
        Configuration conf = new Configuration();

        // 2. Load the configuration file
        conf.configure("hibernate.cfg.xml");

        // 3. Load the annotation
        conf.addAnnotatedClass(Employee.class);
        conf.addPackage("pl.bartoszryfa.hibernate.entity");
        conf.addPackage("pl.bartoszryfa.hibernateApp");

        // 4. Create a SessionFactory object
        SessionFactory factory = conf.buildSessionFactory();

        // 5. Obtain a session
        Session currentSession = factory.getCurrentSession();

        // 6. Create an object
        Employee employee = new Employee();
        employee.setFirstname("Adam");
        employee.setLastName("Nowakowski");
        employee.setSalary(2000);

        // 6. Begin a transaction
        currentSession.beginTransaction();

        // 8. Save employee to database
        currentSession.persist(employee);

        // 9. End the session, commit the transaction
        currentSession.getTransaction().commit();

        // 10. Close the SessionFactory object
        factory.close();
    }
}