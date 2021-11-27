package com.pb.gorban.hw10;

import java.util.Arrays;
import java.util.List;

public class NumBox<T extends Number> {
    private T[] numbers;

    public NumBox(int size) {
        numbers = (T[]) new Number[size];
    }

    public T get(int index) {
        return numbers[index];
    }

    public void add(T number) throws Exception {
        int count = 0;
        for (T x: numbers) {
            if (x == null) {
                numbers[count] = number;
                break;
            } else {
                count++;
                if (count == numbers.length) {
                    throw new Exception("Превышено кол-во элементов >" + numbers.length);
                }
            }
        }
    }

    public int length() {
        int count = 0;
        for (T x: numbers) {
            if (x != null) {
                count++;
            }
        }
        return count;
    }

    public double average() {
        return sum() / length();
    }

    public double sum() {
        double sum = 0;
        for (T x: numbers) {
            sum = sum + x.doubleValue();
        }
        return sum;
    }

    public T max() {
        T max = numbers[0];
        for (int i=1; i<numbers.length; i++) {
            if (numbers[i] instanceof Integer) {
                if (numbers[i].intValue()>max.intValue()) {
                    max = numbers[i];
                }
            }
            if (numbers[i] instanceof Float) {
                if (numbers[i].floatValue()>max.floatValue()) {
                    max = numbers[i];
                }
            }
        }
        return max;
    }
}
