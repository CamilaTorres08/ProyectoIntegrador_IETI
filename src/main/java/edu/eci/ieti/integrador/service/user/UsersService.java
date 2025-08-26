package edu.eci.ieti.integrador.service.user;


import edu.eci.ieti.integrador.repository.user.User;

import java.util.List;


public interface UsersService {

    User save(User user);

    User findById(String id);

    List<User> all();

    void deleteById(String id);

    User update(User user, String userId);
}
