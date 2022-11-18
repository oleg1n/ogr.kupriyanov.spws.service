package ogr.kupriyanov.spws.service;

import ogr.kupriyanov.spws.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class SoapWebServiceImpl implements SoapWebService{
    @Autowired
    private UserService userService;

    @Override
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @Override
    public User findUserByLogin(String login) {
        return userService.findUserByLogin(login);
    }

    @Override
    public boolean createUser(User user) {
        return userService.createUser(user);
    }

    @Override
    public boolean updateUser(User user) {
        return userService.updateUser(user);
    }

    @Override
    public boolean deleteUser(User user) {
        return userService.deleteUser(user);
    }
}
