package com.pb.gorban.hw11;

import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        boolean repeatLoop;
        PhonesBook book = new PhonesBook();
        System.out.println("MENU");
        do {
            repeatLoop = true;
            boolean repeatContact;
            System.out.println("book | add | edit | delete | export | search | load | exit");
            switch (getUserString("Укажите раздел").toLowerCase(Locale.ROOT)) {
                case "book":
                    book.getAllBookSort().entrySet().forEach(el->System.out.println("{" + el.getKey() + ": " + el.getValue() + "}"));
                    System.out.println("=======================");
                    System.out.println();
                    break;
                case "exit":
                    repeatLoop = false;
                    break;
                case "add":
                    do {
                        repeatContact = false;
                        book.addContact(createContact(getUserString("Введите Имя")));
                        if (getUserString("Создать еще контакт?\nДля создания следующего контакта введи Y").toLowerCase(Locale.ROOT).equals("y")) {
                            repeatContact = true;
                        }
                    } while (repeatContact);
                    break;
                case "edit":
                    String name = getUserString("Для редактирования контакта введите Имя");
                    if (book.getAllBook().containsKey(name)) {
                        String field = getUserString("Выбери поле phone|birth_date|address существующего контакта");
                        book.newEditContact(name, field, getUserString("Укажи новое значение поля " + field));
                    } else {
                        book.edit(name, createContact(name));
                    }
                    break;
                case "delete":
                    String n = getUserString("Для удаления контакта введите Имя");
                    book.deleteContact(n);
                    System.out.println("Контакт " + n + " удален");
                    break;
                case "export":
                    try {
                        book.bookToFile(getUserString("Введите имя файла"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case "search":
                    Contact con = book.findContact(getUserString("Для поиска контакта введите Имя или Телефон"));
                    System.out.println("{" + con.getName() + ": " + con + " }");
                    break;
                case "load":
                    try {
                        TreeMap<String, Contact> newBook = PhonesBook.bookFromJSON(getUserString("Введите имя файла: files/XXXXX.txt"));
                        System.out.println("LOADED:");
                        for (Map.Entry<String, Contact> me : newBook.entrySet()) {
                            System.out.println("{" + me.getKey() + ": " + me.getValue() + "}");
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    System.out.println("Неверно указан раздел для перехода");
                    System.out.println();
                    System.out.println("MENU");
                    break;
            }
        } while (repeatLoop);
    }

    public static Contact createContact(String name) {
        boolean repeatPhone;
        ArrayList<String> phones = new ArrayList<>();
        do {
            repeatPhone = false;
            phones.add(getUserString("Введите телефон"));
            System.out.println("Ввести еще номер?");
            if (getUserString("Введите Y для продолжения создания контакта").toLowerCase(Locale.ROOT).equals("y")) {
                repeatPhone = true;
            }
        } while (repeatPhone);
        String birthDate = getUserString("дату рождения");
        String address = getUserString("адрес");

        return new Contact(name, birthDate, phones, address);
    }

    private static String getUserString(String x) {
        Scanner scan = new Scanner(System.in);
        System.out.println(x);
        return scan.nextLine();
    }
}