package ogr.kupriyanov.spws.service;

import ogr.kupriyanov.spws.dao.UserDao;
import ogr.kupriyanov.spws.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Component
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    public UserServiceImpl() {
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAll();
    }

    @Override
    public User findUserByLogin(String login) {
        return userDao.findByLogin(login);
    }

    @Override
    public boolean createUser(User user) {
        return userDao.save(user);
    }

    @Override
    public boolean updateUser(User user) {
        return userDao.update(user);
    }

    @Override
    public boolean deleteUser(String login) {
        return userDao.delete(login);
    }
}
