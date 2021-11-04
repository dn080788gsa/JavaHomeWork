package com.pb.gorban.hw6;

import java.lang.reflect.Constructor;
import java.util.Arrays;

public class VetСlinic {
    public static void main(String[] args) throws Exception {
        Animal[] animals = new Animal[6];
        animals[0] = new Dog("Шарик", "мясо", "на улице");
        animals[1] = new Cat("Маркиз", "мясо", "дома");
        animals[2] = new Horse("Пегас", "траву", "в степи");
        animals[3] = new Dog("Шарик", "мясо", "на улице");
        animals[4] = new Cat("Шарик", "мясо", "на улице");
        animals[5] = new Animal("рыбу", "в море");

        Class visit = Class.forName("com.pb.gorban.hw6.Veterinarian");
        Constructor constructor = visit.getConstructor(new Class[] {});

        System.out.println("Ветеринарный прием:");
        int counter = 1;

        for (Animal a: animals) {
            Object obj = constructor.newInstance();
            if (obj instanceof Veterinarian) {
                ((Veterinarian) obj).treatAnimal(a, counter);
            }
            counter++;
        }

    }
}
