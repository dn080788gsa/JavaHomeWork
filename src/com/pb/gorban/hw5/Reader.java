package com.pb.gorban.hw5;

public class Reader {
    String fullName;
    int customerNum;
    String faculty;
    String birthDate;
    String phone;

    public Reader(String fullName, int customerNum, String faculty, String birthDate, String phone) {
        this.fullName = fullName;
        this.customerNum = customerNum;
        this.faculty = faculty;
        this.birthDate = birthDate;
        this.phone = phone;
    }

    public void takeBook(int bookCounter) {
        System.out.println(fullName + " взял " + bookCounter + " книгу(и)");
    }

    public void takeBook(String[] names) {
        String books = "";

        for (int i=0; i<names.length; i++) {
            books += names[i];
            if ((i+1)<names.length) books += ", ";
        }

        System.out.println(fullName + " взял книги(у): " + books);
    }

    public void takeBook(Book[] books) {
        String booksStr = "";

        for (int i=0; i<books.length; i++) {
            booksStr += books[i].name + "(" + books[i].author + " " + books[i].crDate + ")";
            if ((i+1)<books.length) booksStr += ", ";
        }

        System.out.println(fullName + " взял книги(у): " + booksStr);
    }

    public void returnBook(int bookCounter) {
        System.out.println(fullName + " вернул " + bookCounter + " книгу(и)");
    }

    public void returnBook(String[] names) {
        String books = "";

        for (int i=0; i<names.length; i++) {
            books += names[i];
            if ((i+1)<names.length) books += ", ";
        }

        System.out.println(fullName + " вернул книги(у): " + books);
    }

    public void returnBook(Book[] books) {
        String booksStr = "";

        for (int i=0; i<books.length; i++) {
            booksStr += books[i].name + "(" + books[i].author + " " + books[i].crDate + ")";
            if ((i+1)<books.length) booksStr += ", ";
        }

        System.out.println(fullName + " вернул книги(у): " + booksStr);
    }

}
