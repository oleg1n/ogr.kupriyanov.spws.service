package ogr.kupriyanov.spws.service;

import ogr.kupriyanov.spws.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User findUserByLogin(String login);

    boolean createUser(User user);

    boolean updateUser(User user);

    boolean deleteUser(User user);
}
