package com.pb.gorban.hw6;

public class Animal {
    private String food;
    private String location;
    private String type = "Животное";

    public Animal(String type, String food, String location) {
        this(food, location);
        this.type = type;
    }

    public Animal(String food, String location) {
        this.food = food;
        this.location = location;
    }

    public String getFood() {
        return this.food;
    }

    public String getLocation() {
        return this.location;
    }

    public String getType() {
        return this.type;
    }

    public void makeNoise() {
        System.out.println(type + " шумит");
    }

    public void eat() {
        System.out.println(type + " ест");
    }

    public void sleep() {
        System.out.println(type + " спит");
    }
}
