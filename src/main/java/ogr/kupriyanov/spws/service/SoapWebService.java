package ogr.kupriyanov.spws.service;

import ogr.kupriyanov.spws.entity.User;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface SoapWebService {
    @WebMethod
    List<User> getAllUsers();

    @WebMethod
    User findUserByLogin(String login);

    @WebMethod
    boolean createUser(User user);

    @WebMethod
    boolean updateUser(User user);

    @WebMethod
    boolean deleteUser(User user);
}
