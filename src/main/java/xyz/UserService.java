package xyz;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.util.List;

@Named(value = "userService")
@ApplicationScoped
public class UserService {

    private UserDaoImpl userDaoImpl = new UserDaoImpl();
    private User user = new User();;
    private Attempt attempt = new Attempt();

    public UserService() {
    }


    public User findUser(int id) {
        return userDaoImpl.findById(id);
    }

    public void saveUser() {
        user.setId(1);
        user.setCookie("123");
        userDaoImpl.save(user);
    }

    public void deleteUser(User user) {
        userDaoImpl.delete(user);
    }

    public void updateUser(User user) {
        userDaoImpl.update(user);
    }

    public List<User> findAllUsers() {
        return userDaoImpl.findAll();
    }

    public Attempt findAutoById(int id) {
        return userDaoImpl.findAutoById(id);
    }


}
