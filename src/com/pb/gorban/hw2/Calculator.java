package com.pb.gorban.hw2;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        int operand1;
        int operand2;
        String sign;
        Scanner scan = new Scanner(System.in);

        System.out.println("Введите первое число");
        operand1 = scan.nextInt();
        System.out.println("Ввеедите операцию (+ - * /)");
        sign = scan.next();
        System.out.println("Ввеедите второе число");
        operand2 = scan.nextInt();

        switch(sign) {
            case("+") :
                System.out.println( operand1 + " " + sign + " " + operand2 + " = " + (operand1 + operand2));
                break;
            case("-") :
                System.out.println(operand1 + " " + sign + " " + operand2 + " = " + (operand1 - operand2));
                break;
            case("*") :
                System.out.println(operand1 + " " + sign + " " + operand2 + " = " + (operand1 * operand2));
                break;
            case("/") :
                if (operand2 == 0) {
                    System.out.println("Запрещено делить на 0");
                } else {
                    System.out.println(operand1 + " " + sign + " " + operand2 + " = " + (operand1 / operand2));
                }
                break;
        }
    }
}

