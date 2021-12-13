package com.pb.gorban.hw11;

import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        //получим от пользователя контакт тел книги
        boolean repeatContact;
        PhonesBook book = new PhonesBook();

        do {
            repeatContact = false;
            //добавим контакт в телефонную книгу
            book.addContact(createContact(getUserString("Введите Имя")));
            if (getUserString("Создать еще контакт?\nДля создания следующего контакта введи Y").toLowerCase(Locale.ROOT).equals("y")) {
                repeatContact = true;
            }
        } while (repeatContact);

        demonstrate("Наполнили книгу", book);
        System.out.println();

        //найти контакт
        System.out.println("Хотите найти контакт?");
        if (getUserString("Нажмите Y").toLowerCase(Locale.ROOT).equals("y")) {
            String userSearchString = getUserString("Для поиска контакта введите Имя или Телефон");
            Contact con = book.findContact(userSearchString);
            System.out.println("{" + con.getName() + ": " + con + " }");
        }
        System.out.println();

        //Удалить контакт
        System.out.println("Хотите удалить контакт?");
        if (getUserString("Нажмите Y").toLowerCase(Locale.ROOT).equals("y")) {
            String name = getUserString("Для удаления контакта введите Имя");
            book.deleteContact(name);
            demonstrate("Контакт " + name + " удален", book);
        }

        //Редактировать контакт
        System.out.println("Хотите редактировать контакт?");
        if (getUserString("Нажмите Y").toLowerCase(Locale.ROOT).equals("y")) {
            String name = getUserString("Для редактирования контакта введите Имя");
            if (book.getAllBook().containsKey(name)) {
                String field = getUserString("Выбери поле phone|birth_date|address существующего контакта");
                book.newEditContact(name, field, getUserString("Укажи новое значение поля " + field));
            } else {
                book.edit(name, createContact(name));
            }
            demonstrate("Контакт " + name + " отредактирован", book);
        }

        System.out.println("======SORT=======");
        //вывод всех записей
        demonstrate("before sort", book);
        System.out.println();
        System.out.println();
        System.out.println("after sort");
        for (Map.Entry<String, Contact> me : book.getAllBookSort().entrySet()) {
            System.out.println("{" + me.getKey() + ": " + me.getValue() + "}");
        }
        System.out.println();
        System.out.println("=======================");

        //записать в файл все данные
        System.out.println("Хотите записать в файл все данные?");
        if (getUserString("Нажмите Y/N").toLowerCase(Locale.ROOT).equals("y")) {
            try {
                book.bookToFile(getUserString("Введите имя файла"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
        //загрузка из файла всех данных
        System.out.println("Хотите загрузить данные из файла?");
        if (getUserString("Нажмите Y").toLowerCase(Locale.ROOT).equals("y")) {
            try {
                //book.bookFromCSVFile(getUserString("Введите имя файла: files/XXXXX.txt"));
                TreeMap<String, Contact> newBook = book.bookFromJSON(getUserString("Введите имя файла: files/XXXXX.txt"));
                System.out.println("LOADED:");
                for (Map.Entry<String, Contact> me : newBook.entrySet()) {
                    System.out.println("{" + me.getKey() + ": " + me.getValue() + "}");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static Contact createContact(String name) {
        Contact contact;
        String fio = name;
        boolean repeatPhone;
        //создадим массив номеров и заполним его
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

        //создадим контакт и наполним его
        contact = new Contact(fio, birthDate, phones, address);
        return contact;
    }

    private static String getUserString(String x) {
        Scanner scan = new Scanner(System.in);
        System.out.println(x);
        return scan.nextLine();
    }

    public static void demonstrate(String text, PhonesBook book) {
        System.out.println(text);
        for (Map.Entry<String, Contact> me : book.getAllBook().entrySet()) {
            System.out.println("{" + me.getKey() + ": " + me.getValue() + "}");
        }
        System.out.println("________END_OF_DEMONSTRATE_________");
        System.out.println();
    }
}