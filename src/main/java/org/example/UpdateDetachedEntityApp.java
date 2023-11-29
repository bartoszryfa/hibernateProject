package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class UpdateDetachedEntityApp {

    public static void main(String[] args) {

        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");

        conf.addAnnotatedClass(Employee.class);
        conf.addPackage("pl.bartoszryfa.hibernate.entity");
        conf.addPackage("pl.bartoszryfa.hibernateApp");

        SessionFactory factory = conf.buildSessionFactory();
        Session currentSession = factory.getCurrentSession();

        currentSession.beginTransaction();

        // Retrieve employee with ID 4 from the database
        Employee employee = currentSession.get(Employee.class, 4);
        // Update the first name of the retrieved employee
        employee.setFirstname("Kamil");
        // employee.setLastName("Kowalski");
        // employee.setSalary(30000);

        currentSession.getTransaction().commit();
        factory.close();

        // Display updated employee names
        System.out.println("Updated employee personal data: " + employee);

    }
}
