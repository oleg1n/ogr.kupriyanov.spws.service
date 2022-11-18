package ogr.kupriyanov.spws.service;

import ogr.kupriyanov.spws.entity.User;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface SoapWebService {
    @WebMethod
    List<User> getAllUsers();

    @WebMethod
    User findUserByLogin(@WebParam(name = "login") String login);

    @WebMethod
    boolean createUser(@WebParam(name = "name") String name, @WebParam(name = "login") String login,
                        @WebParam(name = "password") String password, @WebParam(name = "roles") List<String> roles);

    @WebMethod
    boolean updateUser(@WebParam(name = "name") String name, @WebParam(name = "login") String login,
                       @WebParam(name = "password") String password, @WebParam(name = "roles") List<String> roles);

    @WebMethod
    boolean deleteUser(@WebParam(name = "login") String login);
}
