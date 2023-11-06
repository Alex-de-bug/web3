package beans;

import database.UserData;
import database.UserDataDao;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.SessionFactory;
import utils.HibernateUtil;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.util.List;

@Getter
@Setter
@Named(value = "user")
@ApplicationScoped
public class UserDataBean {
    private Double x = (double) 0;
    private Double y = (double) 0;
    private Double r = (double) 0;
    private Boolean hit;
    private List<UserData> resultList;

    private void updateLocal() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        UserDataDao userDataDao = new UserDataDao(sessionFactory);
        resultList = userDataDao.getUserData();
    }
    public void clearTable(){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        UserDataDao userDataDao = new UserDataDao(sessionFactory);
        userDataDao.clearResultTable();
        updateLocal();
    }

    public void saveData() {
        if ((x >= 0 && x <= r / 2) && (y >= 0 && y <= r)){
            hit = true;}
        else if ((x <= 0 && x >= -r) && (y <= 0 && y >=  -r/2)){
            hit = (x>=-r-2*y);}
        else if ((x >= 0 && x <= r) && (y <= 0 && y >= -r)){
            hit = (Math.pow(x, 2) + Math.pow(y, 2) <= Math.pow(r, 2));}
        else{
            hit = false;}
        if(r==0){
            hit = false;
        }

        if (x == null) {
            x = (double) 0;
        } else if (!(x instanceof Number)) {
            x = (double) 0;
        }
        if (y == null) {
            y = (double) 0;
        } else if (!(y instanceof Number)) {
            y = (double) 0;
        }
        if (r == null) {
            r = (double) 0;
        } else if (!(r instanceof Number)) {
            r = (double) 0;
        }



        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        UserDataDao userDataDao = new UserDataDao(sessionFactory);
        userDataDao.saveUserData(x, y, r, hit);
        updateLocal();
    }
}

