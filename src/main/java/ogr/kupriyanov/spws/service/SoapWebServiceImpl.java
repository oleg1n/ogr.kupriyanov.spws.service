package ogr.kupriyanov.spws.service;

import ogr.kupriyanov.spws.entity.Role;
import ogr.kupriyanov.spws.entity.User;
import ogr.kupriyanov.spws.exception.IncorrectParamNewUserException;
import ogr.kupriyanov.spws.utils.FormatLogicalControlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;
@WebService(name = "SoapWebService",
            portName = "MyPort",
            targetNamespace = "",
            endpointInterface = "ogr.kupriyanov.spws.service.SoapWebService")
@Component
public class SoapWebServiceImpl implements SoapWebService{
    @Autowired
    private UserService userService;
    @Autowired
    private FormatLogicalControlUtil formatLogicalControlUtil;

    @Override
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @Override
    public User findUserByLogin(String login) {
        return userService.findUserByLogin(login);
    }

    @Override
    public boolean createUser(String name, String login, String password, List<String> roles) {
        boolean checkParam = false;
        try {
            checkParam = formatLogicalControlUtil.validateParamsNewUser(name, login, password);
        }catch (IncorrectParamNewUserException e){
            e.getMessage();
        }
        if (!checkParam){
            return false;
        }
        User user = new User(name, login, password);
        if (roles != null){
            for (String s : roles){
                user.addRole(new Role(s));
            }
        }
        return userService.createUser(user);
    }

    @Override
    public boolean updateUser(String name, String login, String password, List<String> roles) {
        boolean checkParam = false;
        try {
            checkParam = formatLogicalControlUtil.validateParamsNewUser(name, login, password);
        }catch (IncorrectParamNewUserException e){
            e.getMessage();
        }
        if (!checkParam){
            return false;
        }
        User user = userService.findUserByLogin(login);
        user.setNameUser(name);
        user.setPasswordUser(password);
        if (roles != null){
            if (roles.size() > 1){
                List<Role> newRoles = new ArrayList<>();
                for (String s : roles){
                    newRoles.add(new Role(s));
                }
                user.setRoles(newRoles);
            }else{
                Role role = new Role(roles.get(0));
                user.addRole(role);
            }
        }
        return userService.updateUser(user);
    }

    @Override
    public boolean deleteUser(String login) {
        return userService.deleteUser(login);
    }
}
