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
    @WebResult(name = "returnGetAllUsers", targetNamespace = "")
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

    @WebResult(name = "returnFindUserByLogin", targetNamespace = "")
    @RequestWrapper(
            localName = "FindUserByLogin",
            targetNamespace = "",
            className = "ogr.kupriyanov.spws.service.RequestFindUserByLogin")
    @WebMethod(action = "urn:FindUserByLogin")
    @ResponseWrapper(
            localName = "FindUserByLoginResponse",
            targetNamespace = "",
            className = "ogr.kupriyanov.spws.service.FindUserByLoginResponse")
    User findUserByLogin(@WebParam(name = "login") String login);

    @WebResult(name = "returnCreateUser", targetNamespace = "")
    @RequestWrapper(
            localName = "CreateUser",
            targetNamespace = "",
            className = "ogr.kupriyanov.spws.service.RequestCreateUser")
    @WebMethod(action = "urn:CreateUser")
    @ResponseWrapper(
            localName = "CreateUserResponse",
            targetNamespace = "",
            className = "ogr.kupriyanov.spws.service.CreateUserResponse")
    boolean createUser(@WebParam(name = "name") String name, @WebParam(name = "login") String login,
                        @WebParam(name = "password") String password, @WebParam(name = "roles") List<String> roles);

    @WebResult(name = "returnUpdateUser", targetNamespace = "")
    @RequestWrapper(
            localName = "UpdateUser",
            targetNamespace = "",
            className = "ogr.kupriyanov.spws.service.RequestUpdateUser")
    @WebMethod(action = "urn:UpdateUser")
    @ResponseWrapper(
            localName = "UpdateUserResponse",
            targetNamespace = "",
            className = "ogr.kupriyanov.spws.service.UpdateUserResponse")
    boolean updateUser(@WebParam(name = "name") String name, @WebParam(name = "login") String login,
                       @WebParam(name = "password") String password, @WebParam(name = "roles") List<String> roles);

    @WebResult(name = "returnDeleteUser", targetNamespace = "")
    @RequestWrapper(
            localName = "DeleteUser",
            targetNamespace = "",
            className = "ogr.kupriyanov.spws.service.RequestDeleteUser")
    @WebMethod(action = "urn:DeleteUser")
    @ResponseWrapper(
            localName = "DeleteUserResponse",
            targetNamespace = "",
            className = "ogr.kupriyanov.spws.service.DeleteUserResponse")
    boolean deleteUser(@WebParam(name = "login") String login);
}
