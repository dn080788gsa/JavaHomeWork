package com.pb.gorban.hw10;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        System.out.println("FLOAT ------------>");
        NumBox<Float> numArray1 = new NumBox<>(3);
        try {
            numArray1.add(30.6f);
            numArray1.add(1.5f);
            numArray1.add(15.0f);
            numArray1.add(100.0f); //ошибка при добавлении

        } catch(Exception ex) {
            ex.printStackTrace();
        }

        Float x1 = numArray1.get(0);
        Float x2 = numArray1.get(1);
        Float x3 = numArray1.get(2);

        System.out.println("1) " + x1);
        System.out.println("2) " + x2);
        System.out.println("3) " + x3);
        System.out.println();
        System.out.println("SUMM = " + numArray1.sum());
        System.out.println("AVERAGE = " + numArray1.average());
        System.out.println("MAX = " + numArray1.max());
        System.out.println();

        System.out.println("INTEGER ------------>");
        NumBox<Integer> numArray2 = new NumBox<>(2);
        try {
            numArray2.add(100);
            numArray2.add(50);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        int z1 = numArray2.get(0);
        int z2 = numArray2.get(1);


        System.out.println("1) " + z1);
        System.out.println("2) " + z2);
        System.out.println();
        System.out.println("SUMM = " + numArray2.sum());
        System.out.println("AVERAGE = " + numArray2.average());
        System.out.println("MAX = " + numArray2.max());
    }
}
