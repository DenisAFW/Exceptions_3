import custom_exceptions.WrongLoginException;
import custom_exceptions.WrongPasswdException;

//1.Создать статический метод который принимает на вход три параметра:login,password и confirmPassword.
//2.Login должен содержать только латинские буквы,цифры и знак подчеркивания.
//3.Длина login должна быть меньше 20символов.Если login не соответствует этим требованиям,необходимо выбросить
// WrongLoginException.
//4.Password должен содержать только латинские буквы,цифры и знак подчеркивания.Длина password должна быть
// меньше 20 символов.Также password и confirmPassword должны быть равны.
//5.Если password не соответствует этим требованиям,необходимо выбросить WrongPasswordException.
//6.WrongPasswordException и WrongLoginException-пользовательские классы исключения с двумя конструкторами – один
// по умолчанию,второй принимает сообщение исключения и передает его в конструктор класса Exception.
//7.Обработка исключений проводится внутри метода.
//8.Метод возвращает true,если значения верны или false в другом случае.

import java.util.*;

public class Main {
    public static void main(String[] args) throws WrongLoginException, WrongPasswdException {

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите логин, который ");
        System.out.println("содержит только буквы, числа и");
        System.out.printf("нижнее подчеркивание: ");
        String login = sc.next();
        checkLogin(login);

        System.out.printf("Придумайте папроль, с такими же правилами символов как у логина : ");
        String passwd = sc.next();

        checkPasswd(passwd);

        System.out.printf("Подтвердите пароль: ");
        String confirmPasswd = sc.next();

        checkConfPasswd(passwd, confirmPasswd);
        System.out.println("Регистрация прошла успешно!");
        sc.close();
    }

    private static void checkLogin(String login) throws WrongLoginException {
        if (!login.matches("(\\w+\\d+)|(\\d+\\w+)") | login.length() > 21) {
            throw new WrongLoginException("Неверное содержание логина или превышен лимит символов(20).");
        }
    }

    private static void checkPasswd(String passwd) throws WrongPasswdException {
        if (!passwd.matches("(\\w+\\d+)|(\\d+\\w+)") | passwd.length() > 21) {
            throw new WrongPasswdException("Неверное содержание пароля или превышен лимит символов(20)");
        }
    }

    private static void checkConfPasswd(String passwd, String confirmPasswd) throws WrongPasswdException {
        if (!passwd.equals(confirmPasswd)) {
            throw new WrongPasswdException("Пароли не совпадают!");
        }
    }
}