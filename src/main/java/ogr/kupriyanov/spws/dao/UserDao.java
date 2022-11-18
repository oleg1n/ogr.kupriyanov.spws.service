package ogr.kupriyanov.spws.dao;

import ogr.kupriyanov.spws.entity.User;

import java.util.List;

public interface UserDao {
    List<User> getAll();

    User findByLogin(String login);

    boolean save(User user);

    boolean update(User user);

    boolean delete(User user);
}
