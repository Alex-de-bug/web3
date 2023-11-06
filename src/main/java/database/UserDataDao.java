package database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class UserDataDao {
    private SessionFactory sessionFactory;

    public UserDataDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void saveUserData(Double x, Double y, Double r, Boolean hit) {
        UserData userData = new UserData();
        userData.setX(x);
        userData.setY(y);
        userData.setR(r);
        userData.setHit(hit);

        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(userData);
            transaction.commit();
        }
    }
}

