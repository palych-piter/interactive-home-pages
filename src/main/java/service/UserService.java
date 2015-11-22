package service;

/**
 * Created by Andrey on 11/18/2015.
 * Service class for the User entity.
 */

import core.User;

import java.util.List;

public interface UserService {
    public void addUser(User p);

    public void updateUser(User p);

    public List<User> listUsers();

    public User getUserById(int id);

    public void removeUser(int id);
}
