package lab3_web.database;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import lab3_web.entity.Point;

@Named("pointDao")
@ApplicationScoped
public class PointDao {
    public PointDao() {}

    public void savePoint(Point point) {
        try {
            Session session = DatabaseManager.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.persist(point);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }
    }

    public void remove(String sessionID) {
        try {
            Session session = DatabaseManager.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            Query<Point> query = session.createQuery("FROM Point WHERE sessionID = :sessionID", Point.class);
            query.setParameter("sessionID", sessionID);
            Point point = query.getSingleResult();
            // Point point = (Point) session.createCriteria(Point.class)
            //     .add(Restrictions.eq("sessionID", sessionID))
            //     .uniqueResult();
            if (point != null) {
                session.remove(point);
                transaction.commit();
            } else {
                    System.out.println("no point found with that sessionID: " + sessionID);
            }
            session.close();
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }
    }

}