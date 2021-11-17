package com.pb.gorban.hw8;

import java.util.Scanner;

public class OnlineShop {
    public static void main(String[] args) {
        Auth auth = new Auth();
        boolean flagRegister = true;
        boolean flagSingIn = true;
        System.out.println("Добро пожаловать в магазин WWW.SHOP.COM");
        //Цикл регистрации
        while (flagRegister) {
            System.out.println();
            System.out.println("Прошу зарегистрироваться");
            String login = getUserString("Введите логин");
            String password = getUserString("Введите пароль");
            String confirmPassword = getUserString("Подтвердите пароль");


            try {
                if (auth.singUp(login, password, confirmPassword)) {
                    System.out.println("Пользователь " + login + " успешно зарегистрирован");
                    flagRegister = false;
                    System.out.println("Для входа введите логин и пароль");

                    //Цикл входа в аккаунт
                    while (flagSingIn) {
                        try {
                            auth.signIn(getUserString("Введите логин"), getUserString("Введите пароль"));
                            System.out.println("Успешный вход в ситему");
                            flagSingIn = false;
                        } catch (WrongLoginException e) {
                            e.printStackTrace();
                            System.out.println("Ошибка: " + e.getMessage() );
                            if (getUserString("Продолжить? Y/N").equals("N")) {
                                flagSingIn = false;
                            }
                        }

                    }
                    System.out.println("Спасибо за визит");
                }
            } catch (WrongLoginException e) {
                e.printStackTrace();
                System.out.println("Ошибка: " + e.getMessage() );
                if (getUserString("Продолжить? Y/N").equals("N")) {
                    flagRegister = false;
                }
            } catch (WrongPasswordException e) {
                e.printStackTrace();
                System.out.println("Ошибка: " + e.getMessage() );
                if (getUserString("Продолжить? Y/N").equals("N")) {
                    flagRegister = false;
                }
            }
        }
    }

    public static String getUserString(String msg) {
        Scanner scan = new Scanner(System.in);
        System.out.println(msg);
        return scan.nextLine();
    }
}
