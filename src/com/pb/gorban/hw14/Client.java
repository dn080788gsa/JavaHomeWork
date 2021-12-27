package com.pb.gorban.hw14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {

        boolean repeatClient = true;
        System.out.println("Клиент запущен");
        //Запускаем вечный цикл
        while (repeatClient) {
            String userString = getUserString("Введите текст");
            int portNumber = 1212;
            Socket socket = new Socket("127.0.0.1", portNumber);
            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            if (userString.equalsIgnoreCase("q")) {
                pw.println("quit");
                br.close();
                pw.close();
                socket.close();
                break;
            }

            pw.println(userString);

            String str;
            // Входим в цикл чтения, что нам ответил сервер
            while ((str = br.readLine()) != null) {
                // Печатаем ответ от сервера на консоль для проверки
                System.out.println(str);
            }

        }
        System.out.println("Клиент остановлен");
    }

    private static String getUserString(String x) {
        Scanner scan = new Scanner(System.in);
        System.out.println(x);
        return scan.nextLine();
    }
}
