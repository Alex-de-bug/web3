package xyz;
import xyz.Attempt;
import xyz.User;

import java.util.List;

public interface UserDao {
    User findById(int id);

    void save(User user);

    void update(User user);

    void delete(User user);

    Attempt findAutoById(int id);

    List<User> findAll();
}
