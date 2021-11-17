package com.pb.gorban.hw8;

public class Auth {
    private String login;
    private String password;

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean singUp (String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        if (login.length()<5 || login.length()>20) {
            throw new WrongLoginException("Неподходящий логин");
        }

        if (password.length()<5 || !password.equals(confirmPassword) || !password.matches("(\\d+)|(\\w+)|(_+)") ) {
            throw new WrongPasswordException("Неподходящий пароль");
        }

        setLogin(login);
        setPassword(password);
        System.out.println("Записали пользователя: " + login + " + " + password);

        return true;
    }

    public boolean signIn (String login, String password) throws WrongLoginException {
        if (this.login.equals(login) && this.password.equals(password)) {
            return true;
        }
        throw new WrongLoginException("Ошибка логина или пароля");
    }
}
