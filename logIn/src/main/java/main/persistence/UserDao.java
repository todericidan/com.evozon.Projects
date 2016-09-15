package main.persistence;

import main.model.User;

import java.util.List;

/**
 * Created by dantoderici on 09/09/2016.
 */
public interface UserDao {

    public List<User> getAllUsers();

    public User getUserByUsername(String username);


}


