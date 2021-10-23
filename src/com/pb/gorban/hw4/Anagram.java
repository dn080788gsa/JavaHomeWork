package com.pb.gorban.hw4;

import java.util.Arrays;
import java.util.Scanner;

public class Anagram {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //получим данные пользователя
        sendMessage("Введите первую строку");
        String userFirstString = scan.nextLine();
        sendMessage("Введите вторую строку");
        String userSecondString = scan.nextLine();
        //Выведем сообщение после сравнения строк
        if (getFlag(userFirstString, userSecondString)) {
            sendMessage("Анаграмма");
        } else {
            sendMessage("НЕ анаграмма");
        }
    }

    static Boolean getFlag(String str1, String str2) {
        boolean flag = false;
        //подготовим строки для сравнения
        String firstStr = prepareString(str1);
        String secondStr = prepareString(str2);
        //сравним строки
        if (firstStr.equals(secondStr)) flag = true;
        return flag;
    }

    static String prepareString(String str) {
        //оставим только буквы в строках
        String newStr = str.replaceAll("\\W", "").replaceAll("\\d", "");
        char[] letters = newStr.toCharArray();
        //отсортируем строки
        Arrays.sort(letters);
        return String.valueOf(letters);
    }

    static void sendMessage(String str) {
        System.out.println(str);
    }
}
