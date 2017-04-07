package repositories;

import model.User;

import java.util.List;

/**
 * Created by Soturi on 2017-04-06.
 */
public interface UserRepository {
    User getUserByEmailAndPassword(String email, String password);
    void addUser(User user);
    List<User> getAllUsers();
    void changeUsersPremiumPermission(String email, boolean premium);
}
