package beans;

import database.UserDataDao;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.SessionFactory;
import utils.HibernateUtil;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Getter
@Setter
@Named(value = "user")
@ApplicationScoped
public class UserDataBean {
    private Double x;
    private Double y;
    private Double r;
    private Boolean hit;

    public void saveData() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        UserDataDao userDataDao = new UserDataDao(sessionFactory);
        userDataDao.saveUserData(x, y, r, hit);
        // Очистить поля формы или выполнить другие действия после сохранения
    }

    // Геттеры и сеттеры для x, y, r
}

