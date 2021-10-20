package com.pb.gorban.hw3;

import java.util.Arrays;
import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
        //Создаем массив длинной 10
        int[] userArr = new int[10];
        Scanner scan = new Scanner(System.in);
        System.out.println("Наполните массив из 10 элементов");
        int sum = 0;
        int countPositive = 0;
        //Цикл наполнения массива
        for (int i = 0; i < 10; i++) {
            userArr[i] = scan.nextInt();
            sum = sum + userArr[i];
            if (userArr[i] > 0) {
                countPositive++;
            }
        }
        //Выводим значения
        System.out.println("Массив заполнен и равен: " + Arrays.toString(userArr));
        System.out.println("Сумма всех элементов массива = " + sum);
        System.out.println("Кол-во позитивных элементов массива = " + countPositive);

        //Сортируем массив пузырьком
        boolean unsorted = true;All activity
        int temp;
        while (unsorted) {
            unsorted = false;
            for (int i = 0; i < userArr.length - 1; i++) {
                if (userArr[i] > userArr[i + 1]) {
                    temp = userArr[i];
                    userArr[i] = userArr[i + 1];
                    userArr[i + 1] = temp;
                    unsorted = true;
                }
            }
        }
        //Выводим отсортированный массив
        System.out.println("Массив отсортирован: " + Arrays.toString(userArr));

    }
}
