package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        // 1. stworzenie obiektu konfiguracyjnego
        Configuration conf = new Configuration();
        // 2. wczytanie pliku konfiguracyjnego
        conf.configure("hibernate.cfg.xml");

        // 3. wczytanie aplikacji
        conf.addAnnotatedClass(Employee.class);
        conf.addPackage("pl.bartoszryfa.hibernate.entity");
        conf.addPackage("pl.bartoszryfa.hibernateApp");

        // 4. stworzenie obiektu sessionFactory
        SessionFactory factory = conf.buildSessionFactory();

        // 5. pobranie sesji
        Session currentSession = factory.getCurrentSession();

        // 6. stworzenie obiektu
        Employee employee = new Employee();
        employee.setId(1);
        employee.setFirstname("Marcin");
        employee.setLastName("Kowalski");
        employee.setSalary(2000);

        // 7. rozpoczęcie transakcji
        currentSession.beginTransaction();

        // 8. zapisanie pracownika
        currentSession.save(employee);

        // 9. zakończenie transakcji
        currentSession.getTransaction().commit();

        // 10. zamkniecie obiektu sessionFactory
        factory.close();
    }
}