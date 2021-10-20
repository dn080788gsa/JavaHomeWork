package com.pb.gorban.hw3;

import java.io.IOException;
import java.util.Scanner;

public class Bingo {
    public static void main(String[] args) {
        //Создаю и загадываю число [0, 100]
        int rnd = (int) ( Math.random() * 101);
        //Добавляю счетчик и переменную пользователя
        int num;
        int counter = 0;
        //Сообщения пользователю
        System.out.println("***********************");
        System.out.println("Система загадала число");
        System.out.println("Введи число от 0 до 100 и отгадай его");
        System.out.println("______________________________________");
        System.out.println("Для остановки и выхода введи любую букву");
        Scanner scan = new Scanner(System.in);
        //Старт цикла взаимодействия с пользователем
        do {
            //Проверка типа вводимого значения.
            //Если НЕ число, останавливаем и завершаем программу
            try {
                num = Integer.parseInt(scan.next());
            } catch (NumberFormatException e) {
                System.out.println("Выход с приложения");
                break;
            }
            //Обновляем счетчик попыток
            counter++;
            //Проверка условий игры
            if (num == rnd) {
                System.out.println("Бинго! Угадали с " + counter + " попытки");
            } else if (num < rnd && num >= 0 && num <= 100) {
                System.out.println("Загаданное значение больше");
            } else if (num > rnd && num >= 0 && num <= 100) {
                System.out.println("Загаданное значение меньше");
            } else {
                System.out.println("Недопустимое значение");
            }
        } while (num != rnd);

    }
}
