package com.pb.gorban.hw4;

import java.util.Scanner;

public class CapitalLetter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        sendMessage("Введите строку для преобразования");
        sendMessage(getUpperCaseString(scan.nextLine()));
    }

    static String getUpperCaseString(String str) {
        //Порежим предложение на слова
        String[] words = str.split(" ");
        //изменим каждое слово
        for (int i=0; i< words.length; i++) {
            words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1);
        }
        return String.join(" ", words);
    }

    static void sendMessage(String str) {
        System.out.println(str);
    }
}
