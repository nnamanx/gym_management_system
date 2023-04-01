package org.management.repository;

import org.management.model.User;

import java.util.List;

public interface UserRepo {
    boolean addUser(User user);
    User findUserById(Long id);
    List<User> findUsers();
    boolean updateDeparture(Long id, User user);
    boolean deleteUser(Long id);

}
