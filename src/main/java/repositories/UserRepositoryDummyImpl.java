package repositories;

import model.RoleEnum;
import model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserRepositoryDummyImpl implements UserRepository {

    private static List<User> users;

    public UserRepositoryDummyImpl() {
        if(users == null) {
            users = new ArrayList<User>();
            User admin = new User();
            admin.setUsername("Admin");
            admin.setEmail("admin");
            admin.setPassword("admin");
            admin.setRole(RoleEnum.ADMIN);
            users.add(admin);
        }
    }

    @Override
    public User getUserByEmailAndPassword(String email, String password)
    {
        List<User> result = users.stream()
                .filter(user -> user.getEmail().equals(email) && user.getPassword().equals(password))
                .collect(Collectors.toList());

        if (result.size() > 0) {
            return result.get(0);
        } else return null;
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }

    @Override
    public void changeUsersPremiumPermission(String email, boolean premium) {
        Optional<User> optionalUser = users.stream()
                .filter(u -> u.getEmail().equals(email))
                .findFirst();

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (premium) {
                if (RoleEnum.USER.equals(user.getRole())) {
                    user.setRole(RoleEnum.PREMIUM);
                }
            } else {
                if (RoleEnum.PREMIUM.equals(user.getRole()) || RoleEnum.ADMIN.equals(user.getRole())) {
                    user.setRole(RoleEnum.USER);
                }
            }
        }
    }
}
