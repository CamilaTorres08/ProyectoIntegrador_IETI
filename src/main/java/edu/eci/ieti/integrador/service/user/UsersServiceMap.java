package edu.eci.ieti.integrador.service.user;

import edu.eci.ieti.integrador.exception.UserNotFoundException;
import edu.eci.ieti.integrador.repository.user.User;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UsersServiceMap implements UsersService {
    Map<String,User> users = new HashMap<>();
    @Override
    public User save(User user) {
        users.put(user.getId(), user);
        return user;
    }

    @Override
    public User findById(String id) {
        return users.get(id);
    }

    @Override
    public List<User> all() {
        Collection<User> userCollection = users.values();
        return new ArrayList<>(userCollection);
    }

    @Override
    public void deleteById(String id) {
        users.remove(id);
    }

    @Override
    public User update(User user, String userId) {
        users.put(userId, user);
        return user;
    }
}
