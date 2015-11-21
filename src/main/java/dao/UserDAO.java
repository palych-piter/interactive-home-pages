package dao;

/**
 * Created by Andrey on 11/18/2015.
 * Implementing a DAO interface for
 * a User class
 */

import core.User;

import java.util.List;

public interface UserDAO {
    public void addUser(User p);

    public void updateUser(User p);

    public List<Message> listUsers();

    public Message getUserById(int id);

    public void removeUser(int id);
}

