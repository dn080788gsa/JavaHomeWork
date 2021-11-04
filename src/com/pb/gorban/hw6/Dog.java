package com.pb.gorban.hw6;

import java.util.Objects;

public class Dog extends Animal{
    private String name;

    public Dog(String name, String food, String location) {
        super("Собака", food, location);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public void makeNoise() {
        System.out.println(getType() + " " + name + " гавкает");
    }

    @Override
    public void eat() {
        System.out.println(getType() + " " + name + " жадно ест " + getFood());
    }

    @Override
    public String toString() {
        return "type=" + getType() + ", name=" + name +  ", location=" + getLocation() + ", food=" + getFood() ;
    }

    @Override
    public boolean equals(Object obj) {
        /*1. Проверьте*/
        if (obj == this) {
            /*и верните */ return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Dog dog = (Dog) obj;
        return getType() == dog.getType()
                && name == dog.name
                && getFood() == dog.getFood()
                && getLocation() == dog.getLocation();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + getType().hashCode();
        result = prime * result + name.hashCode();
        result = prime * result + getFood().hashCode();
        result = prime * result + getLocation().hashCode();
        return result;
    }


}
