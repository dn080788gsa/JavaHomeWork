package com.pb.gorban.hw13;

import java.util.ArrayList;

public class PubSub {
    public static void main(String[] args) {
        ArrayList queue = new ArrayList();
        new Public(queue).start();
        new Subscribe(queue).start();
    }
}

class Subscribe extends Thread {
    final ArrayList list;

    public Subscribe(ArrayList list) {
        this.list = list;
    }

    public void run() {
        for (;;) {
            synchronized (list) {
                try {
                    if (list.size() <= 5) {
                        list.notify();
                        list.wait();
                    } else {
                        System.out.println();
                        System.out.println("---ВЫЧИТЫВАЕМ ОЧЕРЕДЬ----");
                        list.forEach(System.out::println);
                        list.clear();
                        System.out.println();
                        list.notify();
                        list.wait();
                    }
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class Public extends Thread {
    final ArrayList list;

    public Public(ArrayList list) {
        this.list = list;
    }

    public void run() {
        for (;;) {
            synchronized (list) {
                try {
                    int rnd = (int) ( Math.random() * 1001);
                    sleep(rnd);
                    if (list.size() <= 5) {
                        if (list.size() == 0) System.out.println("---НАПОЛНЯЕМ ОЧЕРЕДЬ---");
                        list.add((int) ( Math.random() * 101));
                        System.out.println("Кол-во в очереди: " + list.size());
                        list.notify();
                        list.wait();
                    } else {
                        System.out.println(getName() + " FULL");
                        list.notify();
                        list.wait();
                    }
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
