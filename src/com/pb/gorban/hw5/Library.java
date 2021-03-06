package com.pb.gorban.hw5;

public class Library {
    public static void main(String[] args) {
        Book[] books = new Book[3];
        Reader[] readers = new Reader[3];
        //Создадим 3 книги
        books[0] = new Book("Приключения", "Иванов И. И.", "2000 г.");
        books[1] = new Book("Словарь", "Сидоров А. В.", "1980 г.");
        books[2] = new Book("Энциклопедия", "Гусев К. В.", "2010 г.");
        //Создадим 3 читателя
        readers[0] = new Reader("Петров В. В.", 321654, "ФФЕКС", "01.05.1988", "+380991112233");
        readers[1] = new Reader("Иванов С. А.", 89761, "ФФЕКС", "13.11.1990", "+380771112233");
        readers[2] = new Reader("Сидоров И. Ю.", 354694, "ФФЕКС", "21.08.1987", "+380631112233");
        //Покажем список книг
        System.out.println("Список книг:");
        for (int i=0; i<books.length; i++) {
            System.out.println((i+1) + ". " + books[i].name + " (" + books[i].author + ", " + books[i].crDate + ")");
        }
        //Покажем список читателей
        System.out.println();
        System.out.println("Список читателей:");
        for (int i=0; i<readers.length; i++) {
            System.out.println((i+1) + ". Номер " + readers[i].getCustomerNum() + " - " + readers[i].getFullName() + ", факультет: " + readers[i].getFaculty() + ", телефон: " + readers[i].getPhone());
        }
        //Покажем методы
        System.out.println();
        System.out.println("Демонстрация методов:");
        //Создадим список названий
        String[] names = new String[2];
        names[0] = books[2].name;
        names[1] = books[0].name;
        //1
        readers[0].takeBook(1);
        readers[0].returnBook(1);
        System.out.println("------------");
        //2
        readers[1].takeBook(names);
        readers[1].returnBook(names);
        System.out.println("------------");
        //3
        readers[2].takeBook(books);
        readers[2].returnBook(books);
        System.out.println("------------");

    }
}
