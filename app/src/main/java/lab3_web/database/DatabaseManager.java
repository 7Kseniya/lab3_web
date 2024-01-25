package lab3_web.database;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import lab3_web.entity.Point;

public class DatabaseManager{
    private static SessionFactory sessionFactory;

    public DatabaseManager() {}
    public static SessionFactory getSessionFactory() {
        if(sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
                configuration.addAnnotatedClass(Point.class);
                sessionFactory = configuration.buildSessionFactory();
            } catch (Exception e) {
                System.out.println("error: " + e.getMessage());
            }
        }
        return sessionFactory;
    }
}
