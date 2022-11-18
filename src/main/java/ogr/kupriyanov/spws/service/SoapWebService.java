package ogr.kupriyanov.spws.service;

import ogr.kupriyanov.spws.entity.User;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import java.util.List;

@WebService(targetNamespace = "",
            name = "SoapWebService")
public interface SoapWebService {
    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(
            localName = "getAllUsers",
            targetNamespace = "",
            className = "ogr.kupriyanov.spws.service.RequestGetAllUsers")
    @WebMethod(action = "urn:GetAllUsers")
    @ResponseWrapper(
            localName = "getAllUsersResponse",
            targetNamespace = "",
            className = "ogr.kupriyanov.spws.service.GetAllUsersResponse")
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
