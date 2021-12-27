package com.pb.gorban.hw14;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private static ArrayList<Socket> clients = new ArrayList<Socket>();

    public static ArrayList<Socket> getClients() {
        return clients;
    }

    static class Handler implements Runnable {
        private final Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String str = in.readLine();
                System.out.println("Запрос от клиента: " + Thread.currentThread().getName());
                System.out.println("\nMSG: " + str);
                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                out.write("Ответ от сервера: " + LocalDateTime.now().toString() + " - " + str);
                System.out.println("SEND: Ответ от сервера: " + LocalDateTime.now().toString() + " - " + str);
                out.close();

                if (str.equals("quit")) {
                    System.out.println("Закрываем соединение с клиентом");
                    System.out.println("------------------");
                    System.out.println();
                    in.close();
                }

                System.out.println("========");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        int port = 1212;
        ServerSocket serverSocket = new ServerSocket(port);
        ExecutorService threadPool = Executors.newFixedThreadPool(10);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            threadPool.submit(new Handler(clientSocket));
        }
    }
}
