package org.management.service;

import org.management.model.User;
import org.management.repository.UserRepo;
import org.management.repository.impl.UserRepoImpl;

import java.time.LocalDate;
import java.util.List;

import static org.management.util.Input.*;

public class UserServiceImpl implements UserService {

    private final UserRepo userRepository;

    public UserServiceImpl() {
        userRepository = new UserRepoImpl();
    }


    public User fillUsers() {
        String name = inputString("Enter name: ");
        String surname = inputString("Enter surname: ");
        String fin = inputString("Enter fin: ");
        String serialNo = inputString("Enter serial number: ");
        String registrationDateStr = inputString("Enter registration date (yyyy-MM-dd): ");
//        LocalDate registrationDate = LocalDate.parse(registrationDateStr);
//        java.sql.Date sqlRegistrationDate = java.sql.Date.valueOf(registrationDate);

        return new User(name, surname, fin, serialNo, LocalDate.parse(registrationDateStr), 1);
    }

    @Override
    public void addUser() {

        userRepository.addUser(fillUsers());
    }

    @Override
    public void findUserById() {

        Long id = inputLong("Enter the id: ");
        User user = userRepository.findUserById(id);

        System.out.println(user);

    }

    @Override
    public void findUsers() {

        List<User> users = userRepository.findUsers();
        System.out.println(users);
    }

    @Override
    public boolean updateDeparture() {

        Long id = inputLong("Enter the id: ");
        boolean isUpdated = userRepository.updateDeparture(id, fillUsers());

        return isUpdated;
    }

    @Override
    public void entrance() {

        Long id = inputLong("Enter the id: ");

        if (userRepository.findUserById(id) != null) {
            System.out.println(userRepository.findUserById(id));
        } else System.out.println("REJECTED!");

    }

    @Override
    public void deleteUser() {

        Long id = inputLong("Enter the id: ");
        boolean isDeleted = userRepository.deleteUser(id);

        System.out.println(isDeleted);
    }
}
