package main.service;


import main.persistence.UserDetailsImpl;
import main.model.User;
import main.persistence.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by dantoderici on 09/09/2016.
 */

@Service
public class SecurityService implements UserDetailsService {

    @Autowired
    UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userDao.getUserByUsername(username);

        System.out.println(user);

        if ("null".equals(user.getUsername())) {
            System.out.println("USER NOT FOUND");
            throw new UsernameNotFoundException(username);
        } else {
            System.out.println("USER FOUND");
            UserDetails details = new UserDetailsImpl(user);
            return details;
        }

    }
}
