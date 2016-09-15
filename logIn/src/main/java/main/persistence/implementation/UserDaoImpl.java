package main.persistence.implementation;

import com.mongodb.*;
import main.persistence.UserDao;
import main.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dantoderici on 07/09/2016.
 */

@Repository

public class UserDaoImpl implements UserDao {

    private Mongo mongo;

    private DB db;

    private DBCollection table;

    public UserDaoImpl() {

        try {
            mongo = new Mongo("LocalHost", 27017);
            db = mongo.getDB("users");
            table = db.getCollection("users");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();

        DBCursor cursor = table.find();

        while (cursor.hasNext()) {
            DBObject object = cursor.next();

            User user = new User(object.get("username").toString(),
                                 object.get("password").toString());

            users.add(user);
        }

        return users;
    }

    public User getUserByUsername(String username) {
        User user = null;

        DBCursor cursor = table.find();

        while (cursor.hasNext()) {
            DBObject object = cursor.next();

            if (username.equals(object.get("username").toString())) {
                user = new User(object.get("username").toString(), object.get("password").toString());
                return user;
            }
        }

        return user;
    }


}
