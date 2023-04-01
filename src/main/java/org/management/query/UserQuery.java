package org.management.query;

public class UserQuery {

    public static final String ADD_USER = "INSERT INTO my_user (name, surname, fin, serial_no, departure, registration_date, expiration_date, payment_amount) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String FIND_USER_BY_ID = "SELECT * FROM my_user WHERE id = ? AND status = 1"; // for entrance
    public static final String FIND_USERS = "SELECT * FROM my_user WHERE status = 1";
    public static final String UPDATE_DEPARTURE = "UPDATE my_user SET departure = ?, update_date = ?, expiration_date = ?, WHERE id = ? and status = 1";
    public static final String DELETE_USER = "UPDATE my_user SET status = 0 WHERE id = ? and status = 1";
}
