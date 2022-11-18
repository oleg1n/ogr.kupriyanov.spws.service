package ogr.kupriyanov.spws.utils;

import ogr.kupriyanov.spws.exception.IncorrectParamNewUserException;
import org.springframework.stereotype.Component;

@Component
public class FormatLogicalControlUtil {

    public boolean validateParamsNewUser(String name, String login, String password) throws IncorrectParamNewUserException {
        if (name == null || login == null || password == null){
            throw new IncorrectParamNewUserException("Не все обязательные поля заполнены");
        }
        boolean check1 = false;
        boolean check2 = false;
        char[] arrayPassword = password.toCharArray();
        for (Character c : arrayPassword){
            if (Character.isDigit(c)){
                check1 = true;
            }
            if (Character.isUpperCase(c)){
                check2 = true;
            }
        }
        if (!check1){
            throw new IncorrectParamNewUserException("Пароль должен содержать хотя бы одну цифру");
        }
        if (!check2){
            throw new IncorrectParamNewUserException("Пароль должен содержать хотя бы заглавную букву");
        }
        return true;
    }
}
