package com.pb.gorban.hw2;
import java.util.Scanner;

public class Interval {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите значение от 0 до 100");
        int clientInt = scan.nextInt();
        if(clientInt >=0 & clientInt<15) {
            System.out.println("Введенное значение находится в промежутке [0 -14]");
        } else if(clientInt >=15 & clientInt<36) {
            System.out.println("Введенное значение находится в промежутке [15 - 35]");
        } else if(clientInt >=36 & clientInt<51) {
            System.out.println("Введенное значение находится в промежутке [36 - 50]");
        } else {
            System.out.println("Введенное значение находится в промежутке [51 - 100]");
        }
    }
}
