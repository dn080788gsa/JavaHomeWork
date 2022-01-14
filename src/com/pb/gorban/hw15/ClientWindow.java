package com.pb.gorban.hw15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientWindow extends JFrame {
    // адрес сервера
    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 3443;

    private Socket clientSocket;
    private Scanner inMessage;
    private PrintWriter outMessage;
    // Форма
    private JTextField jtfMessage;
    private JTextField jtfName;
    private JTextArea jtaTextAreaMessage;
    private String clientName = "";
    // получаем имя клиента
    public String getClientName() {
        return this.clientName;
    }

    // конструктор
    public ClientWindow() {
        try {
            // подключаемся к серверу
            clientSocket = new Socket(SERVER_HOST, SERVER_PORT);
            inMessage = new Scanner(clientSocket.getInputStream());
            outMessage = new PrintWriter(clientSocket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Задаём настройки элементов на форме
        setBounds(600, 300, 600, 500);
        setTitle("Client");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jtaTextAreaMessage = new JTextArea();
        jtaTextAreaMessage.setEditable(false);
        jtaTextAreaMessage.setLineWrap(true);
        JScrollPane jsp = new JScrollPane(jtaTextAreaMessage);
        add(jsp, BorderLayout.CENTER);
        JPanel bottomPanel = new JPanel(new BorderLayout());
        add(bottomPanel, BorderLayout.SOUTH);
        JButton jbSendMessage = new JButton("Отправить");
        bottomPanel.add(jbSendMessage, BorderLayout.EAST);
        jtfMessage = new JTextField("Введите сообщение: ");
        bottomPanel.add(jtfMessage, BorderLayout.CENTER);
        jtfName = new JTextField("Введите имя: ");
        bottomPanel.add(jtfName, BorderLayout.WEST);

        // обработчик события нажатия кнопки отправки сообщения
        jbSendMessage.addActionListener(e -> {
            // если имя клиента, и сообщение непустые, то отправляем сообщение
            if (!jtfMessage.getText().trim().isEmpty() && !jtfName.getText().trim().isEmpty()) {
                clientName = jtfName.getText();
                sendMsg();
                // фокус на текстовое поле с сообщением
                jtfMessage.grabFocus();
            }
        });
        // при фокусе поле сообщения очищается
        jtfMessage.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                jtfMessage.setText("");
            }
        });
        // при фокусе поле имя очищается
        jtfName.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                jtfName.setText("");
            }
        });
        // в отдельном потоке начинаем работу с сервером
        new Thread(() -> {
            try {
                // бесконечный цикл
                while (true) {
                    // если есть входящее сообщение
                    if (inMessage.hasNext()) {
                        // считываем его
                        String inMes = inMessage.nextLine();
                        jtaTextAreaMessage.append(inMes);
                        // добавляем строку перехода
                        jtaTextAreaMessage.append("\n");
                }
                }
            } catch (Exception e) {
            }
        }).start();
        // добавляем обработчик события закрытия окна клиентского приложения
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                try {
                    // здесь проверяем, что имя клиента непустое и не равно значению по умолчанию
                    outMessage.println(clientName + " вышел из чата!");

                    // отправляем служебное сообщение, которое является признаком того, что клиент вышел из чата
                    outMessage.println("##session##end##");
                    outMessage.flush();
                    outMessage.close();
                    inMessage.close();
                    clientSocket.close();
                } catch (IOException exc) {
                    exc.printStackTrace();
                }
            }
        });
        // отображаем форму
        setVisible(true);
    }

    // отправка сообщения
    public void sendMsg() {
        // формируем сообщение для отправки на сервер
        String messageStr = jtfName.getText() + ": " + jtfMessage.getText();
        outMessage.println(messageStr);
        outMessage.flush();
        jtfMessage.setText("");
    }

}
