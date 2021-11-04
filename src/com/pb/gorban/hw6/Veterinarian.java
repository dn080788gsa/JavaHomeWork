package com.pb.gorban.hw6;

public class Veterinarian {
    public void treatAnimal(Animal animal, int x) {
        String name = "noname";

        if (animal instanceof Dog) {
            Dog dog = (Dog) animal;
            name = dog.getName();
        } else if (animal instanceof Cat) {
            Cat cat = (Cat) animal;
            name = cat.getName();
        } else if (animal instanceof Horse) {
            Horse horse = (Horse) animal;
            name = horse.getName();
        }

        System.out.println("ПАЦИЕНТ " + x + ": " + animal.getType() + " " + name + " кушает " + animal.getFood() + ", живет " + animal.getLocation());
    }
}
