package org.management.repository.impl;

import org.management.exception.NotFoundUserException;
import org.management.model.User;
import org.management.query.UserQuery;
import org.management.repository.DbConnector;
import org.management.repository.UserRepo;

import java.sql.*;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class UserRepoImpl extends DbConnector implements UserRepo {

    @Override
    public boolean addUser(User user) {

        try (Connection connect = connectDb()) {

            PreparedStatement statement = connect.prepareStatement(UserQuery.ADD_USER);
            statement.setString(1, user.getName());
            statement.setString(2, user.getSurname());
            statement.setString(3, user.getFin());
            statement.setString(4, user.getSerialNo());
            statement.setInt(5, user.getDeparture());
            statement.setDate(6, user.getRegistrationDate() == null ? null : Date.valueOf(user.getRegistrationDate()));
            statement.setDate(7, user.getExpirationDate() == null ? null : Date.valueOf(user.getExpirationDate()));
            statement.setInt(8, user.getPaymentAmount());
            statement.setInt(9, user.getStatus());


            int cnt = statement.executeUpdate();

            return cnt > 0;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return false;

    }

    //CHANGE TO FIN
    @Override
    public User findUserById(Long id) {
        try (Connection connect = connectDb()) {

            PreparedStatement statement = connect.prepareStatement(UserQuery.FIND_USER_BY_ID);
            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.wasNull()) {
                throw new NotFoundUserException();
            }

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                int departure = resultSet.getInt("departure");
                int status = resultSet.getInt("status");

                return new User(name, surname, departure, status);
            }

            return null;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;

    }

    @Override
    public List<User> findUsers() {
        try (Connection connect = connectDb()) {

            PreparedStatement statement = connect.prepareStatement(UserQuery.FIND_USERS);

            ResultSet resultSet = statement.executeQuery();
            List<User> users = new LinkedList<>();

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String fin = resultSet.getString("fin");
                String serialNo = resultSet.getString("serial_no");
                LocalDate registrationDate = resultSet.getDate("registration_date").toLocalDate();
                LocalDate expirationDate = resultSet.getDate("registration_date").toLocalDate();
                int payment = resultSet.getInt("payment_amount");
                int status = resultSet.getInt("status");

                users.add(new User(name, surname, fin, serialNo, registrationDate, expirationDate, payment, status));
            }

            return users;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;

    }


    @Override
    public boolean updateDeparture(Long id, User user) {
        try (Connection connect = connectDb()) {

            PreparedStatement statement = connect.prepareStatement(UserQuery.UPDATE_DEPARTURE);
            statement.setInt(1, user.getDeparture());
            statement.setDate(2, Date.valueOf(user.getUpdateDate()));
            statement.setDate(3, Date.valueOf(user.getExpirationDate()));


            int val = statement.executeUpdate();

            return val > 0;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean deleteUser(Long id) {
        try (Connection connect = connectDb()) {

            PreparedStatement statement = connect.prepareStatement(UserQuery.DELETE_USER);

            statement.setLong(1, id); // non existed if then throw an exception

            int val = statement.executeUpdate();

            return val > 0;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return false;
    }
}
